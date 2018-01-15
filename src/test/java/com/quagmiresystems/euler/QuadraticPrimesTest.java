package com.quagmiresystems.euler;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class QuadraticPrimesTest {
    
    @Test
    public void testNumConseqPrimes() {
        assertEquals(40, Euler027QuadraticPrimes.numConseqPrimes(1, 41));
        assertEquals(80, Euler027QuadraticPrimes.numConseqPrimes(-79, 1601));
    }
    
}
