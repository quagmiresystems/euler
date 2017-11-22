package com.quagmiresystems.euler;


public class LargestPalindromeProduct {
    
    private static int max = Integer.MIN_VALUE;
    
    public static void main(String[] args) {
        for(int i=999; i>=100; i--) {
            for(int j=i; j>=100; j--) {
                if(isPalindrome(i*j)) {
                    System.out.println(i*j + " is the product of " + i + " and " + j);
                    if(i*j>max) {
                        max = i*j;
                    }
                }
            }
        }
        System.out.println("The max is " + max);
    }
    
    public boolean lpp(int high, int low, int bestProd) {
        for(int i=high; i>low; i--) {
            for(int j=high; j>low; j--) {
                if(isPalindrome(i*j)) {
                    //if(lpp(i,j,))
                }
            }
        }
        return false;
    }
    
    
    public static boolean isPalindrome(int i) {
        String s = Integer.toString(i);
        char[] chars = s.toCharArray();
        for(int j=0; j<chars.length/2; j++) {
            if(chars[j]!=chars[chars.length-j-1]) {
                return false;
            }
        }
        return true;
    }

}
