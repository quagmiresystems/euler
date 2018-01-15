package com.quagmiresystems.euler;

 
import java.util.ArrayList;
import java.util.List;


public class Euler002EvenFibsBelowFourMillion {

    public static void main(String[] args) {
        int sum = 0;
        for(int fib : evenFibsUnderFourMillion()) {
            sum += fib;
        }
        System.out.println(sum);
    }

    public static List<Integer> evenFibsUnderFourMillion() {
        List<Integer> fibs = new ArrayList<>();
        boolean underFourMillion = true;
        int x1 = 0;
        int x2 = 1;
        int fib;
        while (underFourMillion) {
            fib = x1 + x2;
            if(fib>4_000_000) {
                underFourMillion = false;
            } else if(fib%2==0) {
                fibs.add(fib);
            }
            x1 = x2;
            x2 = fib;
        }
        return fibs;
    }

}
