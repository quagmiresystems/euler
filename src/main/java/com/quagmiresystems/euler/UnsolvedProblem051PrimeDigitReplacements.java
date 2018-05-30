package com.quagmiresystems.euler;

import java.util.HashSet;
import java.util.List;

/**
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible
 * values: 13, 23, 43, 53, 73, and 83, are all prime.
 * 
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the
 * first example having seven primes among the ten generated numbers, yielding the family: 56003,
 * 56113, 56333, 56443, 56663, 56773, and 56993. Consequently 56003, being the first member of this
 * family, is the smallest prime with this property.
 * 
 * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits)
 * with the same digit, is part of an eight prime value family.
 */
public class UnsolvedProblem051PrimeDigitReplacements {

  static HashSet<Integer>[][] sets = new HashSet[5][10];

  static {
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 10; j++) {
        sets[i][j] = new HashSet<Integer>();
      }
    }
  }

  public static void main(String[] args) {
    // loop through primes with same # of digits
    // how many contain 1, 2, 3, 4, 5, 6, 7, 8, 9 in first position, second
    // position, etc
    //

    List<Integer> primes = EulerUtils.findPrimesBetween(9_999, 100_000);
    for (Integer prime : primes) {
      int ones = prime % 10;
      sets[0][ones].add(prime);
      int tens = prime % 100 / 10;
      sets[1][tens].add(prime);
      int hundreds = prime % 1_000 / 100;
      sets[2][hundreds].add(prime);
      int thousands = prime % 10_000 / 1_000;
      sets[3][thousands].add(prime);
      int tenThousands = prime % 100_000 / 10_000;
      sets[4][tenThousands].add(prime);
    }
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 10; j++) {
        int size = sets[i][j].size();
        System.out.println("[" + i + "][" + j + "] = " + size);
      }
    }
  }

}
