package com.quagmiresystems.euler;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Collections;
import org.junit.Test;
import com.quagmiresystems.euler.Problem054PokerHands.Hand;

public class Problem054Test {

  @Test
  public void testOnePairPairCard() {
    assertEquals('7',
        onePairSevensHighCardEight().onePairPairCard(onePairSevensHighCardEight()).rank);
    assertEquals('7',
        onePairSevensHighCardEight().onePairPairCard(onePairSevensHighCardNine()).rank);
    assertEquals('8', onePairSevensHighCardEight().onePairPairCard(onePairEights()).rank);
  }

  @Test
  public void testFullHouseHighCard() {
    Hand ninesOverEights = fullHouseNinesOverEights();
    Collections.sort(ninesOverEights.cards, new Problem054PokerHands.RankComparator());
    assertEquals('9',
        fullHouseNinesOverEights().fullHouseHighCard(fullHouseNinesOverEights()).rank);
  }

  @Test
  public void testHandCompareToRoyalFlush() {
    assertTrue(royalFlush().beats(straightFlushQueenHigh()));
    assertTrue(royalFlush().ties(royalFlush()));
  }

  @Test
  public void testHandCompareToStraightFlush() {
    assertTrue(straightFlushQueenHigh().losesTo(royalFlush()));
    assertTrue(straightFlushQueenHigh().beats(straightFlushJackHigh()));
  }

  @Test
  public void testHandCompareToFourOfAKind() {
    assertTrue(fourOfAKindEight().beats(fullHouseEightsOverNines()));
    assertTrue(fourOfAKindNine().beats(fourOfAKindEight()));
    assertTrue(fourOfAKindEight().losesTo(straightFlushJackHigh()));
  }

  @Test
  public void testHandCompareToFullHouse() {
    assertTrue(fullHouseEightsOverNines().beats(flushAceKingHigh()));
    assertTrue(fullHouseNinesOverEights().beats(fullHouseEightsOverNines()));
    assertTrue(fullHouseEightsOverNines().losesTo(fourOfAKindEight()));
  }

  @Test
  public void testHandCompareToFlush() {
    assertTrue(flushAceKingHigh().beats(straightNineHigh()));
    assertTrue(flushAceKingHigh().beats(flushAceQueenHigh()));
    assertTrue(flushAceQueenHigh().losesTo(fullHouseEightsOverNines()));
  }

  @Test
  public void testHandCompareToStraight() {
    assertTrue(straightNineHigh().beats(threeOfAKindSixes()));
    assertTrue(straightTenHigh().beats(straightNineHigh()));
    assertTrue(straightNineHigh().losesTo(flushAceKingHigh()));
  }

  @Test
  public void testHandCompareToThreeOfAKind() {
    assertTrue(threeOfAKindSixes().beats(twoPairsNinesAndSevens()));
    assertTrue(threeOfAKindNines().beats(threeOfAKindSixes()));
    assertTrue(threeOfAKindNines().losesTo(fourOfAKindEight()));
  }

  @Test
  public void testHandCompareToTwoPairs() {
    assertTrue(twoPairsSevensAndFivesWithNonPairEight().beats(onePairEights()));
    assertTrue(twoPairsNinesAndSevens().beats(twoPairsSevensAndFivesWithNonPairEight()));
    assertTrue(
        twoPairsSevensAndFivesWithNonPairEight().beats(twoPairsSevensAndFivesWithNonPairSix()));
    assertTrue(twoPairsNinesAndSevens().losesTo(threeOfAKindNines()));
  }

  @Test
  public void testHandCompareToOnePair() {
    assertTrue(onePairEights().beats(highCardAce()));
    assertTrue(onePairEights().beats(onePairSevensHighCardEight()));
    assertTrue(onePairSevensHighCardNine().beats(onePairSevensHighCardEight()));
    assertTrue(onePairEights().losesTo(twoPairsNinesAndSevens()));
  }

  @Test
  public void testHandCompareToHighCard() {
    assertTrue(highCardAce().beats(highCardKing()));
    assertTrue(highCardKing().losesTo(highCardAce()));
  }

  @Test
  public void testOnePair() {
    assertTrue(onePairEights().onePair());
  }

  @Test
  public void testTwoPairs() {
    assertTrue(twoPairsNinesAndSevens().twoPairs());
  }

  @Test
  public void testThreeOfAKind() {
    assertTrue(threeOfAKindSixes().threeOfAKind());
  }

  @Test
  public void testStraight() {
    assertTrue(straightFlushQueenHigh().straight());
    assertFalse(onePairSevensHighCardEight().straight());
  }

  @Test
  public void testFlush() {
    assertTrue(straightFlushQueenHigh().flush());
  }

  @Test
  public void testFullHouse() {
    assertTrue(fullHouseEightsOverNines().fullHouse());
  }

  @Test
  public void testFourOfAKind() {
    assertTrue(fourOfAKindEight().fourOfAKind());
  }

  @Test
  public void testStraightFlush() {
    assertTrue(straightFlushQueenHigh().straightFlush());
  }

  @Test
  public void testRoyalFlush() {
    assertTrue(royalFlush().royalFlush());
  }

  private Hand highCardKing() {
    return new Problem054PokerHands.Hand("3H 6D 9S JC KH");
  }

  private Hand highCardAce() {
    return new Problem054PokerHands.Hand("3H 6D 9S JC AH");
  }

  private Hand onePairEights() {
    return new Problem054PokerHands.Hand("7H 6D 9S 8C 8H");
  }

  private Hand onePairSevensHighCardNine() {
    return new Problem054PokerHands.Hand("7H 6D 9S 7C 8H");
  }

  private Hand onePairSevensHighCardEight() {
    return new Problem054PokerHands.Hand("7H 6D 8S 7C 4H");
  }

  private Hand twoPairsNinesAndSevens() {
    return new Problem054PokerHands.Hand("7H 7D 9S 9C 8H");
  }

  private Hand twoPairsSevensAndFivesWithNonPairEight() {
    return new Problem054PokerHands.Hand("7H 7D 5S 5C 8H");
  }

  private Hand twoPairsSevensAndFivesWithNonPairSix() {
    return new Problem054PokerHands.Hand("7H 7D 5S 5C 6H");
  }

  private Hand threeOfAKindNines() {
    return new Problem054PokerHands.Hand("7H 8D 9S 9C 9H");
  }

  private Hand threeOfAKindSixes() {
    return new Problem054PokerHands.Hand("7H 8D 6S 6C 6H");
  }

  private Hand straightTenHigh() {
    return new Problem054PokerHands.Hand("6C 7H 8D 9C TH");
  }

  private Hand straightNineHigh() {
    return new Problem054PokerHands.Hand("5D 6S 7H 8D 9S");
  }

  private Hand flushAceKingHigh() {
    return new Problem054PokerHands.Hand("7H 8H 9H KH AH");
  }

  private Hand flushAceQueenHigh() {
    return new Problem054PokerHands.Hand("7H 8H TH QH AH");
  }

  private Hand fullHouseEightsOverNines() {
    return new Problem054PokerHands.Hand("8H 8D 8S 9C 9H");
  }

  private Hand fullHouseNinesOverEights() {
    return new Problem054PokerHands.Hand("8H 8D 9S 9C 9H");
  }

  private Hand fourOfAKindNine() {
    return new Problem054PokerHands.Hand("8H 9D 9S 9C 9H");
  }

  private Hand fourOfAKindEight() {
    return new Problem054PokerHands.Hand("8H 8D 8S 8C 9H");
  }

  private Hand straightFlushJackHigh() {
    return new Problem054PokerHands.Hand("7H 8H 9H TH JH");
  }

  private Hand straightFlushQueenHigh() {
    return new Problem054PokerHands.Hand("8H 9H TH JH QH");
  }

  private Hand royalFlush() {
    return new Problem054PokerHands.Hand("TH JH QH KH AH");
  }

}
