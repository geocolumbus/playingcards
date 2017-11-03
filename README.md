# Millions of Five Card Poker Hands

For fun, I am building out a card game framework and working it from a strict TDD approach as an exercise. This program uses brute force to randomly generate millions of five card poker hands and classifies them as to type and uses the count to calculate the odds. Big numbers are always interesting - generating 34 million hands means you'll get around 42 Royal Flushes!

## Requirements

This is what I'm running - lesser minor versions will probably work fine.

* maven 3.3.9
* java 1.8.0_101

## Usage

```
git clone https://github.com/geocolumbus/playingcards.git
mvn clean package
java -jar target/playingcards-1.0-SNAPSHOT.jar
```

## Results

The odds of being dealt a given five card hand from a shuffled deck. Note that "garbage" is zero because I caught every possible type of hand in my category list.

```
Creating 33,554,431 random poker hands...

Duration was 263.650 seconds for 33,554,431 iterations at 7.857 usec/iteration.

     ROYAL_FLUSH              53  (1 in  633102.5)
  STRAIGHT_FLUSH             465  (1 in   72160.1)
  FOUR_OF_A_KIND           7,878  (1 in    4259.3)
      FULL_HOUSE          48,237  (1 in     695.6)
           FLUSH          65,821  (1 in     509.8)
        STRAIGHT         119,276  (1 in     281.3)
 THREE_OF_A_KIND         708,334  (1 in      47.4)
        TWO_PAIR       1,593,711  (1 in      21.1)
        ONE_PAIR      14,179,666  (1 in       2.4)
       HIGH_CARD      16,830,990  (1 in       2.0)
         GARBAGE               0  (1 in  Infinity)
```

Compare this result with the official odds of being dealt a hand. The more hands tried, the more accurate the results.

[Wikipedia: Frequency of 5-card poker hands](https://en.wikipedia.org/wiki/Poker_probability#Frequency_of_5-card_poker_hands)
