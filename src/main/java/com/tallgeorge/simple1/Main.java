package com.tallgeorge.simple1;

import com.tallgeorge.simple1.deck.CardDeck;
import com.tallgeorge.simple1.deck.Deck;

/**
 * Created by campbelg on 5/3/16.
 */
public class Main {
    public static void main(String[] args) {
        Deck deck = new CardDeck();
        System.out.println(deck);
        deck.shuffle();
        System.out.println(deck);
    }
}
