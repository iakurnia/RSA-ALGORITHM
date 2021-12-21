package com.company.algorithmrsa.rsaaes;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.*;

public class GenerateKey {
    private final static String ALPA_NUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789";
    private String aesKey = "";
    private KeyPairGenerator kpg;
    private KeyPair kp;
    private PrivateKey privateKey;
    private PublicKey publicKey;

    public PublicKey getPublicKey() {
        return this.publicKey;
    }

    public String getAesKey() {
        return this.aesKey;
    }

    public void generateKeyPair() throws NoSuchAlgorithmException, IOException {
        this.kpg = KeyPairGenerator.getInstance("RSA");
        this.kpg.initialize(1024);
        createKeys();
    }

    public void encryptedAesKey() throws NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        AlgorithmRSA rsa = new AlgorithmRSA();
        rsa.encryptedAESKey(this.privateKey, new File("PathKeys/AES_Enrypted.txt"), this.aesKey.getBytes());
    }

    public void decryptedAesKey() throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, IOException, InvalidKeyException {
        AlgorithmRSA rsa = new AlgorithmRSA();
        rsa.decryptedAesKey(this.publicKey, new File("PathKeys/AES_Denrypted.txt"), rsa.fileToBytes(new File("PathKeys/AES_Enrypted.txt")));
    }

    public void createKeys() throws IOException {
        this.kp = this.kpg.generateKeyPair();
        this.privateKey = kp.getPrivate();
        this.publicKey = kp.getPublic();

        writeToFile("PathKeys/publicKey.txt", this.getPublicKey().getEncoded());
        writeToFile("PathKeys/privateKey.txt", this.getPublicKey().getEncoded());
    }

    public void generateKeyRandom() throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(ALPA_NUMERIC.charAt((int) (Math.random() * ALPA_NUMERIC.length())));
        }
        this.aesKey = sb.toString();
        System.out.println("AES Key : " + this.aesKey);
        writeToFile("PathKeys/AES.txt", this.aesKey.getBytes());
    }

    public void writeToFile(String path, byte[] bytes) throws IOException {
        File f = new File(path);
        f.getParentFile().mkdirs();

        FileOutputStream fos = new FileOutputStream(f);
        fos.write(bytes);
        fos.flush();
        fos.close();
    }
}
