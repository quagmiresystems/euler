package com.quagmiresystems.euler;

import java.math.BigInteger;


public class Euler006SumSquareDifference {
    
    public static void main(String[] args) {
        int sumOfFirstHundredInts = 0;
        for(int i=1; i<=100; i++) {
            sumOfFirstHundredInts += i;
        }
        BigInteger squareOfSum = new BigInteger(Integer.toString(sumOfFirstHundredInts));
        squareOfSum = squareOfSum.pow(2);
        
        BigInteger sumOfSquares = BigInteger.ZERO;
        for(int i=1; i<=100; i++) {
            sumOfSquares = sumOfSquares.add(new BigInteger(Integer.toString(i*i)));
        }
        System.out.println("squareOfSum: " + squareOfSum);
        System.out.println("sumOfSquares: " + sumOfSquares);
        System.out.println("difference " + squareOfSum.subtract(sumOfSquares));
    }

}
