package com.quagmiresystems.euler;

 
import java.math.BigInteger;


public class Euler016PowerDigitSum {

    public static void main(String[] args) {
        System.out.println(powerDigitSum(1000));
    }

    public static int powerDigitSum(int exponent) {
        String binary = EulerUtils.rightPadWithZeroes("1", exponent);
        String decimal = new BigInteger(binary,2).toString();
        int sum = 0;
        for(char c : decimal.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        //convert from base 2 to base 10
        //sum the digits
        return sum;
    }

}