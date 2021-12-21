package com.company.algorithmrsa.file;

import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class MainControllerFile {
    public static void main(String[] args) throws NoSuchPaddingException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        System.out.println("Hello World");
        RSAOnlyFile r=new RSAOnlyFile();
//        r.ecnrypFileAESOnly();  coment cause done encrypted
//        r.decryptedAesOnly(); comment cause done decrypted

        /**
         * encrypt decrypt with algoritm RSA
         * RSA is Rivest-Shamir-Adleman (Cryptosystem)
         * #1 create generator key
         * #2 create encrypt with generate private key
         * #3 create decrypt with generate public key
         * #4 run execute Script
         * #5 Done comit and push
         * */

        r.genKey();
        r.encryptedRSAOnly();
        r.dencryptedRSAOnly();

    }
}
