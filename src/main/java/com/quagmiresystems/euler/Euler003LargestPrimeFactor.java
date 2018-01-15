package com.quagmiresystems.euler;


import java.util.Collections;
import java.util.List;


public class Euler003LargestPrimeFactor {

    public static long largestPrimeFactorOf = 600_851_475_143L;

    public static void main(String[] args) {
        List<Long> factors = EulerUtils.factors(largestPrimeFactorOf);
        Collections.sort(factors);
        Collections.reverse(factors);
        for(Long factor : factors) {
            if(EulerUtils.isPrime(factor)) {
                System.out.println(factor);
                break;
            }
        }
    }

}