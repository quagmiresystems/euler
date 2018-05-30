package com.quagmiresystems.euler;



public class Problem017NumberLetterCounts {

  private static String[] ONES =
      {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
  private static String[] TEENS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
      "sixteen", "seventeen", "eighteen", "nineteen"};
  private static String[] TENS =
      {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
  private static String[] HUNDREDS = ONES;

  public static void main(String[] args) {
    int sum = 0;
    for (int i = 1; i <= 1000; i++) {
      sum += text(i).length();
    }
    System.out.println(sum);
  }

  public static String text(int x) {
    // edge case
    if (x == 1000) {
      return "onethousand";
    }
    StringBuilder sb = new StringBuilder();
    int hundreds = x / 100 % 10;
    int tens = x / 10 % 10;
    int ones = x % 10;
    if (hundreds > 0) {
      sb.append(HUNDREDS[hundreds]);
      sb.append("hundred");
    }
    if (x > 100 && x % 100 != 0) {
      sb.append("and");
    }
    if (tens > 1) {
      sb.append(TENS[tens]);
    } else if (tens == 1) {
      sb.append(TEENS[ones]);
    } else { // tens==0
      // do nothing
    }
    if (tens != 1) {
      sb.append(ONES[ones]);
    } else {
      // already covered by teens
    }
    return sb.toString();
  }

}
