package com.quagmiresystems.euler;

public class Problem014LongestCollatzSequence {

  public static void main(String[] args) {
    int maxLen = 1;
    int maxNum = 1;
    for (int i = 2; i < 1_000_000; i++) {
      int len = 1;
      long curr = i;
      do {
        curr = next(curr);
        len++;
      } while (curr != 1);
      if (len > maxLen) {
        System.out.println("old best: " + maxNum + " : " + maxLen);
        maxLen = len;
        maxNum = i;
        System.out.println("new best: " + maxNum + " : " + maxLen);
      }
    }
  }

  static long next(long x) {
    return x % 2 == 0 ? x / 2 : x * 3 + 1;
  }

}
