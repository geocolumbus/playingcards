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

## Use All The Cores!

The programs's main loop takes advantage of Java 8 stream processing, and specifically by inserting .parallel() into the chain.

```
        IntStream.range(0, numberOfPokerHands).parallel().forEach(i -> {
            Deck deck = new CardDeck();
            deck.shuffle();
            Hand hand = deck.deal(5);
            PokerHandEnum p = PokerHandEnum.find(hand);
            bin.put(p, bin.get(p) + 1);
        });
```

On my mac, I use ```htop``` from the command line. (```brew install htop```). htop shows all the cores loading up as this program makes full use of my MacBook Pro's available cores.

## Results

The odds of being dealt a given five card hand from a shuffled deck. Note that "garbage" is zero because I caught every possible type of hand in my category list.

```
Creating and evaluating 33,554,431 poker hands...

Duration was 73.134 seconds for 33,554,431 iterations at 2.180 usec/iteration.

     ROYAL_FLUSH              42  (1 in  798915.0)
  STRAIGHT_FLUSH             449  (1 in   74731.5)
  FOUR_OF_A_KIND           8,059  (1 in    4163.6)
      FULL_HOUSE          48,337  (1 in     694.2)
           FLUSH          65,602  (1 in     511.5)
        STRAIGHT         118,159  (1 in     284.0)
 THREE_OF_A_KIND         706,837  (1 in      47.5)
        TWO_PAIR       1,588,372  (1 in      21.1)
        ONE_PAIR      13,311,357  (1 in       2.5)
       HIGH_CARD      15,709,081  (1 in       2.1)
         GARBAGE               0  (1 in  Infinity)
```

Compare this result with the official odds of being dealt a hand. The more hands tried, the more accurate the results.

[Wikipedia: Frequency of 5-card poker hands](https://en.wikipedia.org/wiki/Poker_probability#Frequency_of_5-card_poker_hands)
