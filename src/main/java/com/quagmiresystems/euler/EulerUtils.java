package com.quagmiresystems.euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EulerUtils {

  public static boolean isPrime(long x) {
    long max = Math.round(Math.sqrt(x));
    for (int i = 2; i <= max; i++) {
      if (x % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static int concat(int a, int b) {
    return Integer.parseInt(""+a+b);
  }

  public static List<Long> factors(long x) {
    List<Long> factors = new ArrayList<>();
    long max = Math.round(Math.sqrt(x));
    for (int i = 2; i <= max; i++) {
      if (x % i == 0) {
        factors.add((long) i);
        factors.add(x / i);
      }
    }
    return factors;
  }

  public static Collection<Long> divisors(long x) {
    Set<Long> divisors = new HashSet<>();
    long max = Math.round(Math.sqrt(x));
    for (long l = 1; l <= max; l++) {
      if (x % l == 0) {
        divisors.add(l);
        divisors.add(x / l);
      }
    }
    return divisors;
  }

  public static Collection<Long> properDivisors(long x) {
    Set<Long> divisors = new HashSet<>();
    long max = Math.round(Math.sqrt(x));
    divisors.add(1L);
    for (long l = 2; l <= max; l++) {
      if (x % l == 0) {
        divisors.add(l);
        divisors.add(x / l);
      }
    }
    return divisors;
  }

  public static long sum(Collection<Long> longs) {
    long sum = 0;
    for (Long l : longs) {
      sum += l;
    }
    return sum;
  }

  public static long sumInts(Collection<Integer> ints) {
    long sum = 0;
    for (Integer i : ints) {
      sum += i;
    }
    return sum;
  }

  public static boolean isAbundant(long l) {
    return sum(properDivisors(l)) > l;
  }

  public static boolean isDeficient(long l) {
    return sum(properDivisors(l)) < l;
  }

  public static boolean isPerfect(long l) {
    return sum(properDivisors(l)) == l;
  }

  public static int collatzSum(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += i;
    }
    return sum;
  }

  public static String rightPadWithZeroes(String s, int numZeroes) {
    StringBuilder sb = new StringBuilder(s);
    for (int i = 0; i < numZeroes; i++) {
      sb.append(0);
    }
    return sb.toString();
  }

  public static List<String> generateAllPermutations(String s, List<Character> digits) {
    List<String> permutations = new ArrayList<>();
    if (digits.size() == 1) {
      permutations.add(s + digits.get(0));
    } else {
      for (Character digit : digits) {
        List<Character> digitsCopy = new ArrayList<>(digits.size());
        digitsCopy.addAll(digits);
        digitsCopy.remove(digit);
        String longer = s + digit;
        permutations.addAll(generateAllPermutations(longer, digitsCopy));
      }
    }
    return permutations;
  }

  public static int digitSum(BigInteger i) {
    int digitSum = 0;
    for (char ch : i.toString().toCharArray()) {
      digitSum += Character.getNumericValue(ch);
    }
    return digitSum;
  }

  public static String reverse(String s) {
    StringBuilder sb = new StringBuilder();
    char[] chars = s.toCharArray();
    for (int i = chars.length - 1; i >= 0; i--) {
      sb.append(chars[i]);
    }
    return sb.toString();
  }

  public static boolean isPalindromeBase10(int n) {
    String s = Integer.toString(n);
    return isPalindrome(s);
  }

  public static boolean isPalindromeBase2(int n) {
    String s = Integer.toBinaryString(n);
    return isPalindrome(s);
  }

  public static boolean isPalindrome(String s) {
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrime(int n) {
    if (n == 1)
      return false;
    int sqrt = (int) Math.floor(Math.sqrt(n));
    for (int i = 2; i <= sqrt; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static int nextPrimeAfter(int n) {
    while (!isPrime(++n)) {
      // intentionally do nothing
    }
    return n;
  }

  public static int nextOddCompositeAfter(int n) {
    n++;
    while (isEven(n) || isPrime(n)) {
      n++;
    }
    return n;
  }

  public static boolean isEven(int n) {
    return n % 2 == 0;
  }

  public static boolean allPrime(int[] nums) {
    for (int n : nums) {
      if (!isPrime(n)) {
        return false;
      }
    }
    return true;
  }

  public static int[] rotations(int n) {
    String s = Integer.toString(n);
    int[] rotations = new int[s.length()];
    rotations[0] = n;
    for (int i = 1; i < s.length(); i++) {
      String rotated = s.substring(i) + s.substring(0, i);
      rotations[i] = Integer.parseInt(rotated, 10);
    }
    return rotations;
  }

  public static int[] integerCollectionToPrimitiveIntArray(Collection<Integer> intList) {
    int[] ints = new int[intList.size()];
    int index = 0;
    for (Integer i : intList) {
      ints[index++] = i;
    }
    return ints;
  }

  public static int[] truncations(int n) {
    String s = Integer.toString(n);
    Set<Integer> truncations = new HashSet<>();
    for (int i = 0; i < s.length() - 1; i++) {
      String trimLeft = s.substring(i + 1);
      truncations.add(Integer.parseInt(trimLeft, 10));
      String trimRight = s.substring(0, s.length() - i - 1);
      truncations.add(Integer.parseInt(trimRight, 10));
    }
    return integerCollectionToPrimitiveIntArray(truncations);
  }

  public static boolean isPandigital(int n) {
    String s = Integer.toString(n);
    for (int i = 1; i <= s.length(); i++) {
      if (!s.contains(Integer.toString(i))) {
        return false;
      }
    }
    return true;
  }

  public static boolean potentiallyPandigitalNine(String s) {
    Set<Character> chars = new HashSet<>();
    for (char c : s.toCharArray()) {
      chars.add(c);
    }
    return chars.size() == s.length() && !s.contains("0");
  }

  public static boolean isPandigitalNine(int n1, int n2, int n3) {
    char[] c = (n1 + "" + n2 + "" + n3).toCharArray();
    Arrays.sort(c);
    String sorted = new String(c);
    return sorted.equals("123456789");
  }

  public static boolean isPandigitalIncludingZero(long n) {
    String s = Long.toString(n);
    for (int i = 0; i < s.length(); i++) {
      if (!s.contains(Integer.toString(i))) {
        return false;
      }
    }
    return true;
  }

  public static int triangular(int n) {
    return n * (n + 1) / 2;
  }

  public static int pentagonal(int n) {
    return n * (3 * n - 1) / 2;
  }

  public static int hexagonal(int n) {
    return n * (2 * n - 1);
  }

  public static List<Integer> primeFactors(int n) {
    if (isPrime(n)) {
      return Arrays.asList(n);
    } else {
      List<Integer> factors = new ArrayList<>();
      int f = 2;
      while (n > 1) {
        while (n % f == 0) {
          factors.add(f);
          n /= f;
        }
        f = nextPrimeAfter(f);
      }
      return factors;
    }

  }

  public static int numDistinctPrimes(List<Integer> ints) {
    return new HashSet<Integer>(ints).size();
  }

  public static List<Integer> findPrimes(int n) {
    List<Integer> primes = new ArrayList<>();
    int currentPrime = 2;
    primes.add(currentPrime);
    while (primes.size() < n) {
      int nextPrime = nextPrimeAfter(currentPrime);
      primes.add(nextPrime);
      currentPrime = nextPrime;
    }
    return primes;
  }

  /**
   * 
   * @param x lower bound
   * @param y upper bound
   * @return list of primes betweenn x exclusive and y inclusive
   */
  public static List<Integer> findPrimesBetween(int x, int y) {
    List<Integer> primes = new ArrayList<>();
    int nextPrime = x;
    while ((nextPrime = nextPrimeAfter(nextPrime)) <= y) {
      primes.add(nextPrime);
    }
    return primes;
  }

  public static boolean sameDigits(int first, int... rest) {
    char[] sortedDigits = sorted(first);
    for (int i : rest) {
      if (!Arrays.equals(sorted(i), sortedDigits)) {
        return false;
      }
    }
    return true;
  }

  public static char[] sorted(int i) {
    char[] digits = ("" + i).toCharArray();
    Arrays.sort(digits);
    return digits;
  }

}
