package com.quagmiresystems.euler;

/**
 * 
 * 
 * Starting with 1 and spiralling anticlockwise in the following way, a square spiral with side
 * length 7 is formed.
 * 
 * 37 36 35 34 33 32 31 38 17 16 15 14 13 30 39 18 5 4 3 12 29 40 19 6 1 2 11 28 41 20 7 8 9 10 27
 * 42 21 22 23 24 25 26 43 44 45 46 47 48 49
 * 
 * It is interesting to note that the odd squares lie along the bottom right diagonal, but what is
 * more interesting is that 8 out of the 13 numbers lying along both diagonals are prime; that is, a
 * ratio of 8/13 ≈ 62%.
 * 
 * If one complete new layer is wrapped around the spiral above, a square spiral with side length 9
 * will be formed. If this process is continued, what is the side length of the square spiral for
 * which the ratio of primes along both diagonals first falls below 10%?
 * 
 */
public class UnsolvedProblem058SpiralPrimes {

  public static void main(String[] args) {

    // 1 : 3, 5, 7, 9
    // 2 : 13, 17, 21, 25
    // 3 : 31, 37, 43, 49
    int sideLength = 1;
    int curr = 1;
    int incr = 2;
    int primeCornerCount = 0;
    int compositeCornerCount = 1;
    do {
      for (int i = 0; i < 4; i++) {
        curr += incr;
        if (EulerUtils.isPrime(curr)) {
          primeCornerCount++;
        } else {
          compositeCornerCount++;
        }
      }
      sideLength += 2;
      System.out.println("primeCornerCount: " + primeCornerCount + " | compositeCornerCount: "
          + compositeCornerCount);
    } while (ratioGreaterThanTenPercent(primeCornerCount, compositeCornerCount));
    System.out.println(sideLength);
  }

  private static boolean ratioGreaterThanTenPercent(int numPrimes, int numComposites) {
    return ((double) numPrimes) / numComposites > 0.1;
  }

}
