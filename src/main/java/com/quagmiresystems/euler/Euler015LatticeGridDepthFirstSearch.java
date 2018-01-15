package com.quagmiresystems.euler;

 
public class Euler015LatticeGridDepthFirstSearch {

    private static long count = 0;
    private static int size = 16;

    public static void main(String[] args) {
        count(0, 0);
        System.out.println(count);
    }

    private static void count(int x, int y) {
        if (x != size) {
            count(x + 1, y);
        }
        if (y != size) {
            count(x, y + 1);
        }
        if (x == size && y == size) {
            count++;
        }
    }

}