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

    /**
     * Finds a poker hand type from a hand of five cards
     *
     * @param hand a poker hand
     * @return poker hand type
     */
    public static PokerHandEnum find(Hand hand) {
        PokerHandEnum p = findRoyalFlush(hand);
        if (p != PokerHandEnum.GARBAGE) return p;

        p = findStraightFlush(hand);
        if (p != PokerHandEnum.GARBAGE) return p;

        p = findFourOfAKind(hand);
        if (p != PokerHandEnum.GARBAGE) return p;

        p = findFullHouse(hand);
        if (p != PokerHandEnum.GARBAGE) return p;

        p = findFlush(hand);
        if (p != PokerHandEnum.GARBAGE) return p;

        p = findStraight(hand);
        if (p != PokerHandEnum.GARBAGE) return p;

        p = findThreeOfAKind(hand);
        if (p != PokerHandEnum.GARBAGE) return p;

        p = findTwoPair(hand);
        if (p != PokerHandEnum.GARBAGE) return p;

        p = findOnePair(hand);
        if (p != PokerHandEnum.GARBAGE) return p;

        p = findHighCard(hand);
        if (p != PokerHandEnum.GARBAGE) return p;

        return p;
    }

    /**
     * Detect high card in garbage hand.
     * @param hand a hand of 5 cards
     * @return HIGH_CARD if detected
     */
    private static PokerHandEnum findHighCard(Hand hand) {
        PokerHandEnum p = PokerHandEnum.HIGH_CARD;
        p.setScore(hand.get(4).getRank());
        return p;
    }

    /**
     * Detect one pair
     *
     * @param hand a hand of 5 cards
     * @return ONE_PAIR if detected, otherwise GARBAGE
     */
    private static PokerHandEnum findOnePair(Hand hand) {
        if (hand.get(0).getRank() == hand.get(1).getRank()
            || hand.get(1).getRank() == hand.get(2).getRank()
            || hand.get(2).getRank() == hand.get(3).getRank()
            || hand.get(3).getRank() == hand.get(4).getRank()) {
            PokerHandEnum p = PokerHandEnum.ONE_PAIR;
            p.setScore(hand.get(4).getRank());
            return p;
        }
            return PokerHandEnum.GARBAGE;
    }

    /**
     * Detect two pairs
     *
     * @param hand a hand of 5 cards.
     * @return TWO_PAIR if detected, otherwise GARBAGE
     */
    private static PokerHandEnum findTwoPair(Hand hand) {
        if ((hand.get(0).getRank() == hand.get(1).getRank()
            && hand.get(2).getRank() == hand.get(3).getRank())
            || ((hand.get(0).getRank() == hand.get(1).getRank()
            && hand.get(3).getRank() == hand.get(4).getRank()))
            || ((hand.get(1).getRank() == hand.get(2).getRank()
            && hand.get(3).getRank() == hand.get(4).getRank()))) {
            PokerHandEnum p = PokerHandEnum.TWO_PAIR;
            p.setScore(hand.get(4).getRank());
            return p;
        }
        return PokerHandEnum.GARBAGE;
    }

    /**
     * Detect three of a kind.
     *
     * @param hand a hand of 5 cards
     * @return THREE_OF_A_KIND if detected, otherwise GARBAGE
     */
    private static PokerHandEnum findThreeOfAKind(Hand hand) {
        if ((hand.get(0).getRank() == hand.get(1).getRank()
            && hand.get(1).getRank() == hand.get(2).getRank())
            || (hand.get(1).getRank() == hand.get(2).getRank()
            && hand.get(2).getRank() == hand.get(3).getRank())
            || (hand.get(2).getRank() == hand.get(3).getRank()
            && hand.get(3).getRank() == hand.get(4).getRank())) {
            PokerHandEnum p = PokerHandEnum.THREE_OF_A_KIND;
            p.setScore(hand.get(4).getRank());
            return p;
        }
        return PokerHandEnum.GARBAGE;
    }

    /**
     * Detects a straight.
     *
     * @param hand a hand of 5 cards
     * @return STRAIGHT if detected, otherwise GARBAGE
     */
    private static PokerHandEnum findStraight(Hand hand) {
        if (hand.get(0).getRank() == hand.get(1).getRank() - 1
            && hand.get(1).getRank() == hand.get(2).getRank() - 1
            && hand.get(2).getRank() == hand.get(3).getRank() - 1
            && hand.get(3).getRank() == hand.get(4).getRank() - 1) {
            PokerHandEnum p = PokerHandEnum.STRAIGHT;
            p.setScore(hand.get(4).getRank());
            return p;
        }
        return PokerHandEnum.GARBAGE;
    }

    /**
     * Detects a flush
     *
     * @param hand a hand of 5 cards
     * @return FLUSH if detected, otherwise GARBAGE
     */
    private static PokerHandEnum findFlush(Hand hand) {
        if (hand.get(0).getSuite().equals(hand.get(1).getSuite())
            && hand.get(1).getSuite().equals(hand.get(2).getSuite())
            && hand.get(2).getSuite().equals(hand.get(3).getSuite())
            && hand.get(3).getSuite().equals(hand.get(4).getSuite())
            ) {
            PokerHandEnum p = PokerHandEnum.FLUSH;
            p.setScore(hand.get(4).getRank());
            return p;
        }
        return PokerHandEnum.GARBAGE;
    }

    /**
     * Detects a full house
     *
     * @param hand a hand of 5 cards
     * @return FULL_HOUSE if detected, otherwise GARBAGE
     */
    private static PokerHandEnum findFullHouse(Hand hand) {
        if ((hand.get(0).getRank() == hand.get(1).getRank()
            && hand.get(1).getRank() == hand.get(2).getRank()
            && hand.get(3).getRank() == hand.get(4).getRank())
            || (hand.get(0).getRank() == hand.get(1).getRank()
            && hand.get(2).getRank() == hand.get(3).getRank()
            && hand.get(3).getRank() == hand.get(4).getRank()
        )) {
            PokerHandEnum p = PokerHandEnum.FULL_HOUSE;
            p.setScore(hand.get(4).getRank());
            return p;
        }
        return PokerHandEnum.GARBAGE;
    }

    /**
     * Detects four of a kind
     *
     * @param hand a hand of 5 cards
     * @return FOUR_OF_A_KIND if detected, otherwise GARBAGE
     */
    private static PokerHandEnum findFourOfAKind(Hand hand) {
        if (hand.get(0).getRank() == hand.get(1).getRank()
            && hand.get(1).getRank() == hand.get(2).getRank()
            && hand.get(2).getRank() == hand.get(3).getRank()) {
            PokerHandEnum p = PokerHandEnum.FOUR_OF_A_KIND;
            p.setScore(hand.get(4).getRank());
            return p;
        } else if (hand.get(1).getRank() == hand.get(2).getRank()
            && hand.get(2).getRank() == hand.get(3).getRank()
            && hand.get(3).getRank() == hand.get(4).getRank()) {
            PokerHandEnum p = PokerHandEnum.FOUR_OF_A_KIND;
            p.setScore(hand.get(0).getRank());
            return p;
        }
        return PokerHandEnum.GARBAGE;
    }

    /**
     * Detects a straight flush
     *
     * @param hand a hand of 5 cards
     * @return STRAIGHT_FLUSH if detected, otherwise GARBAGE
     */
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

    /**
     * Detects a royal flush
     *
     * @param hand a hand of 5 cards
     * @return ROYAL_FLUSH if detected, otherwise GARBAGE
     */
    private static PokerHandEnum findRoyalFlush(Hand hand) {
        if (
            hand.get(0).getRank() == 0
                && hand.get(1).getRank() == 9
                && hand.get(2).getRank() == 10
                && hand.get(3).getRank() == 11
                && hand.get(4).getRank() == 12
                && hand.get(0).getSuite().equals(hand.get(1).getSuite())
                && hand.get(1).getSuite().equals(hand.get(2).getSuite())
                && hand.get(2).getSuite().equals(hand.get(3).getSuite())
                && hand.get(3).getSuite().equals(hand.get(4).getSuite())
            ) {
            PokerHandEnum p = PokerHandEnum.ROYAL_FLUSH;
            if (hand.get(1).getSuite() == "club") {
                p.setScore(3);
            } else if (hand.get(1).getSuite() == "diamond") {
                p.setScore(2);
            } else if (hand.get(1).getSuite() == "heart") {
                p.setScore(1);
            } else {
                p.setScore(0);
            }
            return p;
        }
        return PokerHandEnum.GARBAGE;

    }
}
