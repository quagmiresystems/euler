package com.quagmiresystems.euler;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class LargestProductInSeriesTest {

  @Test
  public void testMaxProduct() {
    assertEquals(24, Problem008LargestProductInSeries.maxProduct("1234"));
  }

}
