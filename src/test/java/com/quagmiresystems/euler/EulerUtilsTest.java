package com.quagmiresystems.euler;

 
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
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
        assertEquals(5+4+3+2+1,EulerUtils.collatzSum(5));
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
        assertEquals("1",permutations.get(0));
        assertEquals(1,permutations.size());
    }
    
    @Test
    public void testGenerateAllPermutations() {
        List<Character> digits = new ArrayList<>();
        digits.add(new Character('1'));
        digits.add(new Character('2'));
        List<String> permutations = EulerUtils.generateAllPermutations("", digits);
        assertTrue(permutations.contains("12"));
        assertTrue(permutations.contains("21"));
        assertEquals(2,permutations.size());
    }

}

