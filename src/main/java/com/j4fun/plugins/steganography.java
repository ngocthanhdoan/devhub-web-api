package com.j4fun.plugins;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.imageio.ImageIO;

public class steganography {
    private static void hideDataInImageCorner(String imagePath, String dataToHide, String outputImagePath) {
        try {
            // Đọc hình ảnh từ tập tin
            BufferedImage image = ImageIO.read(new File(imagePath));

            // Chọn vùng góc bên trái của hình ảnh
            int startX = 0; // Vị trí bắt đầu theo chiều ngang
            int startY = 0; // Vị trí bắt đầu theo chiều dọc
            int width = 50; // Chiều rộng của vùng góc bên trái
            int height = 50; // Chiều cao của vùng góc bên trái

            // Chuyển đổi dữ liệu cần ẩn thành mảng byte sử dụng UTF-8
            byte[] dataBytes = dataToHide.getBytes(StandardCharsets.UTF_8);

            // Ẩn dữ liệu vào hình ảnh
            hideDataInImage(image, dataBytes, startX, startY, width, height);

            // Lưu hình ảnh mới
            File outputImageFile = new File(outputImagePath);
            ImageIO.write(image, "png", outputImageFile);

            System.out.println("Data hidden successfully in the corner of the image.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void hideDataInImage(BufferedImage image, byte[] data, int startX, int startY, int width, int height) {
        int dataLength = data.length;
        int dataCounter = 0;

        // Ẩn dữ liệu vào các pixel của vùng đã chọn
        for (int y = startY; y < startY + height && dataCounter < dataLength; y++) {
            for (int x = startX; x < startX + width && dataCounter < dataLength; x++) {
                int rgb = image.getRGB(x, y);

                // Lấy giá trị màu của mỗi kênh (R, G, B)
                int r = (rgb >> 16) & 0xFF;
                int g = (rgb >> 8) & 0xFF;
                int b = rgb & 0xFF;

                // Ẩn byte dữ liệu vào phần LSB của mỗi kênh màu
                r = (r & 0xFE) | ((data[dataCounter] >> 7) & 1);
                g = (g & 0xFE) | ((data[dataCounter] >> 6) & 1);
                b = (b & 0xFE) | ((data[dataCounter] >> 5) & 1);

                // Ghi lại giá trị màu mới vào pixel
                int newRgb = (rgb & 0xFF000000) | (r << 16) | (g << 8) | b;
                image.setRGB(x, y, newRgb);

                // Di chuyển sang byte tiếp theo trong dữ liệu
                dataCounter++;
            }
        }
    }

    private static String extractDataFromImageCorner(String imagePath, int startX, int startY, int width, int height) {
        try {
            // Đọc hình ảnh từ tập tin
            BufferedImage image = ImageIO.read(new File(imagePath));

            // Trích xuất dữ liệu từ vùng góc bên trái của hình ảnh
            byte[] extractedData = extractData(image, startX, startY, width, height);

            // Chuyển đổi mảng byte thành chuỗi sử dụng UTF-8
            String hiddenData = new String(extractedData, StandardCharsets.UTF_8);

            return hiddenData;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] extractData(BufferedImage image, int startX, int startY, int width, int height) {
        int dataLength = (width * height) / 8; // Mỗi pixel chứa 1 bit dữ liệu
        byte[] extractedData = new byte[dataLength];
        int dataCounter = 0;

        // Trích xuất dữ liệu từ các pixel của vùng đã chọn
        for (int y = startY; y < startY + height && dataCounter < dataLength; y++) {
            for (int x = startX; x < startX + width && dataCounter < dataLength; x++) {
                int rgb = image.getRGB(x, y);

                // Lấy giá trị LSB của mỗi kênh màu (R, G, B) và ghép lại để tạo ra byte dữ liệu
                int r = (rgb >> 16) & 1;
                int g = (rgb >> 8) & 1;
                int b = rgb & 1;
                int dataByte = (r << 7) | (g << 6) | (b << 5);

                // Lưu byte dữ liệu vào mảng trích xuất
                extractedData[dataCounter / 8] |= (byte) (dataByte << (7 - dataCounter % 8));

                // Di chuyển sang bit tiếp theo trong mảng trích xuất
                dataCounter++;
            }
        }
        return extractedData;
    }


    public static void main(String[] args) {
        // Đường dẫn đến hình ảnh PNG
        String imagePath = "D:\\snapdatatoimage.png";
        // Dữ liệu cần ẩn vào hình ảnh
        String dataToHide = "123456";
        // Đường dẫn đến hình ảnh sau khi đã ẩn dữ liệu
        String outputImagePath = "D:\\output_image.png";

        // Ẩn dữ liệu vào góc bên trái của hình ảnh và lưu lại
        hideDataInImageCorner(imagePath, dataToHide, outputImagePath);

        int startX = 0;
        int startY = 0;
        int width = 50;
        int height = 50;

        // Trích xuất dữ liệu từ vùng cụ thể của hình ảnh và hiển thị nó
        String hiddenData = extractDataFromImageCorner(imagePath, startX, startY, width, height);
        
        if (hiddenData != null) {
            System.out.println("Extracted hidden data: " + hiddenData);
        } else {
            System.out.println("Failed to extract hidden data from the image.");
        }
    }
}
