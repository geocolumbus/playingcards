# A deck of cards.

Building out a card game framework. Working it from a strict TDD approach as an exercise.

## Odds of being dealt a given hand from a shuffled deck

<pre>              
     ROYAL_FLUSH   0.000155 (1 in  644890.0)
  STRAIGHT_FLUSH   0.001385 (1 in   72225.6)
  FOUR_OF_A_KIND   0.024031 (1 in    4161.4)
      FULL_HOUSE   0.144061 (1 in     694.1)
           FLUSH   0.196430 (1 in     509.1)
        STRAIGHT   0.353143 (1 in     283.2)
 THREE_OF_A_KIND   2.108099 (1 in      47.4)
        TWO_PAIR   4.730096 (1 in      21.1)
        ONE_PAIR  40.158516 (1 in       2.5)
       HIGH_CARD  47.118204 (1 in       2.1)
         GARBAGE   0.000000 (1 in  Infinity)

Duration was 4878.025 seconds for 2,147,483,647 iterations at 2.272 μsec/iteration.
</pre>
