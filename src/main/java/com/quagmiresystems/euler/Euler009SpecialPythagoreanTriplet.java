package com.quagmiresystems.euler;


public class Euler009SpecialPythagoreanTriplet {

    public static void main(String[] args) {
        // find all the combinations of a, b and c that sum to 1000
        // loop through testing for a^2+b^2=c^2
        int a, b, c;
        for(c = 997; c>=3; c--) {
            for(a = 1; a < c - 1; a++) {
                b = 1000 - c - a;
                if(a>=b) {
                    break;
                }
                if(a*a + b*b == c*c) {
                    System.out.println("a=" + a + ", b=" + b + ", c=" + c + ", product=" + a*b*c);
                }
            }
        }
    }

}

