package com.j4fun.security;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class FILE_RSA {
    /* Private Key      */    
    private PrivateKey             _privateKey             ;
    /* Public Key       */
    private PublicKey              _publicKey              ;
    /* Encrypt Cipher   */
    private Cipher                 _encryptCipher          ;
    /* Decrypt Cipher   */
    private Cipher                 _decryptCipher          ;
    /* KeyPair Generator*/
    private KeyPairGenerator       _keyPairGenerator       ;
    /* KeyPair          */
    private KeyPair                _keyPair                ;
    /* RSA              */
    public static final String     _instance         ="RSA";
    
    /* Generator Key    */
    private void keyPairGenerator() {
        try {
            this._keyPairGenerator         = KeyPairGenerator.getInstance(_instance);
            this._keyPairGenerator.initialize(2048);
            this._keyPair                  = _keyPairGenerator.generateKeyPair();
            this._publicKey                = _keyPair.getPublic();
            this._privateKey               = _keyPair.getPrivate();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    } 
    
    /* Public           */
    public FILE_RSA() {
        keyPairGenerator();
    }
    public FILE_RSA(PrivateKey privateKey) throws NoSuchAlgorithmException, InvalidKeySpecException                         {
        //keyPairGenerator();
        this._privateKey                   =privateKey;
    }
    public FILE_RSA(PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException                           {
        //keyPairGenerator();
        this._publicKey                    =publicKey;
    }
    public FILE_RSA(String privateKey,String publicKey) throws NoSuchAlgorithmException, InvalidKeySpecException            {
        //keyPairGenerator();
        this._privateKey                   =stringToPrivateKey(privateKey);
        this._publicKey                    =stringToPublicKey(publicKey);
    }
    
    public PrivateKey stringToPrivateKey(String privateKeyString) throws NoSuchAlgorithmException, InvalidKeySpecException  {
        byte[] privateKeyBytes             = Base64.getDecoder().decode(privateKeyString);
        PKCS8EncodedKeySpec keySpec        = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory              = KeyFactory.getInstance(_instance); // Hoặc thuật toán mã hóa tương ứng
        return keyFactory.generatePrivate(keySpec);
    }
    
    public PublicKey stringToPublicKey(String publicKeyString) throws NoSuchAlgorithmException, InvalidKeySpecException     {
        byte[] publicKeyBytes              = Base64.getDecoder().decode(publicKeyString);
        X509EncodedKeySpec keySpec         = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory              = KeyFactory.getInstance(_instance); // Hoặc thuật toán mã hóa tương ứng
        return keyFactory.generatePublic(keySpec);
    }
    
    public String privateKeyToString(PrivateKey privateKey)                                                                 {
        byte[] privateKeyBytes             = privateKey.getEncoded();
        return Base64.getEncoder().encodeToString(privateKeyBytes);
    }
    
    public String publicKeyToString(PublicKey publicKey)                                                                    {
        byte[] publicKeyBytes              = publicKey.getEncoded();
        return Base64.getEncoder().encodeToString(publicKeyBytes);
    }
    
    public void encryptCipher (String plainData) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        _encryptCipher.init(Cipher.ENCRYPT_MODE, _publicKey);
        byte[] encryptedBytes              = _encryptCipher.doFinal(plainData.getBytes());
    }
     
    public File encryptFile(File inputFile, File outputFile) throws Exception                                               {
        _encryptCipher = Cipher.getInstance(_instance);
        _encryptCipher.init(Cipher.ENCRYPT_MODE, _publicKey);

        try (FileInputStream inputStream   = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            byte[] inputBytes              = new byte[100]; // Đọc từng phần dữ liệu (có thể điều chỉnh kích thước)
            int bytesRead;

            while ((bytesRead              = inputStream.read(inputBytes)) != -1) {
                byte[] encryptedBytes      = _encryptCipher.doFinal(inputBytes, 0, bytesRead);
                outputStream.write(encryptedBytes);
            }
        }
        return outputFile;
    }
    
    public File decryptFile(File inputFile, File outputFile) throws Exception                                               {
        _decryptCipher = Cipher.getInstance(_instance);
        _decryptCipher.init(Cipher.DECRYPT_MODE, _privateKey);
        try (FileInputStream inputStream   = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            byte[] inputBuffer             = new byte[256]; // Đọc 256 byte mỗi lần
            int bytesRead;
            while ((bytesRead              = inputStream.read(inputBuffer)) != -1) {
                byte[] decryptedBytes      = _decryptCipher.doFinal(inputBuffer, 0, bytesRead);
                outputStream.write(decryptedBytes);
            }
        }
        return outputFile;
    }
    
    public void set_privateKey(PrivateKey _privateKey)                                                                      {
        this._privateKey                   = _privateKey;
    }
 
    public void set_publicKey(PublicKey   _publicKey)                                                                       {
        this._publicKey                    = _publicKey;
    }
    
    public PublicKey get_publicKey()                                                                                        {
        return _publicKey;
    }
    
    public PrivateKey get_privateKey()                                                                                      {
        return _privateKey;
    }
    
    public static void main(String[] args) {
        FILE_RSA rsa= new FILE_RSA();
        System.out.println(rsa.get_publicKey());
        System.out.println(rsa.get_privateKey());
        try {
            rsa.encryptFile(new File("D:\\catalina.out"), new File("D:\\RSAcatalina.out"));
            try {
                // Chờ 2 phút
                Thread.sleep(2 * 60 * 1000); // 2 phút * 60 giây/phút * 1000 mili giây/giây
            } catch (InterruptedException e) {
                // Xử lý nếu có lỗi trong quá trình chờ
                e.printStackTrace();
            }
            // Tiếp tục thực hiện công việc tiếp theo sau khi đã chờ 2 phút
            rsa.decryptFile(new File("D:\\RSAcatalina.out"), new File("D:\\DOCcatalina.out"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
