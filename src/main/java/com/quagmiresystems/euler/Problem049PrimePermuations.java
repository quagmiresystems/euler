package com.quagmiresystems.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is
 * unusual in two ways: (i) each of the three terms are prime and (ii) each of the 4-digit numbers
 * are permutations of one another.
 * 
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this
 * property, but there is one other 4-digit increasing sequence.
 * 
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 */
public class Problem049PrimePermuations {

  public static void main(String[] args) {
    List<Integer> fourDigitPrimes = EulerUtils.findPrimesBetween(999, 9999);
    Map<String, String> primeToSortedDigits = map(fourDigitPrimes);
    Map<String, List<Integer>> lists = lists(primeToSortedDigits);
    sequence(lists);
  }

  private static Map<String, String> map(List<Integer> fourDigitPrimes) {
    Map<String, String> m = new HashMap<>();
    for (Integer i : fourDigitPrimes) {
      String s = "" + i;
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String sorted = new String(chars);
      m.put(s, sorted);
    }
    return m;
  }

  private static Map<String, List<Integer>> lists(Map<String, String> map) {
    Map<String, List<Integer>> counts = new TreeMap<>();
    for (String key : map.keySet()) {
      String val = map.get(key);
      if (!counts.containsKey(val)) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(key, 10));
        counts.put(val, list);
      } else {
        List<Integer> list = counts.get(val);
        list.add(Integer.parseInt(key, 10));
      }
    }
    for (String s : counts.keySet()) {
      System.out.println(s + " : " + counts.get(s));
    }
    return counts;
  }

  private static void sequence(Map<String, List<Integer>> lists) {
    for (String s : lists.keySet()) {
      List<Integer> list = lists.get(s);
      if (list.size() >= 3) {
        Collections.sort(list);
        printIfContainsArithmeticSequenceOfThree(list);
      }
    }
  }

  private static void printIfContainsArithmeticSequenceOfThree(List<Integer> list) {
    for (int i = 0; i < list.size() - 2; i++) {
      for (int j = i + 1; j < list.size() - 1; j++) {
        for (int k = j + 1; k < list.size(); k++) {
          int ii = list.get(i);
          int jj = list.get(j);
          int kk = list.get(k);
          if (jj - ii == kk - jj) {
            System.out.println(ii + "" + jj + "" + kk);
          }
        }
      }
    }
  }

}
