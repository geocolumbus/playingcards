package com.tallgeorge.simple1.deck;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayingHand implements Hand {

    private List<PlayingCardEnum> hand = new ArrayList<>();

    @Override
    public void add(PlayingCardEnum card) {
        this.hand.add(card);
        this.sort();
    }

    @Override
    public void add(String value, String suite) {
        this.hand.add(PlayingCardEnum.find(value, suite));
    }

    @Override
    public void sort() {
        if (this.hand.size()<2) {
            return;
        }
        this.hand = this.hand.stream().sorted((a, b) -> a.getRank() - b.getRank()).collect(Collectors.toList());
    }

    @Override
    public int getSize() {
        return hand.size();
    }

    @Override
    public PlayingCardEnum get(int i) {
        return hand.get(i);
    }

    @Override
    public PlayingCardEnum pullFromTop() {
        PlayingCardEnum playingCard = hand.get(0);
        hand.remove(0);
        return playingCard;
    }

    @Override
    public String toString() {
        return hand.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}
