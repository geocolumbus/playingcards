# A deck of cards.

Building out a card game framework. Working it from a strict TDD approach as an exercise.

## Odds of being dealt a given hand from a shuffled deck

Calculated by running 2^31-1 trials.

<pre>       
      Hand         Percent       Odds
----------------  --------- ---------------
     ROYAL_FLUSH   0.000152 (1 in  656321.4)
  STRAIGHT_FLUSH   0.001393 (1 in   71798.2)
  FOUR_OF_A_KIND   0.024015 (1 in    4164.1)
      FULL_HOUSE   0.143958 (1 in     694.6)
           FLUSH   0.196519 (1 in     508.9)
        STRAIGHT   0.352855 (1 in     283.4)
 THREE_OF_A_KIND   2.109033 (1 in      47.4)
        TWO_PAIR   4.736823 (1 in      21.1)
        ONE_PAIR  40.638034 (1 in       2.5)
       HIGH_CARD  47.887406 (1 in       2.1)
</pre>
