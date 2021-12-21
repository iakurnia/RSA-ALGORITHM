package com.company.algorithmrsa.file;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class RSAOnlyFile {
    public void genKey() throws NoSuchAlgorithmException, IOException {
        String fileBase = "genKey";
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();
        try (FileOutputStream fo = new FileOutputStream(fileBase + ".private")) {
            fo.write(kp.getPrivate().getEncoded());
        }
        try (FileOutputStream fo = new FileOutputStream(fileBase + ".public")) {
            fo.write(kp.getPublic().getEncoded());
        }
        System.out.println("Done Generate Key");
    }

    public void encryptedRSAOnly() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException {
        String privateKey = "genKey.private";
        byte[] bytes = Files.readAllBytes(Paths.get(privateKey));
        PKCS8EncodedKeySpec ksc = new PKCS8EncodedKeySpec(bytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey pk = kf.generatePrivate(ksc);

        Cipher c = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        c.init(Cipher.ENCRYPT_MODE, pk);

        FileInputStream file = new FileInputStream("DataFile/testFile.txt");
        FileOutputStream fo = new FileOutputStream("DataFile/EncryptedTextFile.txt");

        CipherOutputStream cos = new CipherOutputStream(fo, c);
        byte[] b = new byte[1024];
        int read;
        while ((read = file.read(b)) != -1) {
            cos.write(b, 0, read);
        }
        System.out.println("Encrypted Done");
        file.close();
        fo.flush();
        cos.close();
    }

    public  void dencryptedRSAOnly() throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException {
        String publicKey="genKey.public";
        byte[] bytes=Files.readAllBytes(Paths.get(publicKey));
        X509EncodedKeySpec ks=new X509EncodedKeySpec(bytes);
        KeyFactory kf=KeyFactory.getInstance("RSA");
        PublicKey pk=kf.generatePublic(ks);

        Cipher c=Cipher.getInstance("RSA/ECB/PKCS1Padding");
        c.init(Cipher.DECRYPT_MODE,pk);

        FileInputStream file=new FileInputStream("DataFile/EncryptedTextFile.txt");
        FileOutputStream fo=new FileOutputStream("DataFile/DecryptedTextFile.txt");
        CipherOutputStream cos=new CipherOutputStream(fo,c);
        byte[] b=new byte[1024];
        int read;
        while((read = file.read(b))!=-1){
            cos.write(b,0,read);
        }
        System.out.println("Decrypted Done");
        file.close();
        fo.flush();
        cos.close();
    }


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

    public void decryptedAesOnly() throws IOException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
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
