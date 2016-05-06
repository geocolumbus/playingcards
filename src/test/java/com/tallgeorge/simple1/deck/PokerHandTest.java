package com.tallgeorge.simple1.deck;

import org.junit.Test;

import static com.tallgeorge.simple1.deck.PokerHandEnum.FOUR_OF_A_KIND;
import static com.tallgeorge.simple1.deck.PokerHandEnum.FULL_HOUSE;
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
        Hand hand = new PlayingHand();
        hand.add(PlayingCardEnum.THREE_SPADE);
        hand.add(PlayingCardEnum.THREE_HEART);
        hand.add(PlayingCardEnum.THREE_CLUB);
        hand.add(PlayingCardEnum.THREE_DIAMOND);
        hand.add(PlayingCardEnum.SIX_SPADE);
        assertEquals("Should detect Four of a Kind, high extra card.", FOUR_OF_A_KIND, PokerHandEnum.find(hand));
        assertEquals("Should be score of six.", 5, PokerHandEnum.find(hand).getScore());

        hand.add(PlayingCardEnum.THREE_SPADE);
        hand.add(PlayingCardEnum.THREE_HEART);
        hand.add(PlayingCardEnum.THREE_CLUB);
        hand.add(PlayingCardEnum.THREE_DIAMOND);
        hand.add(PlayingCardEnum.TWO_CLUB);
        assertEquals("Should detect Four of a Kind, low extra card.", FOUR_OF_A_KIND, PokerHandEnum.find(hand));
        assertEquals("Should be score of one.", 1, PokerHandEnum.find(hand).getScore());
    }

    @Test
    public void detectsFullHouse() {
        Hand hand = new PlayingHand();
        hand.add(PlayingCardEnum.THREE_SPADE);
        hand.add(PlayingCardEnum.FOUR_HEART);
        hand.add(PlayingCardEnum.THREE_CLUB);
        hand.add(PlayingCardEnum.FOUR_DIAMOND);
        hand.add(PlayingCardEnum.THREE_DIAMOND);
        assertEquals("Should detect full house, high pair.", FULL_HOUSE, PokerHandEnum.find(hand));
        assertEquals("Should be score of six.", 3, PokerHandEnum.find(hand).getScore());

        hand.add(PlayingCardEnum.THREE_SPADE);
        hand.add(PlayingCardEnum.TWO_HEART);
        hand.add(PlayingCardEnum.THREE_CLUB);
        hand.add(PlayingCardEnum.TWO_DIAMOND);
        hand.add(PlayingCardEnum.THREE_DIAMOND);
        assertEquals("Should detect full house, low pair.", FULL_HOUSE, PokerHandEnum.find(hand));
        assertEquals("Should be score of one.", 2, PokerHandEnum.find(hand).getScore());
    }

    @Test
    public void detectsFlush() {
        Hand hand = new PlayingHand();
        hand.add(PlayingCardEnum.THREE_SPADE);
        hand.add(PlayingCardEnum.KING_SPADE);
        hand.add(PlayingCardEnum.SEVEN_SPADE);
        hand.add(PlayingCardEnum.FIVE_SPADE);
        hand.add(PlayingCardEnum.NINE_SPADE);
        assertEquals("Should detect flush.", PokerHandEnum.FLUSH, PokerHandEnum.find(hand));
        assertEquals("Should be score of twelve.", 12, PokerHandEnum.find(hand).getScore());
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
