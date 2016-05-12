package com.tallgeorge.simple1.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A deck of 52 standard playing cards.
 */
public class CardDeck implements Deck {

    /**
     * A list of Playing Cards.
     */
    private List<PlayingCardEnum> deck = new ArrayList<>();

    /**
     * The number of times to shuffle the deck.
     */
    private static final int SHUFFLE_COUNT = 200;

    /**
     * Initialize a deck of cards with 52 cards in order.
     */
    public CardDeck() {
        this.deck = IntStream.range(0, 52).boxed().map(i -> PlayingCardEnum.values()[i]).collect(Collectors.toList());
    }

    @Override
    public final PlayingCardEnum get(final int index) {
        return this.deck.get(index);
    }

    @Override
    public final void shuffle() {
        Random randomGen = new Random();
        IntStream.range(0, SHUFFLE_COUNT).forEach(i -> Collections.swap(deck, randomGen.nextInt(52), randomGen.nextInt(52)));
    }

    @Override
    public final int size() {
        return deck.size();
    }

    @Override
    public final PlayingCardEnum pullFromTop() {
        PlayingCardEnum playingCard = deck.get(0);
        deck.remove(0);
        return playingCard;
    }

    @Override
    public final void add(final PlayingCardEnum c) {
        if (this.isDuplicate(c)) {
            throw new IndexOutOfBoundsException(String.format("Cannot add duplicate card %s to the deck", c));
        }
        deck.add(c);
    }

    /**
     * Detect if a card is a duplicate.
     * @param newCard a playing card
     * @return true if it is a duplicate.
     */
    private boolean isDuplicate(PlayingCardEnum newCard) {
        return deck.stream().filter(card -> card.equals(newCard)).count() > 0;
    }

    /**
     * Deal x number of cards off the top of the deck into a new hand.
     * @param numberOfCards the number of cards to deal.
     * @return the hand containing the dealt cards.
     */
    @Override
    public final Hand deal(final int numberOfCards) {
        Hand hand = new PlayingHand();
        IntStream.range(0, numberOfCards).boxed().forEach(i -> hand.add(this.pullFromTop()));
        return hand;
    }

    @Override
    public final String toString() {
        return deck.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}
