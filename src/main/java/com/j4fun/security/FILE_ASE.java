package com.j4fun.security;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public class FILE_ASE {
    private Cipher cipher;
    private Key secretKey;
    
    
    
    public FILE_ASE() {
        try {
            cipher = Cipher.getInstance("AES");
            //cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void decryptFile(String inputFile, String outputFile, Key secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        try (InputStream in = new FileInputStream(inputFile);
             OutputStream out = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[8192];
            int len;
            while ((len = in.read(buffer)) > 0) {
                byte[] decryptedBytes = cipher.update(buffer, 0, len);
                if (decryptedBytes != null) {
                    out.write(decryptedBytes);
                }
            }
            byte[] finalBytes = cipher.doFinal();
            if (finalBytes != null) {
                out.write(finalBytes);
            }
        }
    }
    public static void encryptFile(String inputFile, String outputFile, Key secretKey) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        try (InputStream in = new FileInputStream(inputFile);
             OutputStream out = new FileOutputStream(outputFile)) {
            byte[] buffer = new byte[8192];
            int len;
            while ((len = in.read(buffer)) > 0) {
                byte[] encryptedBytes = cipher.update(buffer, 0, len);
                if (encryptedBytes != null) {
                    out.write(encryptedBytes);
                }
            }
            byte[] finalBytes = cipher.doFinal();
            if (finalBytes != null) {
                out.write(finalBytes);
            }
        }
    }
}
