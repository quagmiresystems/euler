package com.quagmiresystems.euler;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n
 * exactly once. For example, 2143 is a 4-digit pandigital and is also prime.
 * 
 * What is the largest n-digit pandigital prime that exists?
 */
public class Problem041PandigitalPrime {

  public static void main(String[] args) {
    for (int i = 12; i < 100000000; i++) {
      if (EulerUtils.isPrime(i) && EulerUtils.isPandigital(i)) {
        System.out.println(i);
      }
    }

  }

}
