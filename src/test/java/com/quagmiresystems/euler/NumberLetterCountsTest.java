package com.quagmiresystems.euler;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumberLetterCountsTest {

    @Test
    public void testOneHundredAndFortyTwo() {
        assertEquals("onehundredandfifteen", Euler017NumberLetterCounts.text(115));
        assertEquals("threehundredandfortytwo", Euler017NumberLetterCounts.text(342));
        assertEquals("onehundredandfortytwo", Euler017NumberLetterCounts.text(142));
        assertEquals("fourhundredandseventeen", Euler017NumberLetterCounts.text(417));
        assertEquals("sixhundred", Euler017NumberLetterCounts.text(600));
        assertEquals("sevenhundredandnine", Euler017NumberLetterCounts.text(709));
        assertEquals("ninetynine", Euler017NumberLetterCounts.text(99));
        assertEquals("eleven", Euler017NumberLetterCounts.text(11));
        assertEquals("five", Euler017NumberLetterCounts.text(5));
    }

}
