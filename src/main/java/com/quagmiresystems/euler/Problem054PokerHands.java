package com.quagmiresystems.euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * 
 * In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in
 * the following way:
 * 
 * High Card: Highest value card. One Pair: Two cards of the same value. Two Pairs: Two different
 * pairs. Three of a Kind: Three cards of the same value. Straight: All cards are consecutive
 * values. Flush: All cards of the same suit. Full House: Three of a kind and a pair. Four of a
 * Kind: Four cards of the same value. Straight Flush: All cards are consecutive values of same
 * suit. Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
 * 
 * The cards are valued in the order: 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
 * 
 * If two players have the same ranked hands then the rank made up of the highest value wins; for
 * example, a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie, for
 * example, both players have a pair of queens, then highest cards in each hand are compared (see
 * example 4 below); if the highest cards tie then the next highest cards are compared, and so on.
 * 
 * Consider the following five hands dealt to two players: Hand Player 1 Player 2 Winner 1 5H 5C 6S
 * 7S KD Pair of Fives 2C 3S 8S 8D TD Pair of Eights Player 2 2 5D 8C 9S JS AC Highest card Ace 2C
 * 5C 7D 8S QH Highest card Queen Player 1 3 2D 9C AS AH AC Three Aces 3D 6D 7D TD QD Flush with
 * Diamonds Player 2 4 4D 6S 9H QH QC Pair of Queens Highest card Nine 3D 6D 7H QD QS Pair of Queens
 * Highest card Seven Player 1 5 2H 2D 4C 4D 4S Full House With Three Fours 3C 3D 3S 9S 9D Full
 * House with Three Threes Player 1
 * 
 * The file, poker.txt, contains one-thousand random hands dealt to two players. Each line of the
 * file contains ten cards (separated by a single space): the first five are Player 1's cards and
 * the last five are Player 2's cards. You can assume that all hands are valid (no invalid
 * characters or repeated cards), each player's hand is in no specific order, and in each hand there
 * is a clear winner.
 * 
 * How many hands does Player 1 win?
 * 
 */
public class Problem054PokerHands {

  private static List<Hand> player1Hands = new ArrayList<>();
  private static List<Hand> player2Hands = new ArrayList<>();
  private static Comparator<Card> rankComparator = new RankComparator();

  public static void main(String[] args) {
    initHands();
    int player1Wins = 0;
    for (int i = 0; i < player1Hands.size(); i++) {
      System.out.println("********************************");
      Hand player1Hand = player1Hands.get(i);
      Hand player2Hand = player2Hands.get(i);
      System.out.println("player1: " + player1Hand);
      System.out.println("player2: " + player2Hand);
      System.out.print("winner: ");
      if (player1Hand.beats(player2Hand)) {
        player1Wins++;
        System.out.println("player1");
      } else {
        System.out.println("player2");
      }
    }
    System.out.println(player1Wins);
  }

  private static void initHands() {
    try (BufferedReader br = new BufferedReader(new FileReader("p054_poker.txt"))) {
      String line;
      while ((line = br.readLine()) != null) {
        String p1 = line.substring(0, 14);
        player1Hands.add(new Hand(p1));
        String p2 = line.substring(15);
        player2Hands.add(new Hand(p2));
      }
    } catch (Exception e) {
      System.out.println("something went wrong loading the file");
      e.printStackTrace();
    }
  }

  public static class Card {
    public char rank;
    public char suit;

    public static Card highRank(List<Card> cards) {
      Collections.sort(cards, rankComparator);
      return cards.get(cards.size() - 1);
    }

    public Card(String s) {
      rank = s.charAt(0);
      suit = s.charAt(1);
    }

    public int value() {
      switch (rank) {
        case '2':
          return 2;
        case '3':
          return 3;
        case '4':
          return 4;
        case '5':
          return 5;
        case '6':
          return 6;
        case '7':
          return 7;
        case '8':
          return 8;
        case '9':
          return 9;
        case 'T':
          return 10;
        case 'J':
          return 11;
        case 'Q':
          return 12;
        case 'K':
          return 13;
        case 'A':
          return 14;
        default:
          throw new RuntimeException("wtf! a rank of " + rank);
      }
    }

    @Override
    public String toString() {
      return rank + "" + suit;
    }

    @Override
    public boolean equals(Object other) {
      Card that = (Card) other;
      return this.rank == that.rank && this.suit == that.suit;
    }
  }

  public static class RankComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
      return o1.value() - o2.value();
    }
  }

  public static class Hand implements Comparable<Hand> {
    public List<Card> cards = new ArrayList<>();

    public Hand(String s) {
      for (String card : s.split(" ")) {
        cards.add(new Card(card));
      }
    }

    @Override
    public String toString() {
      return cards.toString() + " : " + evaluate();
    }

    public String evaluate() {
      if (royalFlush()) {
        return "Royal Flush";
      } else if (straightFlush()) {
        return "Straight Flush";
      } else if (fourOfAKind()) {
        return "Four of a Kind";
      } else if (fullHouse()) {
        return "Full House";
      } else if (flush()) {
        return "Flush";
      } else if (straight()) {
        return "Straight";
      } else if (threeOfAKind()) {
        return "Three of a Kind";
      } else if (twoPairs()) {
        return "Two Pairs";
      } else if (onePair()) {
        return "One Pair";
      } else {
        return "High Card";
      }
    }

    public boolean beats(Hand o) {
      return this.compareTo(o) > 0;
    }

    public boolean losesTo(Hand o) {
      return this.compareTo(o) < 0;
    }

    public boolean ties(Hand o) {
      return this.compareTo(o) == 0;
    }

    @Override
    public int compareTo(Hand o) {
      if (this.royalFlush()) {
        if (o.royalFlush()) {
          return 0;
        } else {
          return 1;
        }
      }
      if (this.straightFlush()) {
        if (o.royalFlush()) {
          return -1;
        } else if (o.straightFlush()) {
          Collections.sort(this.cards, rankComparator);
          Collections.sort(o.cards, rankComparator);
          return compareRanks(this.cards.get(0), o.cards.get(0));
        } else {
          return 1;
        }
      }
      if (this.fourOfAKind()) {
        if (o.straightFlush()) {
          return -1;
        } else if (o.fourOfAKind()) {
          Collections.sort(this.cards, rankComparator);
          Collections.sort(o.cards, rankComparator);
          return compareRanks(this.cards.get(2), o.cards.get(2));
        } else {
          return 1;
        }
      }
      if (this.fullHouse()) {
        if (o.straightFlush() || o.fourOfAKind()) {
          return -1;
        } else if (o.fullHouse()) {
          Collections.sort(this.cards, rankComparator);
          Collections.sort(o.cards, rankComparator);
          return compareRanks(fullHouseHighCard(this), fullHouseHighCard(o));
        } else {
          return 1;
        }
      }
      if (this.flush()) {
        if (o.straightFlush() || o.fourOfAKind() || o.fullHouse()) {
          return -1;
        } else if (o.flush()) {
          Collections.sort(this.cards, rankComparator);
          Collections.sort(o.cards, rankComparator);
          int comp4 = compareRanks(this.cards.get(4), o.cards.get(4));
          if (comp4 != 0) {
            return comp4;
          } else {
            int comp3 = compareRanks(this.cards.get(3), o.cards.get(3));
            if (comp3 != 0) {
              return comp3;
            } else {
              int comp2 = compareRanks(this.cards.get(2), o.cards.get(2));
              if (comp2 != 0) {
                return comp2;
              } else {
                int comp1 = compareRanks(this.cards.get(1), o.cards.get(1));
                if (comp1 != 0) {
                  return comp1;
                } else {
                  return compareRanks(this.cards.get(0), o.cards.get(0));
                }
              }
            }
          }
        } else {
          return 1;
        }
      }
      if (this.straight()) {
        if (o.straightFlush() || o.fourOfAKind() || o.fullHouse() || o.flush()) {
          return -1;
        } else if (o.straight()) {
          return compareRanks(this.cards.get(0), o.cards.get(0));
        } else {
          return 1;
        }
      }
      if (this.threeOfAKind()) {
        if (o.straightFlush() || o.fourOfAKind() || o.fullHouse() || o.flush() || o.straight()) {
          return -1;
        } else if (o.threeOfAKind()) {
          return compareRanks(this.cards.get(2), o.cards.get(2));
        } else {
          return 1;
        }
      }
      if (this.twoPairs()) {
        if (o.straightFlush() || o.fourOfAKind() || o.fullHouse() || o.flush() || o.straight()
            || o.threeOfAKind()) {
          return -1;
        } else if (o.twoPairs()) {
          int compareHighPair = compareRanks(twoPairsHighPairCard(this), twoPairsHighPairCard(o));
          if (compareHighPair != 0) {
            return compareHighPair;
          } else {
            int compareLowPair = compareRanks(twoPairsLowPairCard(this), twoPairsLowPairCard(o));
            if (compareLowPair != 0) {
              return compareLowPair;
            } else {
              return compareRanks(twoPairsNonPairCard(this), twoPairsNonPairCard(o));
            }
          }
        } else {
          return 1;
        }
      }
      if (this.onePair()) {
        if (o.straightFlush() || o.fourOfAKind() || o.fullHouse() || o.flush() || o.straight()
            || o.threeOfAKind() || o.twoPairs()) {
          return -1;
        } else if (o.onePair()) {
          int comparePairRank = compareRanks(onePairPairCard(this), onePairPairCard(o));
          if (comparePairRank != 0) {
            return comparePairRank;
          } else {
            List<Card> nonPairThis = onePairNonPairCards(this);
            List<Card> nonPairO = onePairNonPairCards(o);
            Collections.sort(nonPairThis, rankComparator);
            Collections.sort(nonPairO, rankComparator);
            int compareTop = compareRanks(nonPairThis.get(2), nonPairO.get(2));
            if (compareTop != 0) {
              return compareTop;
            } else {
              int compareMid = compareRanks(nonPairThis.get(1), nonPairO.get(1));
              if (compareMid != 0) {
                return compareMid;
              } else {
                return compareRanks(nonPairThis.get(0), nonPairO.get(0));
              }
            }
          }
        } else {
          return 1;
        }
      }
      if (o.straightFlush() || o.fourOfAKind() || o.fullHouse() || o.flush() || o.straight()
          || o.threeOfAKind() || o.twoPairs() || o.onePair()) {
        return -1;
      }
      Collections.sort(this.cards, rankComparator);
      Collections.sort(o.cards, rankComparator);
      int comp4 = compareRanks(this.cards.get(4), o.cards.get(4));
      if (comp4 != 0) {
        return comp4;
      } else {
        int comp3 = compareRanks(this.cards.get(3), o.cards.get(3));
        if (comp3 != 0) {
          return comp3;
        } else {
          int comp2 = compareRanks(this.cards.get(2), o.cards.get(2));
          if (comp2 != 0) {
            return comp2;
          } else {
            int comp1 = compareRanks(this.cards.get(1), o.cards.get(1));
            if (comp1 != 0) {
              return comp1;
            } else {
              return compareRanks(this.cards.get(0), o.cards.get(0));
            }
          }
        }
      }
    }

    public int compareRanks(Card c1, Card c2) {
      if (c1.value() > c2.value()) {
        return 1;
      } else if (c1.value() < c2.value()) {
        return -1;
      } else {
        return 0;
      }
    }

    public Card fullHouseHighCard(Hand h) {
      Collections.sort(h.cards, rankComparator);
      if (h.cards.get(0).rank == h.cards.get(2).rank) {
        return h.cards.get(0);
      } else {
        return h.cards.get(4);
      }
    }

    public Card twoPairsHighPairCard(Hand h) {
      Collections.sort(h.cards, rankComparator);
      Card c1 = cards.get(1);
      Card c2 = cards.get(3);
      if (compareRanks(c1, c2) > 0) {
        return c1;
      } else {
        return c2;
      }
    }

    public Card twoPairsLowPairCard(Hand h) {
      Collections.sort(h.cards, rankComparator);
      Card c1 = cards.get(1);
      Card c2 = cards.get(3);
      if (compareRanks(c1, c2) < 0) {
        return c1;
      } else {
        return c2;
      }

    }

    public Card twoPairsNonPairCard(Hand h) {
      Collections.sort(h.cards, rankComparator);
      if (cards.get(1).rank == cards.get(2).rank && cards.get(3).rank == cards.get(4).rank) {
        return h.cards.get(0);
      } else if (cards.get(0).rank == cards.get(1).rank && cards.get(3).rank == cards.get(4).rank) {
        return h.cards.get(2);
      } else {
        return h.cards.get(4);
      }
    }

    public Card onePairPairCard(Hand h) {
      Collections.sort(h.cards, rankComparator);
      boolean first = h.cards.get(0).rank == h.cards.get(1).rank;
      if (first) {
        return h.cards.get(0);
      } else {
        boolean second = h.cards.get(1).rank == h.cards.get(2).rank;
        if (second) {
          return h.cards.get(1);
        } else {
          boolean third = h.cards.get(2).rank == h.cards.get(3).rank;
          if (third) {
            return h.cards.get(2);
          } else { // fourth
            return h.cards.get(3);
          }
        }
      }
    }

    public List<Card> onePairNonPairCards(Hand h) {
      Collections.sort(h.cards, rankComparator);
      boolean first = h.cards.get(0).rank == h.cards.get(1).rank;
      if (first) {
        return Arrays.asList(h.cards.get(2), h.cards.get(3), h.cards.get(4));
      } else {
        boolean second = h.cards.get(1).rank == h.cards.get(2).rank;
        if (second) {
          return Arrays.asList(h.cards.get(0), h.cards.get(3), h.cards.get(4));
        } else {
          boolean third = h.cards.get(2).rank == h.cards.get(3).rank;
          if (third) {
            return Arrays.asList(h.cards.get(0), h.cards.get(1), h.cards.get(4));
          } else { // fourth
            return Arrays.asList(h.cards.get(0), h.cards.get(1), h.cards.get(2));
          }
        }
      }
    }

    public boolean onePair() {
      Collections.sort(cards, rankComparator);
      boolean first = cards.get(0).rank == cards.get(1).rank;
      boolean second = cards.get(1).rank == cards.get(2).rank;
      boolean third = cards.get(2).rank == cards.get(3).rank;
      boolean fourth = cards.get(3).rank == cards.get(4).rank;
      return first || second || third || fourth;
    }

    public boolean twoPairs() {
      Collections.sort(cards, rankComparator);
      boolean first =
          cards.get(1).rank == cards.get(2).rank && cards.get(3).rank == cards.get(4).rank;
      boolean middle =
          cards.get(0).rank == cards.get(1).rank && cards.get(3).rank == cards.get(4).rank;
      boolean last =
          cards.get(0).rank == cards.get(1).rank && cards.get(2).rank == cards.get(3).rank;
      return first || middle || last;
    }

    public boolean threeOfAKind() {
      Collections.sort(cards, rankComparator);
      boolean first = cards.get(0).rank == cards.get(2).rank;
      boolean second = cards.get(1).rank == cards.get(3).rank;
      boolean third = cards.get(2).rank == cards.get(4).rank;
      return first || second || third;
    }

    public boolean straight() {
      Collections.sort(cards, rankComparator);
      int first = cards.get(0).value();
      int second = cards.get(1).value();
      int third = cards.get(2).value();
      int fourth = cards.get(3).value();
      int fifth = cards.get(4).value();
      return second - first == 1 && third - second == 1 && fourth - third == 1
          && fifth - fourth == 1;
    }

    public boolean flush() {
      char suit = cards.get(0).suit;
      for (int i = 1; i < cards.size(); i++) {
        if (cards.get(i).suit != suit) {
          return false;
        }
      }
      return true;
    }

    public boolean fullHouse() {
      Collections.sort(cards, rankComparator);
      boolean twoThree =
          cards.get(0).rank == cards.get(1).rank && cards.get(2).rank == cards.get(4).rank;
      boolean threeTwo =
          cards.get(0).rank == cards.get(2).rank && cards.get(3).rank == cards.get(4).rank;
      return twoThree || threeTwo;
    }

    public boolean fourOfAKind() {
      Collections.sort(cards, rankComparator);
      return cards.get(0).rank == cards.get(3).rank || cards.get(1).rank == cards.get(4).rank;
    }

    public boolean straightFlush() {
      return straight() && flush();
    }

    public boolean royalFlush() {
      return straightFlush() && cards.get(0).rank == 'T';
    }

  }

}
