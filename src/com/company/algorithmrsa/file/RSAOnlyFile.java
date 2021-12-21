package com.company.algorithmrsa.file;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class RSAOnlyFile {
    public void ecnrypFileAESOnly() throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        /**
         * AES is Advance Encryption Standar
         */
        FileInputStream file = new FileInputStream("DataFile/java.png");
        FileOutputStream fo = new FileOutputStream("DataFile/EncryptedJava.png");
        byte k[] = "Cool2116NiTh5252".getBytes();
        SecretKeySpec key = new SecretKeySpec(k, "AES");
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        CipherOutputStream cos = new CipherOutputStream(fo, c);

        byte[] buf = new byte[1024];
        int read;
        while ((read = file.read(buf)) != -1) {
            cos.write(buf, 0, read);
        }
        file.close();
        fo.flush();
        cos.close();

    }

    public  void decryptedAesOnly() throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        FileInputStream file = new FileInputStream("DataFile/EncryptedJava.png");
        FileOutputStream fo = new FileOutputStream("DataFile/DencryptedJava.png");
        byte k[] = "Cool2116NiTh5252".getBytes(); // default value
        SecretKeySpec key = new SecretKeySpec(k, "AES");
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, key);
        CipherOutputStream cos = new CipherOutputStream(fo, c);

        byte[] buf = new byte[1024];
        int read;
        while ((read = file.read(buf)) != -1) {
            cos.write(buf, 0, read);
        }
        file.close();
        fo.flush();
        cos.close();
    }
}
