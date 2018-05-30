package com.quagmiresystems.euler;

/**
 * Digit Cancelling Fractions The fraction 49/98 is a curious fraction, as an inexperienced
 * mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8, which is
 * correct, is obtained by cancelling the 9s. We shall consider fractions like, 30/50 = 3/5, to be
 * trivial examples. There are exactly four non-trivial examples of this type of fraction, less than
 * one in value, and containing two digits in the numerator and denominator. If the product of these
 * four fractions is given in its lowest common terms, find the value of the denominator.
 */
public class Problem033DigitCancellingFractions {

  public static void main(String[] args) {
    int numeratorProduct = 1;
    int denominatorProduct = 1;
    for (int numerator = 10; numerator <= 98; numerator++) {
      for (int denominator = numerator + 1; denominator <= 99; denominator++) {
        if (sameDigitInNumeratorAndDenominator(numerator, denominator)) {
          if (nonTrivial(numerator, denominator)) {
            if (reduces(numerator, denominator)) {
              numeratorProduct *= numerator;
              denominatorProduct *= denominator;
            }
          }
        }
      }
    }
    System.out.println(numeratorProduct + " / " + denominatorProduct);
  }

  private static boolean sameDigitInNumeratorAndDenominator(int numerator, int denominator) {
    int num1 = numerator / 10;
    int num2 = numerator % 10;
    int den1 = denominator / 10;
    int den2 = denominator % 10;
    return num1 == den1 || num2 == den2 || num1 == den2 || num2 == den1;
  }

  private static boolean nonTrivial(int numerator, int denominator) {
    return numerator % 10 != 0 || denominator % 10 != 0;
  }

  private static boolean reduces(int numerator, int denominator) {
    int numeratorDigit1 = numerator / 10;
    int numeratorDigit2 = numerator % 10;
    int denominatorDigit1 = denominator / 10;
    int denominatorDigit2 = denominator % 10;
    boolean numDigit1MatchesDenDigit1 = numeratorDigit1 == denominatorDigit1;
    boolean numDigit1MatchesDenDigit2 = numeratorDigit1 == denominatorDigit2;
    boolean numDigit2MatchesDenDigit1 = numeratorDigit2 == denominatorDigit1;
    boolean numDigit2MatchesDenDigit2 = numeratorDigit2 == denominatorDigit2;
    return (numDigit1MatchesDenDigit1
        && compare(numerator, denominator, numeratorDigit2, denominatorDigit2))
        || (numDigit1MatchesDenDigit2
            && compare(numerator, denominator, numeratorDigit2, denominatorDigit1))
        || (numDigit2MatchesDenDigit1
            && compare(numerator, denominator, numeratorDigit1, denominatorDigit2))
        || (numDigit2MatchesDenDigit2
            && compare(numerator, denominator, numeratorDigit1, denominatorDigit1));
  }

  private static boolean compare(int num1, int den1, int num2, int den2) {
    double num1d = Double.parseDouble(Integer.toString(num1, 10));
    double num2d = Double.parseDouble(Integer.toString(num2, 10));
    double den1d = Double.parseDouble(Integer.toString(den1, 10));
    double den2d = Double.parseDouble(Integer.toString(den2, 10));
    return num1d / den1d == num2d / den2d;
  }

}
