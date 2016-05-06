package com.tallgeorge.simple1.deck;

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
        if (p != PokerHandEnum.GARBAGE) return p;

        p = findStraightFlush(hand);
        if (p != PokerHandEnum.GARBAGE) return p;

        return p;
    }

    private static PokerHandEnum findStraightFlush(Hand hand) {
        if (hand.get(0).ordinal() == hand.get(1).ordinal() - 1
            && hand.get(1).ordinal() == hand.get(2).ordinal() - 1
            && hand.get(2).ordinal() == hand.get(3).ordinal() - 1
            && hand.get(3).ordinal() == hand.get(4).ordinal() - 1
            && hand.get(0).getSuite().equals(hand.get(1).getSuite())
            && hand.get(1).getSuite().equals(hand.get(2).getSuite())
            && hand.get(2).getSuite().equals(hand.get(3).getSuite())
            && hand.get(3).getSuite().equals(hand.get(4).getSuite())
            ) {
            PokerHandEnum p = PokerHandEnum.STRAIGHT_FLUSH;
            p.setScore(hand.get(4).getRank());
            return PokerHandEnum.STRAIGHT_FLUSH;
        }
        return PokerHandEnum.GARBAGE;
    }

    private static PokerHandEnum findRoyalFlush(Hand hand) {
        if (
            hand.get(0).getRank()==0
                && hand.get(1).getRank()==9
                && hand.get(2).getRank()==10
                && hand.get(3).getRank()==11
                && hand.get(4).getRank()==12
                && hand.get(0).getSuite().equals(hand.get(1).getSuite())
                && hand.get(1).getSuite().equals(hand.get(2).getSuite())
                && hand.get(2).getSuite().equals(hand.get(3).getSuite())
                && hand.get(3).getSuite().equals(hand.get(4).getSuite())
            ) {
            PokerHandEnum p = PokerHandEnum.ROYAL_FLUSH;
            if (hand.get(1).getSuite()=="club") {
                p.setScore(3);
            } else if (hand.get(1).getSuite()=="diamond") {
                p.setScore(2);
            } else if (hand.get(1).getSuite()=="heart") {
                p.setScore(1);
            } else {
                p.setScore(0);
            }
            return p;
        }
        return PokerHandEnum.GARBAGE;

    }
}
