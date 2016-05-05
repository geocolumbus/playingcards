package com.tallgeorge.simple1;

import com.tallgeorge.simple1.deck.CardDeck;
import com.tallgeorge.simple1.deck.Deck;
import com.tallgeorge.simple1.deck.Hand;
import com.tallgeorge.simple1.deck.PlayingHand;
import com.tallgeorge.simple1.deck.PokerHandEnum;

/**
 * Created by campbelg on 5/3/16.
 */
public class Main {
    public static void main(String[] args) {
        for (int i=0; i<1000; i++) {
            Deck deck = new CardDeck();
            deck.shuffle();
            Hand hand = deck.deal(5);
            System.out.println(hand);
            if (PokerHandEnum.find(hand) == PokerHandEnum.ROYAL_FLUSH) {
                System.out.println(i + " " + hand);
            }
        }
    }
}
