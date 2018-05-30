package com.quagmiresystems.euler;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n
 * exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital. The product 7254
 * is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is
 * 1 through 9 pandigital.
 * 
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1
 * through 9 pandigital. HINT: Some products can be obtained in more than one way so be sure to only
 * include it once in your sum.
 */
public class Problem032PandigitalProducts {

  private static Set<Integer> products = new TreeSet<>();

  public static void main(String[] args) {
    for (int multiplicand = 1; multiplicand < 98_765; multiplicand++) {
      if (multiplicand % 1000 == 0) {
        System.out.println(multiplicand);
      }
      for (int multiplier = multiplicand + 1; multiplier < 9_876_544; multiplier++) {
        int product = multiplicand * multiplier;
        if (product > 100_000) {
          // System.out.println("breaking with multiplier " +
          // multiplier);
          break;
        }
        String concat = multiplicand + "" + multiplier;
        if (EulerUtils.potentiallyPandigitalNine(concat)) {
          String rest = rest(concat);

          if (match(rest, product)) {
            System.out
                .println("found a match: " + multiplicand + " * " + multiplier + " = " + product);
            products.add(product);
          }
        }
      }
    }
    int sum = 0;
    for (Integer i : products) {
      sum += i;
    }
    System.out.println(sum);

  }

  private static String rest(String s) {
    String rest = "";
    for (char c = '1'; c <= '9'; c++) {
      if (!s.contains(c + "")) {
        rest += c;
      }
    }
    return rest;
  }

  private static boolean match(String s, int i) {
    char[] sChars = s.toCharArray();
    Arrays.sort(sChars);
    char[] iChars = (i + "").toCharArray();
    Arrays.sort(iChars);
    return Arrays.equals(sChars, iChars);
  }

}
