package com.tallgeorge.simple1.deck;

import java.util.Arrays;
import java.util.Optional;

public enum PlayingCardEnum {
    ACE_SPADE("ace", "spade", "A", "A♠"),
    TWO_SPADE("two", "spade", "2", "2♠"),
    THREE_SPADE("three", "spade", "3", "3♠"),
    FOUR_SPADE("four", "spade", "4", "4♠"),
    FIVE_SPADE("five", "spade", "5", "5♠"),
    SIX_SPADE("six", "spade", "6", "6♠"),
    SEVEN_SPADE("seven", "spade", "7", "7♠"),
    EIGHT_SPADE("eight", "spade", "8", "8♠"),
    NINE_SPADE("nine", "spade", "9", "9♠"),
    TEN_SPADE("ten", "spade", "10", "10♠"),
    JACK_SPADE("jack", "spade", "J", "J♠"),
    QUEEN_SPADE("queen", "spade", "Q", "Q♠"),
    KING_SPADE("king", "spade", "K", "K♠"),

    ACE_DIAMOND("ace", "diamond", "A", "A♦"),
    TWO_DIAMOND("two", "diamond", "2", "2♦"),
    THREE_DIAMOND("three", "diamond", "3", "3♦"),
    FOUR_DIAMOND("four", "diamond", "4", "4♦"),
    FIVE_DIAMOND("five", "diamond", "5", "5♦"),
    SIX_DIAMOND("six", "diamond", "6", "6♦"),
    SEVEN_DIAMOND("seven", "diamond", "7", "7♦"),
    EIGHT_DIAMOND("eight", "diamond", "8", "8♦"),
    NINE_DIAMOND("nine", "diamond", "9", "9♦"),
    TEN_DIAMOND("ten", "diamond", "10", "10♦"),
    JACK_DIAMOND("jack", "diamond", "J", "J♦"),
    QUEEN_DIAMOND("queen", "diamond", "Q", "Q♦"),
    KING_DIAMOND("king", "diamond", "K", "K♦"),

    ACE_CLUB("ace", "club", "A", "A♣"),
    TWO_CLUB("two", "club", "2", "2♣"),
    THREE_CLUB("three", "club", "3", "3♣"),
    FOUR_CLUB("four", "club", "4", "4♣"),
    FIVE_CLUB("five", "club", "5", "5♣"),
    SIX_CLUB("six", "club", "6", "6♣"),
    SEVEN_CLUB("seven", "club", "7", "7♣"),
    EIGHT_CLUB("eight", "club", "8", "8♣"),
    NINE_CLUB("nine", "club", "9", "9♣"),
    TEN_CLUB("ten", "club", "10", "10♣"),
    JACK_CLUB("jack", "club", "J", "J♣"),
    QUEEN_CLUB("queen", "club", "Q", "Q♣"),
    KING_CLUB("king", "club", "K", "K♣"),

    ACE_HEART("ace", "heart", "A", "A♥"),
    TWO_HEART("two", "heart", "2", "2♥"),
    THREE_HEART("three", "heart", "3", "3♥"),
    FOUR_HEART("four", "heart", "4", "4♥"),
    FIVE_HEART("five", "heart", "5", "5♥"),
    SIX_HEART("six", "heart", "6", "6♥"),
    SEVEN_HEART("seven", "heart", "7", "7♥"),
    EIGHT_HEART("eight", "heart", "8", "8♥"),
    NINE_HEART("nine", "heart", "9", "9♥"),
    TEN_HEART("ten", "heart", "10", "10♥"),
    JACK_HEART("jack", "heart", "J", "J♥"),
    QUEEN_HEART("queen", "heart", "Q", "Q♥"),
    KING_HEART("king", "heart", "K", "K♥");

    private final String value;
    private final String suite;
    private final String valueAbbr;
    private final String symbol;

    PlayingCardEnum(String value, String suite, String valueAbbr, String symbol) {
        this.value = value;
        this.suite = suite;
        this.valueAbbr = valueAbbr;
        this.symbol = symbol;
    }

    public String getValue() {
        return value;
    }

    public String getSuite() {
        return suite;
    }

    public String getValueAbbr() {
        return valueAbbr;
    }

    public String getSymbol() {
        return symbol;
    }

    public static PlayingCardEnum find(String value, String suite) {
        Optional<PlayingCardEnum> p =  Arrays.stream(PlayingCardEnum.values()).filter(e -> e.getSuite().equals(suite) && e.getValue().equals(value)).findFirst();
        if (p.isPresent()) {
            return p.get();
        } else {
            return null;
        }
    }


    @Override
    public String toString() {
        return this.getSymbol();
    }
}

