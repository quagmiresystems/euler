package com.quagmiresystems.euler;

 

import java.util.Arrays;


/**
Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
21 22 23 24 25
20  7  8  9 10
19  6  1  2 11
18  5  4  3 12
17 16 15 14 13
It can be verified that the sum of the numbers on the diagonals is 101.
What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
*/
public class Euler028NumberSpiralDiagonals {

    static int[][] grid = new int[1002][1002];
    static {
        for(int[] arr : grid) {
            Arrays.fill(arr, 0);
        }
    }

    public static void main(String[] args) {
        int sum = 1;
        for(int i=3; i<=1001; i+=2) {
            int corner1 = i*i;
            int corner2 = corner1 - (i-1);
            int corner3 = corner2 - (i-1);
            int corner4 = corner3 - (i-1);
            int sumOfCorners = corner1 + corner2 + corner3 + corner4;
            sum += sumOfCorners;
        }
        System.out.println(sum);
    }

}