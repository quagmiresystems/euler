package com.quagmiresystems.euler;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PowerDigitSumTest {

  @Test
  public void testTwoToTheTenth() {
    // 2^15 is 32768
    assertEquals(3 + 2 + 7 + 6 + 8, Problem016PowerDigitSum.powerDigitSum(15));
  }

}
