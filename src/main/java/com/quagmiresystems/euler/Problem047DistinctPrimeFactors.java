package com.quagmiresystems.euler;

import java.util.ArrayList;
import java.util.List;

/**
 * The first two consecutive numbers to have two distinct prime factors are:
 * 
 * 14 = 2 × 7 15 = 3 × 5
 * 
 * The first three consecutive numbers to have three distinct prime factors are:
 * 
 * 644 = 2² × 7 × 23 645 = 3 × 5 × 43 646 = 2 × 17 × 19.
 * 
 * Find the first four consecutive integers to have four distinct prime factors each. What is the
 * first of these numbers?
 */
public class Problem047DistinctPrimeFactors {

  public static void main(String[] args) {
    int candidate = 210;
    ArrayList<List<Integer>> candidates = new ArrayList<>();
    candidates.add(EulerUtils.primeFactors(candidate));
    candidates.add(EulerUtils.primeFactors(candidate + 1));
    candidates.add(EulerUtils.primeFactors(candidate + 2));
    candidates.add(EulerUtils.primeFactors(candidate + 3));
    while (!allHaveFourDistinctPrimes(candidates)) {
      candidate++;
      candidates.set(0, candidates.get(1));
      candidates.set(1, candidates.get(2));
      candidates.set(2, candidates.get(3));
      candidates.set(3, EulerUtils.primeFactors(candidate + 3));
      System.out.println(candidate);
    }
    System.out.println(candidate);
  }

  static boolean allHaveFourDistinctPrimes(ArrayList<List<Integer>> candidates) {
    return EulerUtils.numDistinctPrimes(candidates.get(0)) == 4
        && EulerUtils.numDistinctPrimes(candidates.get(1)) == 4
        && EulerUtils.numDistinctPrimes(candidates.get(2)) == 4
        && EulerUtils.numDistinctPrimes(candidates.get(3)) == 4;
  }

}
