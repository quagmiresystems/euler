package com.quagmiresystems.euler;

/**
 * An irrational decimal fraction is created by concatenating the positive integers:
 * 
 * 0.123456789101112131415161718192021...
 * 
 * It can be seen that the 12th digit of the fractional part is 1.
 * 
 * If dn represents the nth digit of the fractional part, find the value of the following
 * expression.
 * 
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */
public class Problem040ChampernownesConstant {

  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder(2_000_000);
    int i = 1;
    while (sb.length() < 1_000_000) {
      sb.append(i++);
    }
    int result = Integer.parseInt(sb.substring(0, 1), 10);
    result *= Integer.parseInt(sb.substring(9, 10), 10);
    result *= Integer.parseInt(sb.substring(99, 100), 10);
    result *= Integer.parseInt(sb.substring(999, 1000), 10);
    result *= Integer.parseInt(sb.substring(9999, 10000), 10);
    result *= Integer.parseInt(sb.substring(99999, 100000), 10);
    result *= Integer.parseInt(sb.substring(999999, 1000000), 10);
    System.out.println(result);
  }

}
