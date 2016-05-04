package com.tallgeorge.simple1.deck;

import org.junit.Test;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class PlayingCardTest {

    @Test
    public void cardIndexCorrect() {
        Card threeOfClubs = new PlayingCard(28);
        assertTrue("Card 28 is three of clubs", threeOfClubs.getSuite().equals("club") && threeOfClubs.getValue().equals("three"));
        assertTrue("Card 28 returns index of 28", threeOfClubs.getIndex() == 28);
    }

    @Test
    public void cardIndexReturns() {
        Card threeOfClubs = new PlayingCard(28);
        assertTrue("Card 28 returns index of 28", threeOfClubs.getIndex() == 28);
    }

    @Test
    public void cardPrintsValue() {
        Card threeOfClubs = new PlayingCard(28);
        assertEquals("ThreeOfClubsPrintsProperly", "3♣", threeOfClubs.toString());
    }

    @Test
    public void equalsMethodWorks() {
        Card threeOfClubs = new PlayingCard(28);
        Card fourOfClubs = new PlayingCard(29);
        assertTrue(threeOfClubs.equals(threeOfClubs));
        assertFalse(threeOfClubs.equals(fourOfClubs));
    }
}