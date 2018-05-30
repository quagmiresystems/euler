package com.quagmiresystems.euler;

import java.math.BigInteger;

/**
 * 
 * 
 * A googol (10^100) is a massive number: one followed by one-hundred zeros; 100^100 is almost
 * unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits
 * in each number is only 1.
 * 
 * Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?
 * 
 */
public class Problem056PowerfulDigitSum {

  public static void main(String[] args) {
    int maxDigitSum = -1;
    for (int a = 2; a <= 100; a++) {
      BigInteger bia = BigInteger.valueOf(a);
      for (int b = 2; b <= 100; b++) {
        BigInteger product = BigInteger.ONE;
        for (int i = 1; i <= b; i++) {
          product = product.multiply(bia);
        }
        int digitSum = EulerUtils.digitSum(product);
        if (digitSum > maxDigitSum) {
          maxDigitSum = digitSum;
        }
      }
    }
    System.out.println(maxDigitSum);
  }

}
