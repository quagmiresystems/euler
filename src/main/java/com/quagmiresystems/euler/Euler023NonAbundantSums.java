package com.quagmiresystems.euler;


import java.util.HashSet;
import java.util.Set;

 
/**
A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum of two abundant numbers is 24.
By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers.
However, this upper limit cannot be reduced any further by analysis even though it is known
that the greatest number that cannot be expressed as the sum of two abundant numbers is less than this limit.
Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
*/

public class Euler023NonAbundantSums {

    public static void main(String[] args) {
        Set<Long> all = new HashSet<>();
        Set<Long> abundants = new HashSet<>();
        for(long l=1; l<=28123; l++) {
            all.add(l);
            if(EulerUtils.isAbundant(l)) {
                abundants.add(l);
            }
        }
        Set<Long> sumOfTwoAbundants = new HashSet<>();
        for(long l=1; l<=28123; l++) {
            for(long abundant : abundants) {
                if(l-abundant > 0 && abundants.contains(l-abundant)) {
                    sumOfTwoAbundants.add(l);
                    break;
                }
            }
        }
        all.removeAll(sumOfTwoAbundants);
        System.out.println(EulerUtils.sum(all));
    }

}