package com.tallgeorge.playingcards.deck;

import org.junit.Test;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;


public class CardDeckTest {

    private static final String[] VALUES = {
        "ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"
    };
    private static final String[] SUITES = {"spade", "diamond", "club", "heart"};

    @Test
    public void first13CardsShouldBeInOrder() {
        Deck cardDeck = new CardDeck();
        assertArrayEquals("First 13 values are in order.",
            VALUES,
            IntStream.range(0, 13).boxed().map(cardDeck::get).map(PlayingCardEnum::getValue).toArray());
    }

    @Test
    public void second13CardsShouldBeInOrder() {
        Deck cardDeck = new CardDeck();
        assertArrayEquals("Second 13 values are in order.",
            VALUES,
            IntStream.range(13, 26).boxed().map(cardDeck::get).map(PlayingCardEnum::getValue).toArray());
    }

    @Test
    public void third13CardsShouldBeInOrder() {
        Deck cardDeck = new CardDeck();
        assertArrayEquals("Second 13 values are in order.",
            VALUES,
            IntStream.range(26, 39).boxed().map(cardDeck::get).map(PlayingCardEnum::getValue).toArray());
    }

    @Test
    public void fourth13CardsShouldBeInOrder() {
        Deck cardDeck = new CardDeck();
        assertArrayEquals("Second 13 values are in order.",
            VALUES,
            IntStream.range(39, 52).boxed().map(cardDeck::get).map(PlayingCardEnum::getValue).toArray());
    }

    /**
     * A new deck should be in order.
     */
    @Test
    public void suitesAreInCorrectOrder() {
        Deck cardDeck = new CardDeck();
        assertTrue(
            IntStream.range(0, 13).boxed().map(cardDeck::get).filter((x) -> x.getSuite().equals(SUITES[0])).count() == 13
                && IntStream.range(13, 26).boxed().map(cardDeck::get).filter((x) -> x.getSuite().equals(SUITES[1])).count() == 13
                && IntStream.range(26, 39).boxed().map(cardDeck::get).filter((x) -> x.getSuite().equals(SUITES[2])).count() == 13
                && IntStream.range(39, 52).boxed().map(cardDeck::get).filter((x) -> x.getSuite().equals(SUITES[3])).count() == 13
        );
    }

    /**
     * Make sure the deck is shuffled, and not in order.
     */
    @Test
    public void shuffledDeckIsOutOfOrder() {
        Deck cardDeck = new CardDeck();
        cardDeck.shuffle();
        assertTrue(
            IntStream.range(0, 13).boxed().map(cardDeck::get).filter((x) -> x.getSuite().equals(SUITES[0])).count() != 13
                && IntStream.range(13, 26).boxed().map(cardDeck::get).filter((x) -> x.getSuite().equals(SUITES[1])).count() != 13
                && IntStream.range(26, 39).boxed().map(cardDeck::get).filter((x) -> x.getSuite().equals(SUITES[2])).count() != 13
                && IntStream.range(39, 52).boxed().map(cardDeck::get).filter((x) -> x.getSuite().equals(SUITES[3])).count() != 13
        );
    }

    /**
     * Verify the shuffled deck contains 52 unique cards.
     */
    @Test
    public void shuffledDeckHasAllCards() {
        Deck cardDeck = new CardDeck();
        cardDeck.shuffle();
        Map<String, Integer> valueMap = IntStream.range(0, 13).boxed().collect(toMap(i -> VALUES[i], i -> i));
        Map<String, Integer> suiteMap = IntStream.range(0, 4).boxed().collect(toMap(i -> SUITES[i], i -> i));

        assertTrue("Each card is represented once in the shuffled deck.",
            IntStream.range(0, 52).boxed()
                .map(cardDeck::get)
                .map(c -> valueMap.get(c.getValue()) + 13 * suiteMap.get(c.getSuite()))
                .collect(Collectors.toSet())
                .size() == 52
        );
    }

    /**
     * Verify removing a card from the deck reduces the count.
     */
    @Test
    public void removingACardSetsTheDeckSizeTo51() {
        Deck cardDeck = new CardDeck();
        assertEquals("Deck should contain 52 cards.", 52, cardDeck.size());
        cardDeck.pullFromTop();
        assertEquals("Deck should contain 51 cards.", 51, cardDeck.size());
    }

    /**
     * Verify that the card pulled from the top of a new deck is the ace of spades.
     */
    @Test
    public void removingACardReturnsTheCard() {
        Deck cardDeck = new CardDeck();
        PlayingCardEnum playingCard = cardDeck.pullFromTop();
        assertTrue("Ace of spades was pulled off the top of the deck",
            playingCard.getSuite().equals("spade") && playingCard.getValue().equals("ace"));
    }

    /**
     * You cannot add a duplicate card
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void cannotAddDuplicateCard() {
        Deck cardDeck = new CardDeck();
        PlayingCardEnum playingCard = PlayingCardEnum.values()[0];
        cardDeck.add(playingCard);
    }

    @Test
    public void canAddNoneDuplicateCard() {
        Deck cardDeck = new CardDeck();
        PlayingCardEnum playingCard = cardDeck.pullFromTop();
        cardDeck.add(playingCard);
        assertEquals("Deck should have 52 cards", 52, cardDeck.size());
    }

    @Test
    public void canDealFiveCards() {
        Deck cardDeck = new CardDeck();
        Hand hand = cardDeck.deal(5);
        assertEquals("Hand has five cards", 5, hand.getSize());
        assertEquals("Hand is first five cards", " A♠  2♠  3♠  4♠  5♠", hand.toString());
    }

    /**
     * Print the deck contents using card symbols
     */
    @Test
    public void testToString() {
        Deck cardDeck = new CardDeck();
        assertEquals("Deck is displayed with symbols",
            " A♠  2♠  3♠  4♠  5♠  6♠  7♠  8♠  9♠ 10♠  J♠  Q♠  K♠ " +
                " A♦  2♦  3♦  4♦  5♦  6♦  7♦  8♦  9♦ 10♦  J♦  Q♦  K♦ " +
                " A♣  2♣  3♣  4♣  5♣  6♣  7♣  8♣  9♣ 10♣  J♣  Q♣  K♣ " +
                " A♥  2♥  3♥  4♥  5♥  6♥  7♥  8♥  9♥ 10♥  J♥  Q♥  K♥", cardDeck.toString());
    }
}
