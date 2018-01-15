package com.quagmiresystems.euler;

 
import java.math.BigInteger;

 
/**
n! means n × (n − 1) × ... × 3 × 2 × 1
For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
Find the sum of the digits in the number 100!
*/
public class Euler020FactorialDigitSum {

    public static void main(String[] args) {
        BigInteger bi = BigInteger.ONE;
        for(int i=2; i<=100;i++) {
            bi = bi.multiply(new BigInteger(i+""));
        }
        int sum = 0;
        for(char c : bi.toString().toCharArray()) {
            sum += Character.digit(c, 10);
        }
        System.out.println(sum);
    }

}

 