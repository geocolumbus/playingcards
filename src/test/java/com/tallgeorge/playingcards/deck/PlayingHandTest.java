package com.tallgeorge.playingcards.deck;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.stream.IntStream;

public class PlayingHandTest {

    @Test
    public void newHandHasZeroCards() {
        Hand hand = new PlayingHand();
        assertEquals("New hand has zero cards.", 0, hand.getSize());
    }

    @Test
    public void canAddFiveCardsToHand() {
        Hand hand = new PlayingHand();
        Deck deck = new CardDeck();
        IntStream.range(0, 5).forEach(i -> hand.add(deck.pullFromTop()));
        assertEquals("Hand has five cards.", 5, hand.getSize());
    }

    @Test
    public void canAddAndRemoveCardsFromHand() {
        Hand hand = new PlayingHand();
        Deck deck = new CardDeck();
        IntStream.range(0, 5).forEach(i -> hand.add(deck.pullFromTop()));
        IntStream.range(0, 3).forEach(i -> deck.add(hand.pullFromTop()));
        assertEquals("Hand has two cards after adding five and removing three.", 2, hand.getSize());
    }

    @Test
    public void canPrintOutHand() {
        Hand hand = new PlayingHand();
        hand.add(PlayingCardEnum.ACE_CLUB);
        hand.add(PlayingCardEnum.KING_DIAMOND);
        hand.add(PlayingCardEnum.THREE_HEART);
        assertEquals("Should print out hand", " A♣  3♥  K♦", hand.toString());
    }

    @Test
    public void canPullFromTop() {
        Hand hand = new PlayingHand();
        hand.add(PlayingCardEnum.ACE_CLUB);
        PlayingCardEnum playingCard = hand.pullFromTop();
        assertEquals("Should be ace of clubs", PlayingCardEnum.ACE_CLUB, playingCard);
        assertEquals("Hand should be empty", 0, hand.getSize());
    }
}
