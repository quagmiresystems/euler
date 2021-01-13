package com.quagmiresystems.euler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.quagmiresystems.euler.EulerUtils.*;

public class Problem060PrimePairSets {

    public static void main(String[] args) {
        Set<Integer> primes = new HashSet<>();
        Set<Set<Integer>> pairs = new HashSet<>();
        Set<Set<Integer>> trios = new HashSet<>();
        Set<Set<Integer>> quads = new HashSet<>();
        Set<Set<Integer>> quints = new HashSet<>();
        primes.add(3);
        Integer p = 3;
        do {
            p = nextPrimeAfter(p);
            System.out.println(p);

            for(Set<Integer> quad : quads) {
                if(allConcatToPrimes(p,quad)) {
                    Set<Integer> newQuint = new HashSet<>(quad);
                    newQuint.add(p);
                    quints.add(newQuint);
                }
            }

            for (Set<Integer> trio : trios) {
                if (allConcatToPrimes(p, trio)) {
                    Set<Integer> newQuad = new HashSet<>(trio);
                    newQuad.add(p);
                    quads.add(newQuad);
                }
            }

            for(Set<Integer> pair : pairs) {
                if(allConcatToPrimes(p, pair)) {
                    Set<Integer> newTrio = new HashSet<>(pair);
                    newTrio.add(p);
                    trios.add(newTrio);
                }
            }

            for(Integer prime : primes) {
                if(allConcatToPrimes(p, Collections.singleton(prime))) {
                    Set<Integer> newPair = new HashSet<>();
                    newPair.add(p);
                    newPair.add(prime);
                    pairs.add(newPair);
                }
            }
            primes.add(p);
        } while (quints.isEmpty());
        System.out.println(quints);
    }

    private static boolean allConcatToPrimes(Integer p, Set<Integer> primes) {
        for (int prime : primes) {
            if (!isPrime(concat(p, prime)) || !isPrime(concat(prime, p))) {
                return false;
            }
        }
        return true;
    }

}
