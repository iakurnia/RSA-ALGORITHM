package com.company.algorithmrsa.rsaaes;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class MainController {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        System.out.println("Combination RSA AND AES ALGORITHM FOR ENCRYPT & DECRYPT");
        /**
         * Combination Logic Algorithm AES and RSA
         * #1 Generate KeyRandom
         * #2 Generate KeyPair *private and public key
         * #3 encrypt AES Key
         * #4 decrypte AES Key
         * #5 ecnrypt Algorithm AES
         * #6 done commit and push
         * */
        GenerateKey gk = new GenerateKey();
        gk.generateKeyRandom();
        gk.generateKeyPair();
        gk.encryptedAesKey();
        gk.decryptedAesKey();

        File readFile=new File("DataFile/testFileIaKurnia.txt");
        File encryptFile=new File("DataFile/encryptTestFileIaKurnia.txt");
        File dencryptFile=new File("DataFile/dencryptTestFileIaKurnia.txt");


        AlgorithmAES.encryptedAES(gk.getAesKey(),readFile,encryptFile);
        AlgorithmAES.dencryptedAES(gk.getAesKey(),encryptFile,dencryptFile);
    }
}
