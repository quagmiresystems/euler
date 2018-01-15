package com.quagmiresystems.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 *
 * Let d(n) be defined as the sum of proper properDivisors of n (numbers less
 * than n which divide evenly into n). If d(a) = b and d(b) = a, where a ≠ b,
 * then a and b are an amicable pair and each of a and b are called amicable
 * numbers.
 *
 * For example, the proper properDivisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22,
 * 44, 55 and 110; therefore d(220) = 284. The proper properDivisors of 284 are
 * 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 *
 * @author jeffrey
 */
public class Euler021AmicableNumbers {

    private static int[][] divisors = new int[10001][];

    private static int[] sumsOfDivisors = new int[10001];

    public static void main(String[] args) {
        for (int i = 1; i <= 10000; i++) {
            divisors[i] = properDivisors(i);
        }
        for (int i = 1; i <= 10000; i++) {
            int sumOfDivisors = 0;
            for (int divisor : divisors[i]) {
                sumOfDivisors += divisor;
            }
            sumsOfDivisors[i] = sumOfDivisors;
        }
        int sum = 0;
        for (int i = 1; i <= 10000; i++) {
            int da = sumsOfDivisors[i];
            if (da <= 10000) {
                int db = sumsOfDivisors[da];
                if (db !=da && db == i) {
                    System.out.println(i + " : " + sumsOfDivisors[i] + " : " + Arrays.toString(divisors[i]));
                    sum += i;
                }
            }

        }
        System.out.println(sum);
    }

    public static int[] properDivisors(int x) {
        int max = (int) Math.floor(Math.sqrt(x));
        List<Integer> divisors = new ArrayList<>();
        divisors.add(1);
        for (int i = 2; i <= max; i++) {
            if (x % i == 0) {
                divisors.add(i);
                if (x / i != i) {
                    divisors.add(x / i);
                }
            }
        }
        Collections.sort(divisors);
        int[] divs = new int[divisors.size()];
        for (int i = 0; i < divisors.size(); i++) {
            divs[i] = divisors.get(i);
        }
        return divs;
    }

}
