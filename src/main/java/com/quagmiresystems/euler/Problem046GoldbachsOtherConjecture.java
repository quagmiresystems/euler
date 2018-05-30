package com.quagmiresystems.euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum
 * of a prime and twice a square.
 * 
 * 9 = 7 + 2×1^2 15 = 7 + 2×2^2 21 = 3 + 2×3^2 25 = 7 + 2×3^2 27 = 19 + 2×2^2 33 = 31 + 2×1^2
 * 
 * It turns out that the conjecture was false.
 * 
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a
 * square?
 */
public class Problem046GoldbachsOtherConjecture {

  public static void main(String[] args) {
    int composite = 33;
    Set<Integer> sums = sumsOfPrimeAndTwiceASquare();
    while (sums.contains(composite)) {
      System.out.println(composite);
      composite = EulerUtils.nextOddCompositeAfter(composite);
    }
    System.out.println(composite);
  }

  static Set<Integer> sumsOfPrimeAndTwiceASquare() {
    List<Integer> primes = new ArrayList<>();
    int currentPrime = 2;
    primes.add(currentPrime);
    while (primes.size() < 1000) {
      int nextPrime = EulerUtils.nextPrimeAfter(currentPrime);
      currentPrime = nextPrime;
      primes.add(currentPrime);
    }
    List<Integer> twiceSquares = new ArrayList<>();
    for (int i = 1; i < 1000; i++) {
      twiceSquares.add(2 * i * i);
    }
    Set<Integer> sums = new HashSet<>();
    for (Integer prime : primes) {
      for (Integer twiceSquare : twiceSquares) {
        sums.add(prime + twiceSquare);
      }
    }
    return sums;
  }

}
