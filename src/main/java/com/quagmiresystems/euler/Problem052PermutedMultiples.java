package com.quagmiresystems.euler;

/**
 * It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits,
 * but in a different order.
 * 
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
 */
public class Problem052PermutedMultiples {

  public static void main(String[] args) {
    for (int i = 1; i < Integer.MAX_VALUE / 6; i++) {
      if (EulerUtils.sameDigits(i, 2 * i, 3 * i, 4 * i, 5 * i, 6 * i)) {
        System.out.println(i);
        break;
      }
    }

  }

}
