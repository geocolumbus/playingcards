package com.tallgeorge.simple1.deck;

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
}
