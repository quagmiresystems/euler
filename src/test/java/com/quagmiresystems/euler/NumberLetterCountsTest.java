package com.quagmiresystems.euler;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumberLetterCountsTest {

  @Test
  public void testOneHundredAndFortyTwo() {
    assertEquals("onehundredandfifteen", Problem017NumberLetterCounts.text(115));
    assertEquals("threehundredandfortytwo", Problem017NumberLetterCounts.text(342));
    assertEquals("onehundredandfortytwo", Problem017NumberLetterCounts.text(142));
    assertEquals("fourhundredandseventeen", Problem017NumberLetterCounts.text(417));
    assertEquals("sixhundred", Problem017NumberLetterCounts.text(600));
    assertEquals("sevenhundredandnine", Problem017NumberLetterCounts.text(709));
    assertEquals("ninetynine", Problem017NumberLetterCounts.text(99));
    assertEquals("eleven", Problem017NumberLetterCounts.text(11));
    assertEquals("five", Problem017NumberLetterCounts.text(5));
  }

}
