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
     * @param args command line argument array.
     */
    public static void main(final String[] args) {
        Map<PokerHandEnum, Integer> bin = new TreeMap<>();
        for (PokerHandEnum p : PokerHandEnum.values()) {
            bin.put(p, 0);
        }
        int total = Integer.MAX_VALUE / 64;
        Instant start = Instant.now();
        IntStream.range(0, total).parallel().forEach(i -> {
            Deck deck = new CardDeck();
            deck.shuffle();
            Hand hand = deck.deal(5);
            PokerHandEnum p = PokerHandEnum.find(hand);
            bin.put(p, bin.get(p) + 1);
        });
        Instant stop = Instant.now();
        System.out.println("");
        bin.keySet().stream().forEach(k -> {
            double p = (bin.get(k) * 1.0) / total * 100.0;
            double o = (100 / p);
            System.out.println(String.format("%16s  %9.6f (1 in %9.1f)", k, p, o));
        });
        Double sec = Duration.between(start, stop).toMillis() / 1000.0;
        DecimalFormat formatter = new DecimalFormat("#,###");
        System.out.println(String.format("\nDuration was %6.3f seconds for %s iterations at %5.3f usec/iteration.",
            sec, formatter.format(total), sec / total * 1e6));
    }
}
