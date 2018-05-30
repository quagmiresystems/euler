package com.quagmiresystems.euler;

import java.math.BigInteger;

/**
 * 
 * 
 * It is possible to show that the square root of two can be expressed as an infinite continued
 * fraction.
 * 
 * √ 2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
 * 
 * By expanding this for the first four iterations, we get:
 * 
 * 1 + 1/2 = 3/2 = 1.5 1 + 1/(2 + 1/2) = 7/5 = 1.4 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666... 1 +
 * 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
 * 
 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is
 * the first example where the number of digits in the numerator exceeds the number of digits in the
 * denominator.
 * 
 * In the first one-thousand expansions, how many fractions contain a numerator with more digits
 * than denominator?
 * 
 */
public class Problem057SquareRootConvergents {

  public static void main(String[] args) {
    int count = 0;
    Fraction f = new Fraction(BigInteger.valueOf(5), BigInteger.valueOf(2));
    for (int i = 1; i < 1000; i++) {
      f = f.invert().plusTwo();
      if (f.countIt()) {
        count++;
      }
    }
    System.out.println("count: " + count);
  }

  private static class Fraction {
    public Fraction(BigInteger num, BigInteger den) {
      this.num = num;
      this.den = den;
    }

    public BigInteger num;
    public BigInteger den;

    @Override
    public String toString() {
      return num + "/" + den;
    }

    public Fraction invert() {
      return new Fraction(den, num);
    }

    public Fraction plusOne() {
      return new Fraction(num.add(den), den);
    }

    public Fraction plusTwo() {
      return new Fraction(num.add(den).add(den), den);
    }

    public boolean countIt() {
      Fraction ff = this.invert().plusOne();
      return ("" + ff.num).length() - ("" + ff.den).length() > 0;
    }
  }

}
