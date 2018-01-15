package com.quagmiresystems.euler;


public class Euler010SummationOfPrimes {
    
    public static void main(String[] args) {
        long sum = 0L;
        for(int i=2; i<2_000_000;i++) {
            if(EulerUtils.isPrime((long)i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
    
}
