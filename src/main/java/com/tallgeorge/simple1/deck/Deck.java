package com.tallgeorge.simple1.deck;

public interface Deck {

    PlayingCardEnum get(int i);
    void shuffle();
    int size();
    PlayingCardEnum pullFromTop();
    void add(PlayingCardEnum c);
}
