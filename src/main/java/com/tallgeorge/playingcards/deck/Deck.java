package com.tallgeorge.playingcards.deck;

/**
 * A deck of cards.
 */
public interface Deck {

    /**
     * Retrieve the Playing Card at the specified index.
     * @param index the index of the Playing Card
     * @return a Playing Card
     */
    PlayingCardEnum get(int index);

    /**
     * Shuffle the deck of playing cards.
     */
    void shuffle();

    /**
     * Get the size of the deck.
     * @return the number of cards in the deck.
     */
    int size();

    /**
     * Return the top (lowest index) card from the deck.
     * @return the top Playing Card from the deck.
     */
    PlayingCardEnum pullFromTop();

    /**
     * Add a playing card to the deck.
     * @param playingCard The card to add.
     */
    void add(PlayingCardEnum playingCard);

    /**
     * Deal a number of cards to a hand by taking them off the top.
     * @param numberOfCards the number of cards to deal.
     * @return a hand containing the number of cards requested.
     */
    Hand deal(int numberOfCards);
}
