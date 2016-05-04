package com.tallgeorge.simple1.deck;

public interface Deck {

    Card get(int i);
    void shuffle();
    int size();
    Card pullFromTop();
    void add(Card c);
}
