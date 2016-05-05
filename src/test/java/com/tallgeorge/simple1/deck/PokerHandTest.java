package com.tallgeorge.simple1.deck;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokerHandTest {

    @Test
    public void detectsRoyalFlush(){
        //PlayingCard card1 = new PlayingCard("hearts","10");
        //PlayingCard card2 = new PlayingCard("hearts","jack");
        //PlayingCard card3 = new PlayingCard("hearts","queen");
        //PlayingCard card4 = new PlayingCard("hearts","king");
        //PlayingCard card5 = new PlayingCard("hearts","ace");
        //Hand hand = new PlayingHand(card1,card2,card3,card4,card5);
        //assertEquals("Should detect a Royal Flush",ROYAL_FLUSH,hand.getPokerHand());
        //assertEquals("Should score a Royal Flush 1",1,hand.getPokerScore());
    }

    @Test
    public void detectsStraightFlush(){}

    @Test
    public void detectsFourOfAKind(){}

    @Test
    public void detectsFullHouse(){}

    @Test
    public void detectsFlush(){}

    @Test
    public void detectsStraight(){}

    @Test
    public void detectsThreeOfAKind(){}

    @Test
    public void detectsTwoPair(){}

    @Test
    public void detectsOnePair(){}

    @Test
    public void detectsHighCard(){}
}
