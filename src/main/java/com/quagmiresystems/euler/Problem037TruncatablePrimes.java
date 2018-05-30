package com.quagmiresystems.euler;

import static com.quagmiresystems.euler.EulerUtils.isPrime;
import static com.quagmiresystems.euler.EulerUtils.allPrime;
import static com.quagmiresystems.euler.EulerUtils.truncations;
import java.util.ArrayList;
import java.util.List;

/**
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously
 * remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly
 * we can work from right to left: 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to
 * left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */
public class Problem037TruncatablePrimes {

  public static void main(String[] args) {
    int sum = 0;
    List<Integer> truncatablePrimes = new ArrayList<>();
    int current = 23;
    while (truncatablePrimes.size() < 11) {
      if (isPrime(current) && allPrime(truncations(current))) {
        truncatablePrimes.add(current);
        sum += current;
        System.out.println(current + " is a truncatable prime");
      }
      current++;
    }
    System.out.println(sum);
  }

}
