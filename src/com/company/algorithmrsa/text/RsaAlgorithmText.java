package com.company.algorithmrsa.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

public class RsaAlgorithmText {
    static int gcd(int param1, int param2) {
        if (param1 == 0) {
            return param2;
        } else {
            return gcd(param2 % param1, param1); // rekursif
        }
    }

    static void rsaTextManual(String param) {
        int p, q, n, z, e, d = 0;
        System.out.println("Algorithm RSA for Text");
        Random r;
        int bitlength = 8;
        int msg = 73; // ASCHII CODE
        double c;
        BigInteger msgBack, result;

        r = new Random();
        p = BigInteger.probablePrime(bitlength, r).intValue();
        q = BigInteger.probablePrime(bitlength, r).intValue();

        System.out.println("P is : " + p + "\nQ is : " + q);
        n = p * q;
        z = (p - 1) * (q - 1);
        System.out.println("N is : " + n + "\nZ is : " + z);

        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1) {
                break;
            }
        }

        e = 7;
        System.out.println("E is : " + e);
        for (int i = 0; i < 9; i++) {
            int x = 1 + (i * z);

            if (x % e == 0) {
                d = x / e;
                break;
            }
        }

        System.out.println("D is : " + d);
        char[] msgTemp = param.toCharArray();
        String temp1 = "", temp2 = "";

        for (char ch : msgTemp) {
            c = (Math.pow(ch, e)) % n;
            result = BigDecimal.valueOf(c).toBigInteger();
            temp1 += String.valueOf(result);

            BigInteger N = BigInteger.valueOf(n);

            BigInteger C = BigDecimal.valueOf(c).toBigInteger();
            msgBack = (C.pow(d)).mod(N);

            /**
             * decrypt for value
             * System.out.println("Decrypted : "+msgBack + " Char "+Character.toString((char)msgBack.intValue())); // coment value for decrypted
             * */

            temp2 += String.valueOf(Character.toString((char) msgBack.intValue()));
        }

        System.out.println("Encrypt Message : " + param + " is : " + temp1);
        System.out.println("Dencrypt Message : " + temp1 + " is : " + temp2);

    }
}
