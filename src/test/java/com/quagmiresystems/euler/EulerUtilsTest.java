package com.quagmiresystems.euler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class EulerUtilsTest {

  @Test
  public void testFactors() {
    List<Long> factorsOf24 = EulerUtils.factors(24);
    assertTrue(factorsOf24.contains(2L));
    assertTrue(factorsOf24.contains(12L));
    assertTrue(factorsOf24.contains(3L));
    assertTrue(factorsOf24.contains(8L));
    assertTrue(factorsOf24.contains(4L));
    assertTrue(factorsOf24.contains(6L));
  }

  @Test
  public void testIsPrime() {
    assertTrue(EulerUtils.isPrime(7L));
    assertFalse(EulerUtils.isPrime(38L));
  }

  @Test
  public void testDivisors() {
    assertEquals(2, EulerUtils.divisors(2L).size());
    assertEquals(3, EulerUtils.divisors(9L).size());
  }

  @Test
  public void testCollatzSum() {
    assertEquals(5 + 4 + 3 + 2 + 1, EulerUtils.collatzSum(5));
  }

  @Test
  public void testRightPadWithZeroes() {
    assertEquals("10000", EulerUtils.rightPadWithZeroes("1", 4));
  }

  @Test
  public void testGenerateAllPermutationsSimple() {
    List<Character> digits = new ArrayList<>();
    digits.add(new Character('1'));
    List<String> permutations = EulerUtils.generateAllPermutations("", digits);
    assertEquals("1", permutations.get(0));
    assertEquals(1, permutations.size());
  }

  @Test
  public void testGenerateAllPermutations() {
    List<Character> digits = new ArrayList<>();
    digits.add(new Character('1'));
    digits.add(new Character('2'));
    List<String> permutations = EulerUtils.generateAllPermutations("", digits);
    assertTrue(permutations.contains("12"));
    assertTrue(permutations.contains("21"));
    assertEquals(2, permutations.size());
  }

  @Test
  public void testIsPalindrome585() {
    assertTrue(EulerUtils.isPalindromeBase10(585));
  }

  @Test
  public void testIsPalindromeRadar() {
    assertTrue(EulerUtils.isPalindrome("radar"));
  }

  @Test
  public void testIsPrimeOne() {
    assertFalse(EulerUtils.isPrime(1));
  }

  @Test
  public void testTruncations23() {
    int[] truncations = EulerUtils.truncations(23);
    Arrays.sort(truncations);
    assertEquals(2, truncations[0]);
    assertEquals(3, truncations[1]);
  }

  @Test
  public void testTruncations456() {
    int[] truncations = EulerUtils.truncations(456);
    Arrays.sort(truncations);
    assertEquals(4, truncations[0]);
    assertEquals(6, truncations[1]);
    assertEquals(45, truncations[2]);
    assertEquals(56, truncations[3]);
    assertEquals(4, truncations.length);
  }

  @Test
  public void testIsPandigitalTrue() {
    assertTrue(EulerUtils.isPandigital(123));
  }

  @Test
  public void testIsPandigitalFalse() {
    assertFalse(EulerUtils.isPandigital(55555678));
  }

  @Test
  public void testNextPrimeAfter7Is11() {
    assertEquals(11, EulerUtils.nextPrimeAfter(7));
  }

  @Test
  public void testNextPrimeAfter23Is29() {
    assertEquals(29, EulerUtils.nextPrimeAfter(23));
  }

  @Test
  public void testNextOddCompositeAfter9Is15() {
    assertEquals(15, EulerUtils.nextOddCompositeAfter(9));
  }

  @Test
  public void testPrimeFactorsPrime() {
    assertEquals(47, EulerUtils.primeFactors(47).get(0).intValue());
  }

  @Test
  public void testPrimeFactorsNotPrime() {
    List<Integer> primeFactors150 = EulerUtils.primeFactors(150);
    assertEquals(2, primeFactors150.get(0).intValue());
    assertEquals(3, primeFactors150.get(1).intValue());
    assertEquals(5, primeFactors150.get(2).intValue());
    assertEquals(5, primeFactors150.get(3).intValue());
    assertEquals(4, primeFactors150.size());
  }

  @Test
  public void testNumDistinctPrimes() {
    assertEquals(3, EulerUtils.numDistinctPrimes(EulerUtils.primeFactors(150)));
  }

  @Test
  public void testFindPrimesBetween() {
    List<Integer> primesBetween = EulerUtils.findPrimesBetween(4, 11);
    assertTrue(primesBetween.contains(5));
    assertTrue(primesBetween.contains(7));
    assertTrue(primesBetween.contains(11));
    assertEquals(3, primesBetween.size());
  }

  @Test
  public void testIsPandigitalNine() {
    assertTrue(EulerUtils.isPandigitalNine(456, 912, 387));
    assertFalse(EulerUtils.isPandigitalNine(123, 456, 7890));
  }

  @Test
  public void testSorted() {
    assertTrue(Arrays.equals("12345".toCharArray(), EulerUtils.sorted(53142)));
  }

  @Test
  public void testSameDigits() {
    assertTrue(EulerUtils.sameDigits(4567, 7654, 4756));
    assertFalse(EulerUtils.sameDigits(12345, 123455));
  }

  @Test
  public void testDigits() {
    int num = 345_678;
    assertEquals(8, num % 10);
    assertEquals(7, num % 100 / 10);
    assertEquals(6, num % 1000 / 100);
    assertEquals(5, num % 10000 / 1000);
    assertEquals(4, num % 100000 / 10000);
    assertEquals(3, num % 1000000 / 100000);
  }
}
