package com.tallgeorge.simple1.deck;

import java.util.function.IntConsumer;

public interface Hand {
    IntConsumer add(Card card);
    int getSize();
    Card pullFromTop();
}
