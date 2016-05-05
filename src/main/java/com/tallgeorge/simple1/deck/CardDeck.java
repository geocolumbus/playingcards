package com.tallgeorge.simple1.deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CardDeck implements Deck {

    private List<PlayingCardEnum> deck = new ArrayList<>();

    public CardDeck() {
        this.deck = IntStream.range(0, 52).boxed().map(i -> PlayingCardEnum.values()[i]).collect(Collectors.toList());
    }

    @Override
    public PlayingCardEnum get(int i) {
        return this.deck.get(i);
    }

    @Override
    public void shuffle() {
        Random randomGen = new Random();
        IntStream.range(0, 100).forEach(i -> Collections.swap(deck, randomGen.nextInt(52), randomGen.nextInt(52)));
    }

    @Override
    public int size() {
        return deck.size();
    }

    @Override
    public PlayingCardEnum pullFromTop() {
        PlayingCardEnum playingCard = deck.get(0);
        deck.remove(0);
        return playingCard;
    }

    @Override
    public void add(PlayingCardEnum c) {
        if (this.isDuplicate(c)) {
            throw new IndexOutOfBoundsException(String.format("Cannot add duplicate card %s to the deck", c));
        }
        deck.add(c);
    }

    /**
     * Detect if a card is a duplicate.
     * @param newCard
     * @return
     */
    private boolean isDuplicate(PlayingCardEnum newCard) {
        return deck.stream().filter(card -> card.equals(newCard)).count() > 0;
    }

    @Override
    public String toString() {
        return deck.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}
