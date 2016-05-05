package com.tallgeorge.simple1.deck;

import java.util.function.IntConsumer;

public interface Hand {
    void add(PlayingCardEnum card);
    void add(String value, String suite);
    int getSize();
    PlayingCardEnum pullFromTop();
    PlayingCardEnum get(int i);
}
