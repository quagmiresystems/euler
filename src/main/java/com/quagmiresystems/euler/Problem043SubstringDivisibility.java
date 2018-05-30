package com.quagmiresystems.euler;

/**
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits
 * 0 to 9 in some order, but it also has a rather interesting sub-string divisibility property.
 * 
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 * 
 * d2d3d4=406 is divisible by 2 d3d4d5=063 is divisible by 3 d4d5d6=635 is divisible by 5 d5d6d7=357
 * is divisible by 7 d6d7d8=572 is divisible by 11 d7d8d9=728 is divisible by 13 d8d9d10=289 is
 * divisible by 17
 * 
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 * 
 */
public class Problem043SubstringDivisibility {

  public static void main(String[] args) {
    long sum = 0;
    for (long i = 1_000_000_000; i <= 9_999_999_999L; i++) {
      long d4 = i / 1_000_000;
      d4 %= 10;
      boolean divisibleByTwo = d4 % 2 == 0;
      if (divisibleByTwo) {
        long d3 = i / 10_000_000;
        d3 %= 10;
        long d5 = i / 100_000;
        d5 %= 10;
        boolean divisibleByThree = (d3 + d4 + d5) % 3 == 0;
        if (divisibleByThree) {
          long d6 = i / 10_000;
          d6 %= 10;
          boolean divisibleByFive = d6 == 0 || d6 == 5;
          if (divisibleByFive) {
            long d7 = i / 1_000;
            d7 %= 10;
            int fiveSixSeven = Integer.parseInt(d5 + "" + d6 + "" + d7, 10);
            boolean divisibleBySeven = fiveSixSeven % 7 == 0;
            if (divisibleBySeven) {
              long d8 = i / 100;
              d8 %= 10;
              int sixSevenEight = Integer.parseInt(d6 + "" + d7 + "" + d8, 10);
              boolean divisibleByEleven = sixSevenEight % 11 == 0;
              if (divisibleByEleven) {
                long d9 = i / 10;
                d9 %= 10;
                int sevenEightNine = Integer.parseInt(d7 + "" + d8 + "" + d9, 10);
                boolean divisibleByThirteen = sevenEightNine % 13 == 0;
                if (divisibleByThirteen) {
                  long d10 = i % 10;
                  int eightNineTen = Integer.parseInt(d8 + "" + d9 + "" + d10, 10);
                  boolean divisibleBySeventeen = eightNineTen % 17 == 0;
                  if (divisibleBySeventeen) {
                    if (EulerUtils.isPandigitalIncludingZero(i)) {
                      System.out.println("found one: " + i);
                      sum += i;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    System.out.println("sum: " + sum);
  }

}
