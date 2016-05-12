package com.tallgeorge.simple1.deck;

/**
 * An enumeration of the poker hands.
 */
public enum PokerHandEnum {

    /**
     * Royal flush: 10, J, Q, K, A of the same suite.
     */
    ROYAL_FLUSH(0),

    /**
     * Straight flush: five cards in a row, same suite.
     */
    STRAIGHT_FLUSH(0),

    /**
     * Four of a kind: Four cards with the same value.
     */
    FOUR_OF_A_KIND(0),

    /**
     * Full house: Three of a kind and a pair.
     */
    FULL_HOUSE(0),

    /**
     * Flush: All cards have the same suite.
     */
    FLUSH(0),

    /**
     * Straight: Five cards in a row, not the same suite.
     */
    STRAIGHT(0),

    /**
     * Three of a kind: Three cards of the same value.
     */
    THREE_OF_A_KIND(0),

    /**
     * Two pair: Two sets of pairs of cards.
     */
    TWO_PAIR(0),

    /**
     * One pair: One pair of cards.
     */
    ONE_PAIR(0),

    /**
     * High card: No other hand so value is based on the highest card.
     */
    HIGH_CARD(0),

    /**
     * Null value - never used.
     */
    GARBAGE(0);

    /**
     * The numeric score of the hand for comparing hands of the same type.
     */
    private int score;

    /**
     * Initialize each enumeration score.
     * @param score the score.
     */
    PokerHandEnum(final int score) {
        this.score = score;
    }

    /**
     * Return the poker hand's score.
     * @return the score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Set the poker hand's score.
     * @param score the score.
     */
    public void setScore(final int score) {
        this.score = score;
    }

    /**
     * Finds a poker hand type from a hand of five cards
     * @param hand a poker hand
     * @return poker hand type
     */
    public static PokerHandEnum find(final Hand hand) {

        hand.sort();

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
        p.setScore(calculateScore(hand));
        return p;
    }

    /**
     * Detect one pair
     * @param hand a hand of 5 cards
     * @return ONE_PAIR if detected, otherwise GARBAGE
     */
    private static PokerHandEnum findOnePair(Hand hand) {
        if (hand.get(0).getRank() == hand.get(1).getRank()
            || hand.get(1).getRank() == hand.get(2).getRank()
            || hand.get(2).getRank() == hand.get(3).getRank()
            || hand.get(3).getRank() == hand.get(4).getRank()) {
            PokerHandEnum p = PokerHandEnum.ONE_PAIR;
            p.setScore(calculateScore(hand));
            return p;
        }
        return PokerHandEnum.GARBAGE;
    }

    /**
     * Score the hand, in case two hands are the same.
     * @param hand a playing card.
     * @return the score.
     */
    private static int calculateScore(final Hand hand) {
        int score = hand.get(4).getRank();
        if (score == 0) score = 13;
        return score;
    }

    /**
     * Detect two pairs
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
            p.setScore(calculateScore(hand));
            return p;
        }
        return PokerHandEnum.GARBAGE;
    }

    /**
     * Detect three of a kind.
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
            p.setScore(calculateScore(hand));
            return p;
        }
        return PokerHandEnum.GARBAGE;
    }

    /**
     * Detects a straight.
     * @param hand a hand of 5 cards
     * @return STRAIGHT if detected, otherwise GARBAGE
     */
    private static PokerHandEnum findStraight(Hand hand) {
        if (hand.get(0).getRank() == hand.get(1).getRank() - 1
            && hand.get(1).getRank() == hand.get(2).getRank() - 1
            && hand.get(2).getRank() == hand.get(3).getRank() - 1
            && hand.get(3).getRank() == hand.get(4).getRank() - 1) {
            PokerHandEnum p = PokerHandEnum.STRAIGHT;
            p.setScore(calculateScore(hand));
            return p;
        }
        return PokerHandEnum.GARBAGE;
    }

    /**
     * Detects a flush
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
            p.setScore(calculateScore(hand));
            return p;
        }
        return PokerHandEnum.GARBAGE;
    }

    /**
     * Detects a full house
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
            p.setScore(calculateScore(hand));
            return p;
        }
        return PokerHandEnum.GARBAGE;
    }

    /**
     * Detects four of a kind
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
            p.setScore(calculateScore(hand));
            return p;
        }
        return PokerHandEnum.GARBAGE;
    }

    /**
     * Detects a straight flush
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
            p.setScore(calculateScore(hand));
            return PokerHandEnum.STRAIGHT_FLUSH;
        }
        return PokerHandEnum.GARBAGE;
    }

    /**
     * Detects a royal flush
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
            if (hand.get(1).getSuite().equals("club")) {
                p.setScore(3);
            } else if (hand.get(1).getSuite().equals("diamond")) {
                p.setScore(2);
            } else if (hand.get(1).getSuite().equals("heart")) {
                p.setScore(1);
            } else {
                p.setScore(0);
            }
            return p;
        }
        return PokerHandEnum.GARBAGE;

    }
}
