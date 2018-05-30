package com.quagmiresystems.euler;

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145. Find the sum of all numbers which
 * are equal to the sum of the factorial of their digits. Note: as 1! = 1 and 2! = 2 are not sums
 * they are not included.
 */
public class Problem034DigitFactorials {

  private static int[] digitFactorials = new int[10];

  static {
    digitFactorials[0] = 1;
    digitFactorials[1] = 1;
    for (int i = 1; i < 10; i++) {
      digitFactorials[i] = i * digitFactorials[i - 1];
    }
  }

  public static void main(String[] args) {
    int sum = 0;
    // 9 factorial is 362,880 which contains six digits
    // 362,880 * 6 contains seven digits
    // 362,880 * 7 contains seven digits
    // at some point the sum of factorial digits will never be able to exceed the number itself
    for (int i = 3; i < 10_000_000; i++) {
      if (test(i)) {
        sum += i;
      }
    }
    System.out.println(sum);
  }

  private static boolean test(int n) {
    int sum = 0;
    int[] digits = digits(n);
    for (int i = 0; i < digits.length; i++) {
      sum += digitFactorials[digits[i]];
    }
    return sum == n;
  }

  private static int[] digits(int n) {
    String s = Integer.toString(n);
    int[] digits = new int[s.length()];
    for (int i = 0; i < digits.length; i++) {
      digits[i] = Integer.parseInt(s.substring(i, i + 1));
    }
    return digits;
  }

}
