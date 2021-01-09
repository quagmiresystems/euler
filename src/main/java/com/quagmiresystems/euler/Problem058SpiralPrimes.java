package com.quagmiresystems.euler;

import static com.quagmiresystems.euler.EulerUtils.isPrime;

public class Problem058SpiralPrimes {

    public static void main(String[] args) {
        int sideLen = 1;
        int cor = 1;
        int numPrimes = 0;
        int numDiags = 1;
        do {
            sideLen+=2;
            for(int i=0;i<4;i++) {
                cor+=(sideLen-1);
                if(isPrime(cor)) {
                    numPrimes++;
                }
            }
            numDiags+=4;
        } while((double)numPrimes/numDiags>0.1);
        System.out.println(sideLen);
    }
}
