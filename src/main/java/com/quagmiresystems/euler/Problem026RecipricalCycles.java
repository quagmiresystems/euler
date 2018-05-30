package com.quagmiresystems.euler;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem026RecipricalCycles {

  public static void main(String[] args) {
    int longestLength = -1;
    int longestDigit = -1;
    for (int i = 2; i <= 1000; i++) {
      Divider d = new Divider(1, i);
      if (d.repeats && d.repeatingPart.length() > longestLength) {
        longestDigit = i;
        longestLength = d.repeatingPart.length();
      }
    }
    System.out.println(longestDigit + " has a repeating part with length " + longestLength);
  }

  static class Divider implements Comparable<Divider> {

    private int numerator;

    private int denominator;

    private String result = "";

    private boolean repeats = false;

    private String repeatingPart = "";

    Deque<Integer> pastNumerators = new ArrayDeque<>();

    Divider(int numerator, int denominator) {
      if (numerator >= denominator) {
        throw new IllegalArgumentException("This class is specifically for fractions < 1");
      }
      this.numerator = numerator;
      this.denominator = denominator;
      pastNumerators.push(numerator);
      calculate();
    }

    private final void calculate() {
      int n = numerator;
      int d = denominator;
      boolean done = false;
      while (!done) {
        // System.out.println("n: " + n + " d: " + d + " result: " + result);
        if (n == d) {
          done = true;
          result += "1";
        } else if (n < d) {
          n *= 10;
          pastNumerators.push(n);
          if (result.isEmpty()) {
            result += "0.";
          } else {
            result += "0";
          }
        } else {// n>denominator
          result += (n / d);
          n %= d;
          if (n == 0) {
            done = true;
          } else {
            n *= 10;
            if (pastNumerators.contains(n)) {
              repeats = true;
              int numRepeats = numRepeats(n);
              repeatingPart = result.substring(result.length() - numRepeats);
              done = true;
            } else {
              pastNumerators.push(n);
            }
          }
        }
      }
    }

    private final int numRepeats(int n) {
      int count = 1;
      while (pastNumerators.pop() != n) {
        count++;
      }
      return count;
    }

    @Override
    public String toString() {
      return numerator + " / " + denominator + " = " + result
          + (repeats ? " repeating [" + repeatingPart + "]" : "");
    }

    @Override
    public int compareTo(Divider o) {
      return repeatingPart.length();
    }

  }

}
