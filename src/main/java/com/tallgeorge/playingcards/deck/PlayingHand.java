package com.tallgeorge.playingcards.deck;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A subset of a deck that the player holds, called a hand.
 */
public class PlayingHand implements Hand {

    /**
     * A list of Playing Cards.
     */
    private List<PlayingCardEnum> hand = new ArrayList<>();

    @Override
    public final void add(final PlayingCardEnum card) {
        this.hand.add(card);
        this.sort();
    }

    @Override
    public final void sort() {
        if (this.hand.size() < 2) {
            return;
        }
        this.hand = this.hand.stream().sorted((a, b) -> a.getRank() - b.getRank()).collect(Collectors.toList());
    }

    @Override
    public final int getSize() {
        return hand.size();
    }

    @Override
    public final PlayingCardEnum get(final int index) {
        return hand.get(index);
    }

    @Override
    public final PlayingCardEnum pullFromTop() {
        PlayingCardEnum playingCard = hand.get(0);
        hand.remove(0);
        return playingCard;
    }

    @Override
    public final String toString() {
        return hand.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}
