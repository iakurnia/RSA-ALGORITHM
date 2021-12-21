package com.company.algorithmrsa.rsaaes;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class AlgorithmAES {
    private static final String ALGORITHM_AES = "AES";
    private static final String TRANSFORMATION_NAME = "AES";

    public static void encryptedAES(String aesKey,File readFile, File writeFile) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, BadPaddingException, InvalidKeyException {
        execute(Cipher.ENCRYPT_MODE,aesKey,readFile,writeFile);
    }

    public static void dencryptedAES(String aesKey,File readFile,File writeFile) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, BadPaddingException, InvalidKeyException {
        execute(Cipher.DECRYPT_MODE,aesKey,readFile,writeFile);
    }

    private static void execute(int chiper, String aesKey, File readFile, File writeFile) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        Key k = new SecretKeySpec(aesKey.getBytes(), ALGORITHM_AES);
        Cipher c = Cipher.getInstance(TRANSFORMATION_NAME);
        c.init(chiper, k);

        FileInputStream fis = new FileInputStream(readFile);
        byte[] readingBytes = new byte[(int) readFile.length()];
        fis.read(readingBytes);

        byte[] writeBytes = c.doFinal(readingBytes);
        FileOutputStream fos = new FileOutputStream(writeFile);
        fos.write(writeBytes);

        fis.close();
        fos.close();
    }
}
