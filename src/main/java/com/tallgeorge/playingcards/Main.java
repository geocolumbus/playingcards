package com.tallgeorge.playingcards;

import com.tallgeorge.playingcards.deck.CardDeck;
import com.tallgeorge.playingcards.deck.Deck;
import com.tallgeorge.playingcards.deck.Hand;
import com.tallgeorge.playingcards.deck.PokerHandEnum;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * Main class of the application.
 */
public class Main {

    /**
     * Main entrance to the application.
     *
     * @param args command line argument array.
     */
    public static void main(final String[] args) {

        int numberOfPokerHands = Integer.MAX_VALUE / 64;

        Map<PokerHandEnum, Integer> pokerHands = new TreeMap<>();
        for (PokerHandEnum pokerHandEnum : PokerHandEnum.values()) {
            pokerHands.put(pokerHandEnum, 0);
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        System.out.println(String.format("\nCreating %s random poker hands...", formatter.format(numberOfPokerHands)));
        Instant start = Instant.now();
        IntStream.range(0, numberOfPokerHands).forEach(i -> {
            Deck deck = new CardDeck();
            deck.shuffle();
            Hand hand = deck.deal(5);
            PokerHandEnum p = PokerHandEnum.find(hand);
            pokerHands.put(p, pokerHands.get(p) + 1);
        });
        Instant stop = Instant.now();

        Double sec = Duration.between(start, stop).toMillis() / 1000.0;
        System.out.println(String.format("\nDuration was %6.3f seconds for %s iterations at %5.3f usec/iteration.\n",
                sec, formatter.format(numberOfPokerHands), sec / numberOfPokerHands * 1e6));

        pokerHands.keySet().stream().forEach(key -> {
            double proportionOfHands = (pokerHands.get(key) * 1.0) / numberOfPokerHands * 100.0;
            double oddsOfPokerHand = (100 / proportionOfHands);
            System.out.println(String.format("%16s %15s  (1 in %9.1f)", key, formatter.format(pokerHands.get(key)), oddsOfPokerHand));
        });

    }
}
