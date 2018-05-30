package com.quagmiresystems.euler;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation
 * of the digits 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically,
 * we call it lexicographic order. The lexicographic permutations of 0, 1 and 2 are: 012 021 102 120
 * 201 210 What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8
 * and 9?
 */
public class Problem024LexicographicPermutations {

  public static void main(String[] args) {
    List<Character> digits = new ArrayList<>(10);
    for (int i = 0; i < 10; i++) {
      digits.add(Character.forDigit(i, 10));
    }
    List<String> permutations = EulerUtils.generateAllPermutations("", digits);
    Collections.sort(permutations);
    System.out.println(permutations.get(999_999));
  }

}

