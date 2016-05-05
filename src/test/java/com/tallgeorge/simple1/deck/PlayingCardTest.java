package com.tallgeorge.simple1.deck;

import org.junit.Test;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class PlayingCardTest {

    @Test
    public void cardIndexCorrect() {
        PlayingCardEnum threeOfClubs = PlayingCardEnum.values()[28];
        assertEquals("Card 28 has correct value","three",threeOfClubs.getValue());
        assertEquals("Card 28 has correct suite","club",threeOfClubs.getSuite());
        assertEquals("Card 28 has correct valueabbr","3",threeOfClubs.getValueAbbr());
        assertEquals("Card 28 has correct symbol","3♣",threeOfClubs.getSymbol());
    }

    @Test
    public void equalsMethodWorks() {
        PlayingCardEnum threeOfClubs = PlayingCardEnum.values()[28];
        PlayingCardEnum fourOfClubs = PlayingCardEnum.values()[29];
        assertTrue("Three of Clubs equals Three of Clubs",threeOfClubs.equals(threeOfClubs));
        assertFalse("Three of Clubs not equal to four of Clubs",threeOfClubs.equals(fourOfClubs));
    }
}