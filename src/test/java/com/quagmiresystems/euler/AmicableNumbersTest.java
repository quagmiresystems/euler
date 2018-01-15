package com.quagmiresystems.euler;

import org.junit.Test;
import static org.junit.Assert.*;


public class AmicableNumbersTest {

    @Test
    public void testDivisors() {
        int[] divisors = Euler021AmicableNumbers.properDivisors(20);
        assertEquals(1, divisors[0]);
        assertEquals(2, divisors[1]);
        assertEquals(4, divisors[2]);
        assertEquals(5, divisors[3]);
        assertEquals(10, divisors[4]);
    }
    
}
