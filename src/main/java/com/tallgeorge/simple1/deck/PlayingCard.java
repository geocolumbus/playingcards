package com.tallgeorge.simple1.deck;

public class PlayingCard implements Card {

    private static final String[] VALUES = {
        "ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"
    };
    private static final String[] PRINT_VALUES = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    private static final String[] SUITES = {"spade", "diamond", "club", "heart"};
    private static final String[] PRINT_SUITES = {"\u2660", "\u2666", "\u2663", "\u2665"};
    private final int index;

    private String suite;
    private String value;

    public PlayingCard(Card c) {
        this.index = c.getIndex();
        this.value = c.getValue();
        this.suite = c.getSuite();
    }

    /**
     * Get a new card from a new deck
     * @param i
     */
    public PlayingCard(int i) {
        this.index = i;
        this.suite = SUITES[i / 13];
        this.value = VALUES[i % 13];
    }

    @Override
    public String getSuite() {
        return this.suite;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public int getIndex() {
        return this.index;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(PlayingCard.class)) {
            Card card = (PlayingCard) obj;
            return card.getValue().equals(this.getValue()) && card.getSuite().equals(this.getSuite());
        }
        return false;
    }

    @Override
    public String toString() {
        return PRINT_VALUES[this.index % 13] + PRINT_SUITES[(this.index / 13)];
    }
}
