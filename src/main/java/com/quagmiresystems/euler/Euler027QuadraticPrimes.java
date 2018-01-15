package com.quagmiresystems.euler;

 
/**
Euler discovered the remarkable quadratic formula: n2+n+41
It turns out that the formula will produce 40 primes for the consecutive integer values 0≤n≤39
. However, when n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when n=41,412+41+41
is clearly divisible by 41.
The incredible formula n2−79n+1601
was discovered, which produces 80 primes for the consecutive values 0≤n≤79
. The product of the coefficients, −79 and 1601, is −126479.
Considering quadratics of the form:
    n2+an+b, where |a|<1000 and |b|≤1000
    where |n| is the modulus/absolute value of n
    e.g. |11|=11 and |−4|=4
Find the product of the coefficients, a
and b, for the quadratic expression that produces the maximum number of primes for consecutive values of n, starting with n=0.
*/
public class Euler027QuadraticPrimes {

    // n^2 + a*n + b --> ??
    // n^2 + n + 41 --> 40 (0..39)
    // n^2 -79n + 1601 --> 80 (0..79)

    public static void main(String[] args) {
        int bestNum = 0;
        int bestA = Integer.MIN_VALUE;
        int bestB = Integer.MIN_VALUE;
        for(int a=999; a>=-999; a--) {
            for(int b=1000; b>=-1000; b--) {
                int currentNum = numConseqPrimes(a, b);
                if(currentNum>bestNum) {
                    System.out.println("bestNum: " + currentNum + " bestA: " + a + " bestB: " + b);
                    bestNum = currentNum;
                    bestA = a;
                    bestB = b;                   
                }
            }
        }
        System.out.println("bestNum: " + bestNum + " bestA: " + bestA + " bestB: " + bestB);
        System.out.println("product of bestA and bestB: " + (bestA*bestB));
    }

    public static int numConseqPrimes(int a, int b) {   
        //System.out.println("a: " + a + " b: " + b);
        for(int n=0; n<=1015; n++) {           
            int eval = n*n + a*n + b;
            //System.out.print("    eval: " + eval);
            if(!EulerUtils.isPrime(eval < 0 ? -eval : eval)) {
                //System.out.println();
                //System.out.println("###########");
                return n;
            } else {
                //System.out.println(", ");
            }
        }
        return Integer.MAX_VALUE;
    }

}