package com.quagmiresystems.euler;

/**
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * 
 * 192 × 1 = 192 192 × 2 = 384 192 × 3 = 576
 * 
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the
 * concatenated product of 192 and (1,2,3)
 * 
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the
 * pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
 * 
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated
 * product of an integer with (1,2, ... , n) where n > 1?
 */
public class Problem038PandigitalMultiples {

  public static void main(String[] args) {
    int max = 918273645;
    for (int i = 127_654_321; i >= 1; i--) {
      int maxCp = maxPandigitalConcatenatedProductLessThanOneBillion(i);
      if (maxCp > max) {
        System.out.println("new max: " + maxCp);
        max = maxCp;
      }
      if (i % 1000000 == 0) {
        System.out.println(i);
      }
    }
    System.out.println(max);

  }

  private static int maxPandigitalConcatenatedProductLessThanOneBillion(int n) {
    int max = -1;
    String cp = "";
    while (cp.length() < 10) {
      for (int i = 2; i < 10; i++) {
        cp = concatenatedProduct(n, i);
        if (cp.length() == 9) {
          int cpInt = Integer.parseInt(cp, 10);
          if (EulerUtils.isPandigital(cpInt) && cpInt > max) {
            max = cpInt;
          }
        }
      }
    }
    return max;
  }

  private static String concatenatedProduct(int base, int n) {
    String cp = "";
    for (int i = 1; i <= n; i++) {
      cp += (base * i);
    }
    return cp;
  }

}
