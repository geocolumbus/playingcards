package com.tallgeorge.simple1;

import com.tallgeorge.simple1.deck.CardDeck;
import com.tallgeorge.simple1.deck.Deck;
import com.tallgeorge.simple1.deck.Hand;
import com.tallgeorge.simple1.deck.PokerHandEnum;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 200000; i++) {
            Deck deck = new CardDeck();
            deck.shuffle();
            Hand hand = deck.deal(5);
            PokerHandEnum p = PokerHandEnum.find(hand);
            if (p != PokerHandEnum.GARBAGE) {
                System.out.println(String.format("%6d  %12s %3d   %s",i,p.name(),p.getScore(),hand));
            }
        }
    }
}
