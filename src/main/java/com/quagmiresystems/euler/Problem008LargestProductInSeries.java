package com.quagmiresystems.euler;



import java.util.ArrayList;
import java.util.List;


public class Problem008LargestProductInSeries {

  static String series =
      "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843"
          + "8586156078911294949545950173795833195285320880551112540698747158523863050715693290963295227443043557"
          + "6689664895044524452316173185640309871112172238311362229893423380308135336276614282806444486645238749"
          + "3035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776"
          + "6572733300105336788122023542180975125454059475224352584907711670556013604839586446706324415722155397"
          + "5369781797784617406495514929086256932197846862248283972241375657056057490261407972968652414535100474"
          + "8216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586"
          + "1786645835912456652947654568284891288314260769004224219022671055626321111109370544217506941658960408"
          + "0719840385096245544436298123098787992724428490918884580156166097919133875499200524063689912560717606"
          + "0588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";


  public static void main(String[] args) {
    String[] seqsNoZeroes = series.split("0+");
    List<String> seqsNoZeroesMinLen13 = new ArrayList<>();
    // figure out how to use filter to do this
    for (String seqNoZeroes : seqsNoZeroes) {
      if (seqNoZeroes.length() >= 13) {
        seqsNoZeroesMinLen13.add(seqNoZeroes);
      }
    }

    // calculate max product for each seq
    long maxProd = 0;
    for (String seqNoZeroesMinLen13 : seqsNoZeroesMinLen13) {
      long currMaxProd = maxProduct(seqNoZeroesMinLen13);
      if (currMaxProd > maxProd) {
        maxProd = currMaxProd;
      }
    }
    System.out.println(maxProd);
  }

  public static long maxProduct(String seq) {
    long maxProduct = 0;
    for (int i = 0; i <= seq.length() - 13; i++) {
      String subSequence = seq.substring(i, i + 13);
      long product = 1;
      for (int j = 0; j < 13; j++) {
        product *= intAtPos(subSequence, j);
      }
      if (product > maxProduct) {
        maxProduct = product;
      }
    }
    return maxProduct;
  }

  private static int intAtPos(String s, int pos) {
    return Integer.parseInt(s.substring(pos, pos + 1));
  }

}
