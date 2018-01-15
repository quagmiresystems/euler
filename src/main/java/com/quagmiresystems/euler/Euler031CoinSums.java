package com.quagmiresystems.euler;

import java.util.Set;

/**
 * 
In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
    1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
It is possible to make £2 in the following way:
    1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
How many different ways can £2 be made using any number of coins?
 */
public class Euler031CoinSums {
    
    public static void main(String[] args) {
        System.out.println(search());
    }
    
    public static int search() {
        int count = 0;
        for(int i=0; i<=200; i++) {
            for(int j=0; j<=100; j++) {
                for(int k=0; k<=40; k++) {
                    for(int l=0; l<=20; l++) {
                        for(int m=0; m<=10; m++) {
                            for(int n=0; n<=4; n++) {
                                for(int o=0; o<=2; o++) {
                                    for(int p=0; p<=1; p++) {
                                        if(i+2*j+5*k+10*l+20*m+50*n+100*o+200*p==200) {
                                            count++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    
        enum Coin {
        p1(1), p2(2), p5(5), p10(10), p20(20), p50(50), £1(100), £2(200);
        int val;
        Coin(int val) {
            this.val = val;
        }
        int max() {
            return 200/val;
        }
    }

}
