package com.quagmiresystems.euler;

/**
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are
 * exactly three solutions for p = 120.
 * 
 * {20,48,52}, {24,45,51}, {30,40,50}
 * 
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */
public class Problem039IntegerRightTriangles {

  public static void main(String[] args) {
    int[] numSolutions = new int[1001];
    for (int i = 1; i <= 1000; i++) {
      numSolutions[i] = numSolutions(i);
    }
    int max = -1;
    int maxIndex = -1;
    for (int i = 1; i <= 1000; i++) {
      if (numSolutions[i] > max) {
        max = numSolutions[i];
        maxIndex = i;
      }
    }
    System.out.println(maxIndex);
  }

  private static int numSolutions(int p) {
    int numSolutions = 0;
    for (int a = 1; a < p - 2; a++) {
      for (int b = a + 1; b < p - 1; b++) {
        int c = p - a - b;
        if (a * a + b * b == c * c) {
          System.out.println("p: " + p + " a: " + a + " b: " + b + " c: " + c);
          numSolutions++;
        }
      }
    }
    System.out.println("p: " + p + " --> " + numSolutions);
    return numSolutions;
  }

}
