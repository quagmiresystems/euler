package com.quagmiresystems.euler;



public class Problem005SmallestMultipleOneThroughTwenty {

  public static void main(String[] args) {
    boolean found = false;
    long i = 20;
    while (!found) {
      if (divisibleByFirstTwenty(i)) {
        found = true;
        System.out.println(i);
      } else {
        i++;
      }
    }
  }

  public static boolean divisibleByFirstTwenty(long i) {
    for (int j = 20; j > 1; j++) {
      if (i % j != 0) {
        return false;
      }
    }
    return true;
  }

}
