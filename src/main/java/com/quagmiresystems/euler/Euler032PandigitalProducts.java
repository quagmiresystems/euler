package com.quagmiresystems.euler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */
public class Euler032PandigitalProducts {
    
    public static void main(String[] args) {
        int multiplicand;
        int multiplier;
        int product;
        // loop through products
        // check each combination of multiplicand and multiplier
        System.out.println(products().size());
        
    }
    
    static List<Integer> products() {
        List<Integer> products = new ArrayList<>();
        for(int i=1; i<=999999999; i++) {
            if(!containsDupes(i)) {
                products.add(i);
            }
            if(i%1000000==0) {
                System.out.println(i);
            }
        }
        return products;
    }
    
    static boolean containsDupes(int i) {
        String s = i + "";
        Set<Character> chars = new HashSet<>();
        for(char c : s.toCharArray()) {
            if(!chars.add(c)) {
                return true;
            }
        }
        return false;
    }
    
    static List<Integer> betterProducts() {
        List<Integer> products = new ArrayList<>();
        
        return products;
    }

}
