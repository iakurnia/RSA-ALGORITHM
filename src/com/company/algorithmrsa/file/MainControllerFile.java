package com.company.algorithmrsa.file;

import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MainControllerFile {
    public static void main(String[] args) throws NoSuchPaddingException, IOException, NoSuchAlgorithmException, InvalidKeyException {
        System.out.println("Hello World");
        RSAOnlyFile r=new RSAOnlyFile();
//        r.ecnrypFileAESOnly();  coment cause done encrypted
        r.decryptedAesOnly();


    }
}
