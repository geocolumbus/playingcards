package com.tallgeorge.simple1.deck;

import static com.tallgeorge.simple1.deck.PokerHandEnum.*;

public class HandCalculator implements Calculator {

    public static PokerHandEnum getPokerHand(Hand hand) {

        if (isStraight(hand)) {
            return STRAIGHT;
        } else if (isThreeOfAKind(hand)) {
            return THREE_OF_A_KIND;
        } else if (isTwoPair(hand)) {
            return TWO_PAIR;
        } else if (isOnePair(hand)) {
            return ONE_PAIR;
        } else return HIGH_CARD;
    }

    //public static boolean isFlush(Hand hand) {}

    public static boolean isStraight(Hand hand) {
        return hand.get(0).getRank() == hand.get(1).getRank() - 1
            && hand.get(1).getRank() == hand.get(2).getRank() - 1
            && hand.get(2).getRank() == hand.get(3).getRank() - 1
            && hand.get(3).getRank() == hand.get(4).getRank() - 1;
    }

    public static boolean isThreeOfAKind(Hand hand) {
        return (hand.get(0).getRank() == hand.get(1).getRank()
            && hand.get(1).getRank() == hand.get(2).getRank())
            || (hand.get(1).getRank() == hand.get(2).getRank()
            && hand.get(2).getRank() == hand.get(3).getRank())
            || (hand.get(2).getRank() == hand.get(3).getRank()
            && hand.get(3).getRank() == hand.get(4).getRank());
    }

    public static boolean isTwoPair(Hand hand) {
        return (hand.get(0).getRank() == hand.get(1).getRank()
            && hand.get(2).getRank() == hand.get(3).getRank())
            || ((hand.get(0).getRank() == hand.get(1).getRank()
            && hand.get(3).getRank() == hand.get(4).getRank()))
            || ((hand.get(1).getRank() == hand.get(2).getRank()
            && hand.get(3).getRank() == hand.get(4).getRank()));
    }

    public static boolean isOnePair(Hand hand) {
        return hand.get(0).getRank() == hand.get(1).getRank()
            || hand.get(1).getRank() == hand.get(2).getRank()
            || hand.get(2).getRank() == hand.get(3).getRank()
            || hand.get(3).getRank() == hand.get(4).getRank();
    }

    /**
     * Score the hand, in case two hands are the same.
     *
     * @param hand
     * @return
     */
    private static int calculateScore(Hand hand) {
        int score = hand.get(4).getRank();
        if (score == 0) score = 13; // Aces high
        return score;
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
            p.setScore(calculateScore(hand));
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
            p.setScore(calculateScore(hand));
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
            p.setScore(calculateScore(hand));
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
            p.setScore(calculateScore(hand));
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
