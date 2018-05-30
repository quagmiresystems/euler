package com.quagmiresystems.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

/**
 * The nth term of the sequence of triangle numbers is given by, tn = ½n(n+1); so the first ten
 * triangle numbers are:
 * 
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 * 
 * By converting each letter in a word to a number corresponding to its alphabetical position and
 * adding these values we form a word value. For example, the word value for SKY is 19 + 11 + 25 =
 * 55 = t10. If the word value is a triangle number then we shall call the word a triangle word.
 * 
 * Using words.txt (right click and 'Save Link/Target As...'), a 16K text file containing nearly
 * two-thousand common English words, how many are triangle words?
 */
public class Problem042CodedTriangleNumbers {

  private static String alphaPos = " abcdefghijklmnopqrstuvwxyz";

  private static String[] words;

  private static Set<Integer> triangleNumbers;

  public static void main(String[] args) {
    initWords();
    initTriangleNumbers();
    int triangleWordCount = 0;
    for (String word : words) {
      System.out.println(word + " : " + wordValue(word) + " : " + isTriangleWord(word));
      if (isTriangleWord(word)) {
        triangleWordCount++;
      }
    }
    System.out.print(triangleWordCount);
  }

  private static int wordValue(String word) {
    int sum = 0;
    for (char c : word.toLowerCase().toCharArray()) {
      sum += alphaPos.indexOf(c);
    }
    return sum;
  }

  private static boolean isTriangleWord(String word) {
    return triangleNumbers.contains(wordValue(word));
  }

  private static void initWords() {
    try (BufferedReader br = new BufferedReader(new FileReader("p042_words.txt"))) {
      String allOneLine = br.readLine();
      String[] wordsInQuotes = allOneLine.split(",");
      words = new String[wordsInQuotes.length];
      for (int i = 0; i < wordsInQuotes.length; i++) {
        words[i] = wordsInQuotes[i].substring(1, wordsInQuotes[i].length() - 1);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static int maxWordLength() {
    int max = 1;
    for (String word : words) {
      if (word.length() > max) {
        max = word.length();
      }
    }
    return max;
  }

  private static void initTriangleNumbers() {
    int maxTerm = maxWordLength() * 26;
    Set<Integer> terms = new HashSet<>();
    int currentIndex = 0;
    int currentTerm = 0;
    terms.add(currentTerm);
    do {
      currentTerm = calculateTerm(++currentIndex);
      terms.add(currentTerm);
    } while (currentTerm < maxTerm);
    triangleNumbers = terms;
  }

  private static int calculateTerm(int n) {
    return (n + 1) * n / 2;
  }

}
