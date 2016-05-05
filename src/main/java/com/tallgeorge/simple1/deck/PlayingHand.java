package com.tallgeorge.simple1.deck;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

public class PlayingHand implements Hand {

    private final List<PlayingCardEnum> hand = new ArrayList<>();

    @Override
    public IntConsumer add(PlayingCardEnum card) {
        hand.add(card);
        return null;
    }

    @Override
    public int getSize() {
        return hand.size();
    }

    @Override
    public PlayingCardEnum pullFromTop() {
        PlayingCardEnum playingCard = hand.get(0);
        hand.remove(0);
        return playingCard;
    }
}
