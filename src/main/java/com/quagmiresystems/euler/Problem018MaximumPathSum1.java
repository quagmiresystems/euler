package com.quagmiresystems.euler;


import java.util.Arrays;


public class Problem018MaximumPathSum1 {

  private static final int[][] triangle = {{75}, {95, 64}, {17, 47, 82}, {18, 35, 87, 10},
      {20, 4, 82, 47, 65}, {19, 1, 23, 75, 3, 34}, {88, 2, 77, 73, 7, 63, 67},
      {99, 65, 4, 28, 6, 16, 70, 92}, {41, 41, 26, 56, 83, 40, 80, 70, 33},
      {41, 48, 72, 33, 47, 32, 37, 16, 94, 29}, {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
      {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
      {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
      {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
      {04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}};

  public static void main(String[] args) {
    print(triangle);
    int optimalSum = 0;
    int[] bestPos = new int[triangle.length];
    int currRow = 0;
    for (int[] row : triangle) {
      int max = row[0];
      for (int i = 0; i < row.length; i++) {
        if (max < row[i]) {
          max = row[i];
          bestPos[currRow] = i;
        }
      }
      currRow++;
      optimalSum += max;
    }
    System.out.println("optimalSum: " + optimalSum);
    for (int i = 0; i < bestPos.length; i++) {
      System.out.println("best pos in row " + i + " is " + bestPos[i]);
    }
    print(sortedTriangle(triangle));
  }

  private static int max(int[] ints) {
    int max = ints[0];
    for (int i = 0; i < ints.length; i++) {
      if (max < ints[i]) {
        max = ints[i];
      }
    }
    return max;
  }

  private static int[][] sortedTriangle(int[][] triangle) {
    int[][] arrays = new int[triangle.length][];
    int pos = 0;
    for (int[] array : triangle) {
      int[] dest = new int[array.length];
      System.arraycopy(array, 0, dest, 0, array.length);
      Arrays.sort(dest);
      arrays[pos++] = dest;
    }
    return arrays;
  }

  private static void print(int[][] arrays) {
    System.out.println("[ ");
    for (int i = 0; i < arrays.length - 1; i++) {
      System.out.print(" [ ");
      for (int j = 0; j < arrays[i].length - 1; j++) {
        System.out.print(arrays[i][j] + ", ");
      }
      System.out.println(arrays[i][arrays[i].length - 1] + " ], ");
    }
    int i = arrays.length - 1;
    System.out.print(" [ ");
    for (int j = 0; j < arrays[i].length - 1; j++) {
      System.out.print(arrays[i][j] + ", ");
    }
    System.out.println(arrays[arrays.length - 1][arrays[arrays.length - 1].length - 1] + " ]");
    System.out.println("]");
  }

}

