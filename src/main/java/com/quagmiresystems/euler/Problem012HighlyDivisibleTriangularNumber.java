package com.quagmiresystems.euler;


public class Problem012HighlyDivisibleTriangularNumber {

  public static void main(String[] args) {
    long triNum = 1;
    for (long l = 2;; l++) {
      triNum += l;
      final int numDivisors = EulerUtils.divisors(triNum).size();
      System.out.println(triNum + " has " + numDivisors + " divisors.");
      if (numDivisors >= 500) {
        break;
      }
    }
  }

}
