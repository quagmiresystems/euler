package com.quagmiresystems.euler;


public class TenThousandFirstPrime {
    
    static int primeCount = 1;
    
    
    public static void main(String[] args) {
        System.out.println("prime #"+primeCount+" is " + 2);
        for(int i=3; i<Integer.MAX_VALUE; i++) {
            if(isPrime(i)) {
                primeCount++;
                System.out.println("prime #"+primeCount+" is " + i);
                if(primeCount==10001) {
                    break;
                }
            }
        }
    }
    
    
    private static boolean isPrime(int i) {
        int sqrt = (int) Math.ceil(Math.sqrt(i));
        for(int j=2; j<=sqrt; j++) {
            for(int k=2; k*j<=i; k++) {
                if(j*k==i) {
                    return false;
                }
            }
        }
        return true;
    }

}
