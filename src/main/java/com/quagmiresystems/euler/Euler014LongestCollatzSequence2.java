package com.quagmiresystems.euler;


public class Euler014LongestCollatzSequence2 {

    static int[] lengths = new int[5_500_000];

    public static void main(String[] args) {
        lengths[1] = 1;
        lengthOfCollatzSequence(1_000_000);
        for(int i=1; i<1_000_000; i++) {
            if(lengths[i]==0) {
                lengthOfCollatzSequence(i);
            }
        }
        int max = 1;
        for(int i=1; i<1_000_000; i++) {
            if(lengths[i]>max) {
                lengths[i]=max;
            }
        }
        System.out.println(max);
    }

    static int lengthOfCollatzSequence(int x) {       
        int memo = lengths[x];
        if(memo==0) {           
            if(x%2==0){
                memo = lengthOfCollatzSequence(x/2) + 1;
                lengths[x] = memo;
                return memo;
            } else {
                memo = lengthOfCollatzSequence(3*x+1) + 1;
                lengths[x] = memo;
                return memo;
            }
        } else {
            return memo;
        }
    }
   
}