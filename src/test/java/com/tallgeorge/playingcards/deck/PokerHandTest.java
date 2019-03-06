package com.tallgeorge.playingcards.deck;

import org.junit.Test;

import static com.tallgeorge.playingcards.deck.PokerHandEnum.FOUR_OF_A_KIND;
import static com.tallgeorge.playingcards.deck.PokerHandEnum.FULL_HOUSE;
import static com.tallgeorge.playingcards.deck.PokerHandEnum.ROYAL_FLUSH;
import static com.tallgeorge.playingcards.deck.PokerHandEnum.STRAIGHT_FLUSH;
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
        assertEquals("Should be score of one.", 1, PokerHandEnum.find(hand).getScore());
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
        assertEquals("Should be score of five.", 5, PokerHandEnum.find(hand).getScore());

        hand.add(PlayingCardEnum.THREE_SPADE);
        hand.add(PlayingCardEnum.THREE_HEART);
        hand.add(PlayingCardEnum.THREE_CLUB);
        hand.add(PlayingCardEnum.THREE_DIAMOND);
        hand.add(PlayingCardEnum.TWO_CLUB);
        assertEquals("Should detect Four of a Kind, low extra card.", FOUR_OF_A_KIND, PokerHandEnum.find(hand));
        assertEquals("Should be score of two.", 2, PokerHandEnum.find(hand).getScore());
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
        assertEquals("Should be score of three.", 3, PokerHandEnum.find(hand).getScore());

        hand.add(PlayingCardEnum.THREE_SPADE);
        hand.add(PlayingCardEnum.TWO_HEART);
        hand.add(PlayingCardEnum.THREE_CLUB);
        hand.add(PlayingCardEnum.TWO_DIAMOND);
        hand.add(PlayingCardEnum.THREE_DIAMOND);
        assertEquals("Should detect full house, low pair.", FULL_HOUSE, PokerHandEnum.find(hand));
        assertEquals("Should be score of two.", 2, PokerHandEnum.find(hand).getScore());
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
        Hand hand = new PlayingHand();
        hand.add(PlayingCardEnum.FOUR_SPADE);
        hand.add(PlayingCardEnum.FIVE_CLUB);
        hand.add(PlayingCardEnum.SEVEN_HEART);
        hand.add(PlayingCardEnum.EIGHT_CLUB);
        hand.add(PlayingCardEnum.SIX_DIAMOND);
        assertEquals("Should detect straight.", PokerHandEnum.STRAIGHT, PokerHandEnum.find(hand));
        assertEquals("Should be score of seven.", 7, PokerHandEnum.find(hand).getScore());
    }

    @Test
    public void detectsThreeOfAKind() {
        Hand hand = new PlayingHand();
        hand.add(PlayingCardEnum.FOUR_SPADE);
        hand.add(PlayingCardEnum.FIVE_CLUB);
        hand.add(PlayingCardEnum.SEVEN_HEART);
        hand.add(PlayingCardEnum.SEVEN_CLUB);
        hand.add(PlayingCardEnum.SEVEN_DIAMOND);
        assertEquals("Should detect three of a kind at the top.", PokerHandEnum.THREE_OF_A_KIND, PokerHandEnum.find(hand));
        assertEquals("Should be score of six.", 6, PokerHandEnum.find(hand).getScore());

        hand = new PlayingHand();
        hand.add(PlayingCardEnum.FOUR_SPADE);
        hand.add(PlayingCardEnum.FOUR_CLUB);
        hand.add(PlayingCardEnum.FOUR_DIAMOND);
        hand.add(PlayingCardEnum.SEVEN_CLUB);
        hand.add(PlayingCardEnum.EIGHT_HEART);
        assertEquals("Should detect three of a kind at the bottom.", PokerHandEnum.THREE_OF_A_KIND, PokerHandEnum.find(hand));
        assertEquals("Should be score of seven.", 7, PokerHandEnum.find(hand).getScore());

        hand = new PlayingHand();
        hand.add(PlayingCardEnum.FOUR_SPADE);
        hand.add(PlayingCardEnum.FOUR_CLUB);
        hand.add(PlayingCardEnum.FOUR_DIAMOND);
        hand.add(PlayingCardEnum.SEVEN_CLUB);
        hand.add(PlayingCardEnum.THREE_HEART);
        assertEquals("Should detect three of a kind in the middle.", PokerHandEnum.THREE_OF_A_KIND, PokerHandEnum.find(hand));
        assertEquals("Should be score of six.", 6, PokerHandEnum.find(hand).getScore());
    }

    @Test
    public void detectsTwoPair() {
        Hand hand = new PlayingHand();
        hand.add(PlayingCardEnum.FOUR_SPADE);
        hand.add(PlayingCardEnum.FIVE_CLUB);
        hand.add(PlayingCardEnum.FIVE_SPADE);
        hand.add(PlayingCardEnum.SIX_DIAMOND);
        hand.add(PlayingCardEnum.SIX_SPADE);
        assertEquals("Should detect two pairs at the top.", PokerHandEnum.TWO_PAIR, PokerHandEnum.find(hand));
        assertEquals("Should be score of five.", 5, PokerHandEnum.find(hand).getScore());

        hand = new PlayingHand();
        hand.add(PlayingCardEnum.FOUR_SPADE);
        hand.add(PlayingCardEnum.FOUR_DIAMOND);
        hand.add(PlayingCardEnum.FIVE_SPADE);
        hand.add(PlayingCardEnum.FIVE_CLUB);
        hand.add(PlayingCardEnum.SEVEN_DIAMOND);
        assertEquals("Should detect two pairs at the bottom.", PokerHandEnum.TWO_PAIR, PokerHandEnum.find(hand));
        assertEquals("Should be score of six.", 6, PokerHandEnum.find(hand).getScore());

        hand = new PlayingHand();
        hand.add(PlayingCardEnum.TWO_DIAMOND);
        hand.add(PlayingCardEnum.TWO_HEART);
        hand.add(PlayingCardEnum.SEVEN_HEART);
        hand.add(PlayingCardEnum.TEN_DIAMOND);
        hand.add(PlayingCardEnum.TEN_CLUB);
        assertEquals("Should detect two pairs split.", PokerHandEnum.TWO_PAIR, PokerHandEnum.find(hand));
        assertEquals("Should be score of nine.", 9, PokerHandEnum.find(hand).getScore());
    }

    @Test
    public void detectsOnePair() {
        Hand hand = new PlayingHand();
        hand.add(PlayingCardEnum.TWO_DIAMOND);
        hand.add(PlayingCardEnum.TWO_HEART);
        hand.add(PlayingCardEnum.SEVEN_HEART);
        hand.add(PlayingCardEnum.EIGHT_CLUB);
        hand.add(PlayingCardEnum.NINE_SPADE);
        assertEquals("Should detect one pairs.", PokerHandEnum.ONE_PAIR, PokerHandEnum.find(hand));
        assertEquals("Should be score of eight.", 8, PokerHandEnum.find(hand).getScore());

        hand = new PlayingHand();
        hand.add(PlayingCardEnum.TWO_DIAMOND);
        hand.add(PlayingCardEnum.THREE_DIAMOND);
        hand.add(PlayingCardEnum.THREE_HEART);
        hand.add(PlayingCardEnum.EIGHT_CLUB);
        hand.add(PlayingCardEnum.NINE_SPADE);
        assertEquals("Should detect one pairs.", PokerHandEnum.ONE_PAIR, PokerHandEnum.find(hand));
        assertEquals("Should be score of eight.", 8, PokerHandEnum.find(hand).getScore());

        hand = new PlayingHand();
        hand.add(PlayingCardEnum.TWO_DIAMOND);
        hand.add(PlayingCardEnum.THREE_DIAMOND);
        hand.add(PlayingCardEnum.FOUR_DIAMOND);
        hand.add(PlayingCardEnum.FOUR_SPADE);
        hand.add(PlayingCardEnum.NINE_SPADE);
        assertEquals("Should detect one pairs.", PokerHandEnum.ONE_PAIR, PokerHandEnum.find(hand));
        assertEquals("Should be score of eight.", 8, PokerHandEnum.find(hand).getScore());

        hand = new PlayingHand();
        hand.add(PlayingCardEnum.TWO_DIAMOND);
        hand.add(PlayingCardEnum.THREE_DIAMOND);
        hand.add(PlayingCardEnum.FOUR_DIAMOND);
        hand.add(PlayingCardEnum.NINE_SPADE);
        hand.add(PlayingCardEnum.NINE_CLUB);
        assertEquals("Should detect one pairs.", PokerHandEnum.ONE_PAIR, PokerHandEnum.find(hand));
        assertEquals("Should be score of eight.", 8, PokerHandEnum.find(hand).getScore());
    }

    @Test
    public void detectsHighCard() {
        Hand hand = new PlayingHand();
        hand.add(PlayingCardEnum.TWO_DIAMOND);
        hand.add(PlayingCardEnum.THREE_HEART);
        hand.add(PlayingCardEnum.SEVEN_HEART);
        hand.add(PlayingCardEnum.NINE_CLUB);
        hand.add(PlayingCardEnum.JACK_CLUB);
        assertEquals("Should detect high card.", PokerHandEnum.HIGH_CARD, PokerHandEnum.find(hand));
        assertEquals("Should be score of ten.", 10, PokerHandEnum.find(hand).getScore());
    }
}
