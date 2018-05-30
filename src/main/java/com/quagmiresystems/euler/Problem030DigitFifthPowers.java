package com.quagmiresystems.euler;

import java.util.HashSet;

/**
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of
 * their digits: 1634 = 14 + 64 + 34 + 44 8208 = 84 + 24 + 04 + 84 9474 = 94 + 44 + 74 + 44 As 1 =
 * 14 is not a sum it is not included. The sum of these numbers is 1634 + 8208 + 9474 = 19316. Find
 * the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */
public class Problem030DigitFifthPowers {

  public static void main(String[] args) {
    HashSet<Integer> dfps = new HashSet<>();
    for (int i = 2; i <= 10000000; i++) {
      if (sumDigitPowers(i, 5)) {
        dfps.add(i);
        System.out.println(i);
      }
    }
    System.out.println(EulerUtils.sumInts(dfps));
  }

  public static boolean sumDigitPowers(int i, int power) {
    String s = i + "";
    int sum = 0;
    for (char c : s.toCharArray()) {
      int current = Integer.parseInt(c + "");
      int product = current;
      for (int j = 2; j <= power; j++) {
        product *= current;
      }
      sum += product;
    }
    return sum == i;
  }

}
