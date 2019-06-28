# Millions of Five Card Poker Hands

For fun, I am building out a card game framework and working it from a strict TDD approach as an exercise. This program uses brute force to randomly generate millions of five card poker hands and classifies them as to type and uses the count to calculate the odds. Big numbers are always interesting - generating 33,554,431 hands means you'll get around 53 Royal Flushes!

## Requirements

This is what I'm running - lesser minor versions will probably work fine.

* maven 3.6.0
* java 8 or greater

## Usage

```
git clone https://github.com/geocolumbus/playingcards.git
mvn clean package
java -jar target/playingcards-1.0-SNAPSHOT.jar
```

## Results

The odds of being dealt a given five card hand from a shuffled deck.

```
Creating 2,147,483,647 random poker hands...

Duration was 19033.861 seconds for 2,147,483,647 iterations at 8.863 usec/iteration.

     ROYAL_FLUSH           3,247  (1 in  661373.7)
  STRAIGHT_FLUSH          29,976  (1 in   71639.1)
  FOUR_OF_A_KIND         515,501  (1 in    4164.8)
      FULL_HOUSE       3,093,416  (1 in     693.2)
           FLUSH       4,219,124  (1 in     508.0)
        STRAIGHT       7,584,587  (1 in     282.1)
 THREE_OF_A_KIND      45,365,133  (1 in      46.3)
        TWO_PAIR     102,100,220  (1 in      20.0)
        ONE_PAIR     907,467,797  (1 in       1.4)
       HIGH_CARD   1,077,104,646  (1 in       1.0)
```

Compare this result with the official odds of being dealt a hand. The more hands tried, the more accurate the results.

[Wikipedia: Frequency of 5-card poker hands](https://en.wikipedia.org/wiki/Poker_probability#Frequency_of_5-card_poker_hands)
