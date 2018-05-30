package com.quagmiresystems.euler;

/**
 * The decimal number, 585 = 1001001001 (binary), is palindromic in both bases.
 * 
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * 
 * (Please note that the palindromic number, in either base, may not include leading zeros.)
 * 
 */
public class Problem036DoubleBasePalindromes {

  public static void main(String[] args) {
    int sum = 0;
    for (int i = 1; i < 1_000_000; i++) {
      if (EulerUtils.isPalindromeBase10(i) && EulerUtils.isPalindromeBase2(i)) {
        System.out.println(i + " is palindromic");
        sum += i;
      }
    }
    System.out.println(
        "Sum of all numbers less than a milion which are palindromic in base 10 and base 2: "
            + sum);
  }

}
