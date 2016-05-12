package com.tallgeorge.simple1.deck;

/**
 * An enumeration representing standard playing cards in as-shipped order.
 */
public enum PlayingCardEnum {

    ACE_SPADE("ace", "spade", "A", "A♠", 0),
    TWO_SPADE("two", "spade", "2", "2♠", 1),
    THREE_SPADE("three", "spade", "3", "3♠", 2),
    FOUR_SPADE("four", "spade", "4", "4♠", 3),
    FIVE_SPADE("five", "spade", "5", "5♠", 4),
    SIX_SPADE("six", "spade", "6", "6♠", 5),
    SEVEN_SPADE("seven", "spade", "7", "7♠", 6),
    EIGHT_SPADE("eight", "spade", "8", "8♠", 7),
    NINE_SPADE("nine", "spade", "9", "9♠", 8),
    TEN_SPADE("ten", "spade", "10", "10♠", 9),
    JACK_SPADE("jack", "spade", "J", "J♠", 10),
    QUEEN_SPADE("queen", "spade", "Q", "Q♠", 11),
    KING_SPADE("king", "spade", "K", "K♠", 12),

    ACE_DIAMOND("ace", "diamond", "A", "A♦", 0),
    TWO_DIAMOND("two", "diamond", "2", "2♦", 1),
    THREE_DIAMOND("three", "diamond", "3", "3♦", 2),
    FOUR_DIAMOND("four", "diamond", "4", "4♦", 3),
    FIVE_DIAMOND("five", "diamond", "5", "5♦", 4),
    SIX_DIAMOND("six", "diamond", "6", "6♦", 5),
    SEVEN_DIAMOND("seven", "diamond", "7", "7♦", 6),
    EIGHT_DIAMOND("eight", "diamond", "8", "8♦", 7),
    NINE_DIAMOND("nine", "diamond", "9", "9♦", 8),
    TEN_DIAMOND("ten", "diamond", "10", "10♦", 9),
    JACK_DIAMOND("jack", "diamond", "J", "J♦", 10),
    QUEEN_DIAMOND("queen", "diamond", "Q", "Q♦", 11),
    KING_DIAMOND("king", "diamond", "K", "K♦", 12),

    ACE_CLUB("ace", "club", "A", "A♣", 0),
    TWO_CLUB("two", "club", "2", "2♣", 1),
    THREE_CLUB("three", "club", "3", "3♣", 2),
    FOUR_CLUB("four", "club", "4", "4♣", 3),
    FIVE_CLUB("five", "club", "5", "5♣", 4),
    SIX_CLUB("six", "club", "6", "6♣", 5),
    SEVEN_CLUB("seven", "club", "7", "7♣", 6),
    EIGHT_CLUB("eight", "club", "8", "8♣", 7),
    NINE_CLUB("nine", "club", "9", "9♣", 8),
    TEN_CLUB("ten", "club", "10", "10♣", 9),
    JACK_CLUB("jack", "club", "J", "J♣", 10),
    QUEEN_CLUB("queen", "club", "Q", "Q♣", 11),
    KING_CLUB("king", "club", "K", "K♣", 12),

    ACE_HEART("ace", "heart", "A", "A♥", 0),
    TWO_HEART("two", "heart", "2", "2♥", 1),
    THREE_HEART("three", "heart", "3", "3♥", 2),
    FOUR_HEART("four", "heart", "4", "4♥", 3),
    FIVE_HEART("five", "heart", "5", "5♥", 4),
    SIX_HEART("six", "heart", "6", "6♥", 5),
    SEVEN_HEART("seven", "heart", "7", "7♥", 6),
    EIGHT_HEART("eight", "heart", "8", "8♥", 7),
    NINE_HEART("nine", "heart", "9", "9♥", 8),
    TEN_HEART("ten", "heart", "10", "10♥", 9),
    JACK_HEART("jack", "heart", "J", "J♥", 10),
    QUEEN_HEART("queen", "heart", "Q", "Q♥", 11),
    KING_HEART("king", "heart", "K", "K♥", 12);

    /**
     * A string representation of the value.
     */
    private final String value;

    /**
     * A string representation of the suite.
     */
    private final String suite;

    /**
     * A string representation of the value, shortened.
     */
    private final String valueAbbr;

    /**
     * A string representation of the value and the suite, shortened.
     */
    private final String symbol;

    /**
     * The index of the card.
     */
    private final int rank;

    /**
     * A playing card.
     * @param value     a string representation of the value.
     * @param suite     a string representation of the suite.
     * @param valueAbbr a string representation of the value, shortened.
     * @param symbol    a string representation of the value, shortened and the symbol.
     * @param rank      the integer index of the card.
     */
    PlayingCardEnum(String value, String suite, String valueAbbr, String symbol, int rank) {
        this.value = value;
        this.suite = suite;
        this.valueAbbr = valueAbbr;
        this.symbol = symbol;
        this.rank = rank;
    }

    /**
     * Get the string representation of the value.
     * @return string, representation of the value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Get the string representation of the suites.
     * @return string, representation of the suites.
     */
    public String getSuite() {
        return suite;
    }

    /**
     * Get the string representation of the value, shortened.
     * @return string, representation of the value, shortened.
     */
    public String getValueAbbr() {
        return valueAbbr;
    }

    /**
     * Get the string representation of the value and the symbol.
     * @return string, representation of the value, shortened and the symbol.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * The index of the card.
     * @return The unique index of each card.
     */
    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return String.format("%3s", this.getSymbol());
    }
}

