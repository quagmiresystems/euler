package com.quagmiresystems.euler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The prime 41, can be written as the sum of six consecutive primes: 41 = 2 + 3 + 5 + 7 + 11 + 13
 * 
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 * 
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms,
 * and is equal to 953.
 * 
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */
public class Problem050ConsecutivePrimeSum {

  public static void main(String[] args) {
    int bestCount = 1;
    List<Integer> primesList = EulerUtils.findPrimesBetween(1, 1_000_000);
    Set<Integer> primesSet = new HashSet<>(primesList);
    for (int i = 0; i < primesList.size() - 1; i++) {
      int sum = primesList.get(i);
      int count = 1;
      // System.out.println("-------");
      // System.out.println("sum: " + sum + " | count: " + count);
      for (int j = i + 1; sum < 1_000_000; j++) {
        sum += primesList.get(j);
        count++;
        if (primesSet.contains(sum)) {
          if (count > bestCount) {
            bestCount = count;
            System.out.println("found a better count: " + count);
          }
          if (count == 543) {
            System.out
                .println("prime: " + primesList.get(i) + " | count: " + count + " | sum: " + sum);
          }
          //
        }
      }
    }
  }

}
