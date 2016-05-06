package com.tallgeorge.simple1.deck;

import org.junit.Test;

import static com.tallgeorge.simple1.deck.PokerHandEnum.ROYAL_FLUSH;
import static com.tallgeorge.simple1.deck.PokerHandEnum.STRAIGHT_FLUSH;
import static org.junit.Assert.assertEquals;

public class PokerHandTest {

    @Test
    public void detectsRoyalFlush() {
        Hand hand = new PlayingHand();
        hand.add(PlayingCardEnum.TEN_HEART);
        hand.add(PlayingCardEnum.JACK_HEART);
        hand.add(PlayingCardEnum.QUEEN_HEART);
        hand.add(PlayingCardEnum.KING_HEART);
        hand.add(PlayingCardEnum.ACE_HEART);
        assertEquals("Should detect a Royal Flush.", ROYAL_FLUSH, PokerHandEnum.find(hand));
        assertEquals("Should be score of two.", 1, PokerHandEnum.find(hand).getScore());
    }

    @Test
    public void detectsStraightFlush() {
        Hand hand = new PlayingHand();
        hand.add(PlayingCardEnum.THREE_SPADE);
        hand.add(PlayingCardEnum.FIVE_SPADE);
        hand.add(PlayingCardEnum.SIX_SPADE);
        hand.add(PlayingCardEnum.FOUR_SPADE);
        hand.add(PlayingCardEnum.SEVEN_SPADE);
        assertEquals("Should detect a Straight Flush.", STRAIGHT_FLUSH, PokerHandEnum.find(hand));
        assertEquals("Should be score of six.", 6, PokerHandEnum.find(hand).getScore());
    }

    @Test
    public void detectsFourOfAKind() {
    }

    @Test
    public void detectsFullHouse() {
    }

    @Test
    public void detectsFlush() {
    }

    @Test
    public void detectsStraight() {
    }

    @Test
    public void detectsThreeOfAKind() {
    }

    @Test
    public void detectsTwoPair() {
    }

    @Test
    public void detectsOnePair() {
    }

    @Test
    public void detectsHighCard() {
    }
}
