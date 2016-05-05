package com.tallgeorge.simple1.deck;

/**
 * Created by campbelg on 5/5/16.
 */
public enum PokerHandEnum {
    ROYAL_FLUSH(0),
    STRAIGHT_FLUSH(0),
    FOUR_OF_A_KIND(0),
    FULL_HOUSE(0),
    FLUSH(0),
    STRAIGHT(0),
    THREE_OF_A_KIND(0),
    TWO_PAIR(0),
    ONE_PAIR(0),
    HIGH_CARD(0),
    GARBAGE(0);

    private int score;

    PokerHandEnum(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static PokerHandEnum find(Hand hand) {
        PokerHandEnum p = findRoyalFlush(hand);
        if (p != null) {
            return p;
        } else return null;
    }

    private static PokerHandEnum findRoyalFlush(Hand hand) {
        if (
            hand.get(0).equals(PlayingCardEnum.TEN_CLUB)
                && hand.get(1).equals(PlayingCardEnum.JACK_CLUB)
                && hand.get(2).equals(PlayingCardEnum.QUEEN_CLUB)
                && hand.get(3).equals(PlayingCardEnum.KING_CLUB)
                && hand.get(4).equals(PlayingCardEnum.ACE_CLUB)
            ) {
            PokerHandEnum p = PokerHandEnum.ROYAL_FLUSH;
            return p;
        } else if (
            hand.get(0).equals(PlayingCardEnum.TEN_DIAMOND)
                && hand.get(1).equals(PlayingCardEnum.JACK_DIAMOND)
                && hand.get(2).equals(PlayingCardEnum.QUEEN_DIAMOND)
                && hand.get(3).equals(PlayingCardEnum.KING_DIAMOND)
                && hand.get(4).equals(PlayingCardEnum.ACE_DIAMOND)
            ) {
            PokerHandEnum p = PokerHandEnum.ROYAL_FLUSH;
            p.setScore(1);
            return p;
        } else if (
            hand.get(0).equals(PlayingCardEnum.TEN_HEART)
                && hand.get(1).equals(PlayingCardEnum.JACK_HEART)
                && hand.get(2).equals(PlayingCardEnum.QUEEN_HEART)
                && hand.get(3).equals(PlayingCardEnum.KING_HEART)
                && hand.get(4).equals(PlayingCardEnum.ACE_HEART)
            ) {
            PokerHandEnum p = PokerHandEnum.ROYAL_FLUSH;
            p.setScore(2);
            return p;
        } else if (
            hand.get(0).equals(PlayingCardEnum.TEN_SPADE)
                && hand.get(1).equals(PlayingCardEnum.JACK_SPADE)
                && hand.get(2).equals(PlayingCardEnum.QUEEN_SPADE)
                && hand.get(3).equals(PlayingCardEnum.KING_SPADE)
                && hand.get(4).equals(PlayingCardEnum.ACE_SPADE)
            ) {
            PokerHandEnum p = PokerHandEnum.ROYAL_FLUSH;
            p.setScore(3);
            return p;
        } else {
            return PokerHandEnum.GARBAGE;
        }
    }
}
