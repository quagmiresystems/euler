package com.quagmiresystems.euler;

import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class DigitFifthPowersTest {

  @Test
  public void testBase() {
    assertTrue(Problem030DigitFifthPowers.sumDigitPowers(1634, 4));
    assertTrue(Problem030DigitFifthPowers.sumDigitPowers(8208, 4));
    assertTrue(Problem030DigitFifthPowers.sumDigitPowers(9474, 4));
  }

}
