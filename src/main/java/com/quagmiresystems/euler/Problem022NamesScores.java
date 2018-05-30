package com.quagmiresystems.euler;



import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Arrays;



/**
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file containing over
 * five-thousand first names, begin by sorting it into alphabetical order. Then working out the
 * alphabetical value for each name, multiply this value by its alphabetical position in the list to
 * obtain a name score. For example, when the list is sorted into alphabetical order, COLIN, which
 * is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN would obtain a score
 * of 938 × 53 = 49714. What is the total of all the name scores in the file?
 */

public class Problem022NamesScores {

  public static void main(String[] args) throws Exception {
    FileReader fr = new FileReader("p022_names.txt");
    BufferedReader br = new BufferedReader(fr);
    String fileContents = br.readLine();
    String[] names = fileContents.split(",");
    for (int i = 0; i < names.length; i++) {
      names[i] = names[i].substring(1, names[i].length() - 1);
    }
    Arrays.sort(names);
    BigInteger grandTotal = BigInteger.ZERO;
    for (int i = 0; i < names.length; i++) {
      int position = i + 1;
      int sumOfValues = 0;
      for (char c : names[i].toCharArray()) {
        sumOfValues += value(c);
      }
      String value = position * sumOfValues + "";
      grandTotal = grandTotal.add(new BigInteger(value));
      System.out.println(
          names[i] + " : " + position + " : " + sumOfValues + " : " + value + " : " + grandTotal);
    }
    System.out.println(grandTotal);
    br.close();
  }

  private static int value(char c) {
    return Character.getNumericValue(c) - 9;
  }

}
