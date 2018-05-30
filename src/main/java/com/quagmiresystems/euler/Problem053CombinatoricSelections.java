package com.quagmiresystems.euler;

import java.math.BigInteger;

/**
 * 
 * 
 * There are exactly ten ways of selecting three from five, 12345:
 * 
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 * 
 * In combinatorics, we use the notation, 5C3 = 10.
 * 
 * In general, nCr = n!/r!(n−r)! where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
 * 
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 * 
 * How many, not necessarily distinct, values of nCr, for 1 ≤ n ≤ 100, are greater than one-million?
 * 
 */
public class Problem053CombinatoricSelections {

  public static void main(String[] args) {
    int count = 0;
    for (int n = 1; n <= 100; n++) {
      for (int r = 1; r <= n; r++) {
        if (combinatoricGreaterThanOneMillion(n, r)) {
          count++;
        }
      }
    }
    System.out.println(count);
  }

  private static boolean combinatoricGreaterThanOneMillion(int n, int r) {
    BigInteger numerator = BigInteger.ONE;
    for (int i = 1; i <= n; i++) {
      numerator = numerator.multiply(BigInteger.valueOf(i));
    }
    BigInteger denominator = BigInteger.ONE;
    for (int i = 1; i <= r; i++) {
      denominator = denominator.multiply(BigInteger.valueOf(i));
    }
    for (int i = 1; i <= n - r; i++) {
      denominator = denominator.multiply(BigInteger.valueOf(i));
    }
    BigInteger oneMillion = BigInteger.valueOf(1_000_000);
    BigInteger combinatoric = numerator.divide(denominator);
    return combinatoric.compareTo(oneMillion) > 0;
  }

}
