package com.company.algorithmrsa.rsaaes;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class AlgorithmRSA {
    private Cipher cipher;

    public AlgorithmRSA() throws NoSuchPaddingException, NoSuchAlgorithmException {
        this.cipher = Cipher.getInstance("RSA");
    }

    public void encryptedAESKey(PrivateKey pk, File output, byte[] bytes) throws InvalidKeyException, IOException, IllegalBlockSizeException, BadPaddingException {
        this.cipher.init(Cipher.ENCRYPT_MODE, pk);
        writeToFile(output, this.cipher.doFinal(bytes));
    }

    public void decryptedAesKey(PublicKey pubKey, File output, byte[] bytes) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException {
        this.cipher.init(Cipher.DECRYPT_MODE, pubKey);
        writeToFile(output, this.cipher.doFinal(bytes));
    }

    public byte[] fileToBytes(File f) throws IOException {
        FileInputStream fis = new FileInputStream(f);
        byte[] fileBytes = new byte[(int) f.length()];
        fis.read(fileBytes);
        fis.close();
        return fileBytes;
    }

    public void writeToFile(File output, byte[] bytes) throws IOException {
        FileOutputStream fos = new FileOutputStream(output);
        fos.write(bytes);
        fos.flush();
        fos.close();
    }
}
