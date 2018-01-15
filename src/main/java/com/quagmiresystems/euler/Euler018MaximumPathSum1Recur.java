package com.quagmiresystems.euler;


import java.util.Arrays;


public class Euler018MaximumPathSum1Recur {

    private static final int[][] triangle = {
        {75},
        {95, 64},
        {17, 47, 82},
        {18, 35, 87, 10},
        {20, 4, 82, 47, 65},
        {19, 1, 23, 75, 3, 34},
        {88, 2, 77, 73, 7, 63, 67},
        {99, 65, 4, 28, 6, 16, 70, 92},
        {41, 41, 26, 56, 83, 40, 80, 70, 33},
        {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
        {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
        {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
        {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
        {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
        {04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
    };
    private static final int maxDepth = triangle.length;
    private static int[] maxPath = new int[maxDepth];
    private static int maxSum;
    static {
        Arrays.fill(maxPath, 0);
        maxSum = calculateSum(maxPath);
    }

    private static void calc(int[] path, int currDepth) {
        if (currDepth == maxDepth) {
            int currSum = calculateSum(path);
            if (currSum > maxSum) {
                maxSum = currSum;
                maxPath = path;
            }
        } else {
            int[] down = new int[path.length + 1];
            System.arraycopy(path, 0, down, 0, path.length);
            down[path.length] = path[path.length - 1];
            calc(down, currDepth + 1);
            int[] over = new int[path.length + 1];
            System.arraycopy(path, 0, over, 0, path.length);
            over[path.length] = path[path.length - 1] + 1;
            calc(over, currDepth + 1);
        }
    }

    private static int calculateSum(int[] path) {
        int sum = 0;
        for (int i = 0; i < path.length; i++) {
            sum += triangle[i][path[i]];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] init = {0};
        calc(init, 1);
        System.out.println(maxSum);
    }

}