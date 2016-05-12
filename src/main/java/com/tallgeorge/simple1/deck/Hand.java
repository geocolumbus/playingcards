package com.tallgeorge.simple1.deck;

/**
 * A playing hand of cards.
 */
public interface Hand {

    /**
     * Add a playing card to the hand.
     * @param card the Playing Card to add.
     */
    void add(PlayingCardEnum card);

    /**
     * Get the size of the hand.
     * @return the size of the hand.
     */
    int getSize();

    /**
     * Get a playing card from the top of the hand.
     * @return a Playing Card.
     */
    PlayingCardEnum pullFromTop();

    /**
     * Get a playing card from a specific index in the hand.
     * @param index which card in the hand to get.
     * @return a playing card.
     */
    PlayingCardEnum get(int index);

    /**
     * Sort a playing hand from lowest to highest.
     */
    void sort();
}
