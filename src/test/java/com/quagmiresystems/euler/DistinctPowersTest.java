package com.quagmiresystems.euler;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class DistinctPowersTest {

  @Test
  public void testGiven() {
    assertEquals(15, Problem029DistinctPowers.numDistinctTerms(2, 5));
  }

}
