package com.quagmiresystems.euler;

import java.math.BigInteger;

/**
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * 
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */
public class Problem048SelfPowers {

  public static void main(String[] args) {
    BigInteger sum = BigInteger.ZERO;
    for (int i = 1; i <= 1000; i++) {
      BigInteger total = new BigInteger("" + i);
      BigInteger ibi = new BigInteger("" + i);
      for (int j = 1; j < i; j++) {
        total = total.multiply(ibi);
      }
      sum = sum.add(new BigInteger("" + total));
    }
    System.out.println(sum);
  }

}
