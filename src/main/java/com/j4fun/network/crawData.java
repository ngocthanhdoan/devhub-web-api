package com.j4fun.network;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.JsonObject;

public class crawData {

	private static final String prefix_url = "http://cohoc.net/";

	private static final String prefix_url_64_que_dich = "64-que-dich.html";

	private static final String _in = "* Nội";

	private static final String _out = "* Ngoại";

	private static final String _image = "image";

	// https://zalo.me/0706688336
	public static void main(String[] args) {
		// init();
		// zaloInfo("0706688336");
		getJsonData(prefix_url + "son-hoa-bi-kid-22.html");
	}

	private static void zaloInfo(String phone) {
		try {
			Document document = Jsoup.connect("https://zalo.me/" + phone).get();
			// System.out.println(document);
			Elements script = document.select("script");
			System.out.println(script);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static String convertToSlug(String input) {
		// Normalize the string to remove accents
		String normalized = Normalizer.normalize(input, Normalizer.Form.NFD)
				.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");

		// Replace special characters with hyphens
		String slug = normalized.replaceAll("[^a-zA-Z0-9\\s-]", "").replaceAll("\\s+", "-").toLowerCase();

		// Remove leading and trailing hyphens
		slug = slug.replaceAll("^-|-$", "");

		return slug;
	}

	private static void getJsonData(String url) {
		try {
			Document document = Jsoup.connect(url).get();
			Elements elementsInNoidungDiv = document.select("p");
			List<TreeMap<String, String>> paragraphs = new ArrayList<TreeMap<String, String>>();
			TreeMap<String, String> treeMap = new TreeMap<String, String>();
			for (int i = 0; i < elementsInNoidungDiv.size(); i++) {

				Element e = elementsInNoidungDiv.get(i);
				try {
					
					String key = convertToSlug(e.getAllElements().get(1).text());
					String value = e.getAllElements().get(0).text().replace(key, "");

					if (!key.equals("")) {
						if (!value.equals("")) {

							int index = 1;
							// Kiểm tra xem key đã tồn tại trong treeMap chưa
							if (treeMap.containsKey(key)) {
								// Nếu key đã tồn tại, thêm index vào key
								key = key + "-" + index;
								index++; // Tăng index cho key tiếp theo
								treeMap.put(key, value);
							}else {
								treeMap.put(key, value);
							}
							
							
						}
					}
				} catch (Exception e2) {

					// System.out.println(e.getAllElements().get(1));
				}

				JsonObject jsonObject = new JsonObject();
				String key = "paragraph" + (i + 1);
				String value = e.text();
				jsonObject.addProperty(key, value);
				// paragraphs.add(jsonObject);
			}
			System.out.println(treeMap);
//			for (TreeMap<String, String> jsonObject : paragraphs) {
//				System.out.println(jsonObject);
//			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void crawData(String url, String nameFile) {
		try {
			Document document = Jsoup.connect(url).get();
			Elements elementsInNoidungDiv = document.select("p");
			BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile + ".txt"));

			for (Element element : elementsInNoidungDiv) {
				writer.write(element.text());
				writer.newLine(); // Add a new line after each <p> element's text
			}
			writer.close(); // Don't forget to close the writer
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private static void init() {
		try {
			// Thực hiện yêu cầu HTTP GET và lấy nội dung của trang web
			Document document = Jsoup.connect(prefix_url + prefix_url_64_que_dich).get();
			Elements links = document.select("a");
			for (Element link : links) {
				String href = link.attr("href");
				String text = link.text();
				if (text.startsWith("Quẻ ")) {
					System.out.println("Link: " + prefix_url + href);
					System.out.println("Text: " + text);
					crawData(prefix_url + href, text.replaceAll(":", ""));
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
