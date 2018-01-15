package com.quagmiresystems.euler;

 

import java.util.ArrayList;

import java.util.Collection;

import java.util.Collections;

import java.util.HashSet;

import java.util.List;

import java.util.Set;

 

public class EulerUtils {

 

    public static boolean isPrime(long x) {

        long max = Math.round(Math.sqrt(x));

        for (int i = 2; i <= max; i++) {

            if (x % i == 0) {

                return false;

            }

        }

        return true;

    }

 

    public static List<Long> factors(long x) {

        List<Long> factors = new ArrayList<>();

        long max = Math.round(Math.sqrt(x));

        for (int i = 2; i <= max; i++) {

            if (x % i == 0) {

                factors.add((long) i);

                factors.add(x / i);

            }

        }

        return factors;

    }

 

    public static Collection<Long> divisors(long x) {

        Set<Long> divisors = new HashSet<>();

        long max = Math.round(Math.sqrt(x));

        for (long l = 1; l <= max; l++) {

            if (x % l == 0) {

                divisors.add(l);

                divisors.add(x / l);

            }

        }

        return divisors;

    }

   

    public static Collection<Long> properDivisors(long x) {

        Set<Long> divisors = new HashSet<>();

        long max = Math.round(Math.sqrt(x));

        divisors.add(1L);

        for (long l = 2; l <= max; l++) {

            if (x % l == 0) {

                divisors.add(l);

                divisors.add(x / l);

            }

        }

        return divisors;

    }

   

    public static long sum(Collection<Long> longs) {

        long sum = 0;

        for(Long l : longs) {

            sum += l;

        }

        return sum;

    }

   

    public static long sumInts(Collection<Integer> ints) {

        long sum = 0;

        for(Integer i : ints) {

            sum += i;

        }

        return sum;

    }

   

    public static boolean isAbundant(long l) {

        return sum(properDivisors(l)) > l;

    }

   

    public static boolean isDeficient(long l) {

        return sum(properDivisors(l)) < l;

    }

   

    public static boolean isPerfect(long l) {

        return sum(properDivisors(l)) == l;

    }

 

    public static int collatzSum(int n) {

        int sum = 0;

        for (int i = 1; i <= n; i++) {

            sum += i;

        }

        return sum;

    }

 

    public static String rightPadWithZeroes(String s, int numZeroes) {

        StringBuilder sb = new StringBuilder(s);

        for(int i=0; i<numZeroes; i++) {

            sb.append(0);

        }       

        return sb.toString();

    }

   

    public static String convertBase(String toConvert, int fromBase, int toBase) {

       

        return "";

    }

   

    public static List<String> generateAllPermutations(String s, List<Character> digits) {

        List<String> permutations = new ArrayList<>();

        if(digits.size()==1) {

            permutations.add(s + digits.get(0));

        } else {

            for(Character digit : digits) {

                List<Character> digitsCopy = new ArrayList<>(digits.size());

                digitsCopy.addAll(digits);

                digitsCopy.remove(digit);

                String longer = s + digit;

                permutations.addAll(generateAllPermutations(longer, digitsCopy));

            }

        }

        return permutations;

    }

}
