package com.tallgeorge.simple1.deck;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

public class PlayingHand implements Hand {

    private final List<Card> hand = new ArrayList<>();

    @Override
    public IntConsumer add(Card card) {
        hand.add(card);
        return null;
    }

    @Override
    public int getSize() {
        return hand.size();
    }

    @Override
    public Card pullFromTop() {
        Card playingCard = hand.get(0);
        hand.remove(0);
        return playingCard;
    }
}
