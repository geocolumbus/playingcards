package com.tallgeorge.simple1.deck;

import org.junit.Test;

import static com.tallgeorge.simple1.deck.PokerHandEnum.ROYAL_FLUSH;
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
        assertEquals("Should be score of two.", 2, PokerHandEnum.find(hand).getScore());
    }

    @Test
    public void detectsStraightFlush() {
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
