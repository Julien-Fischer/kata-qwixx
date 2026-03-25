# Qwixx Kata

[Qwixx](https://de.wikipedia.org/wiki/Qwixx) is a fast-paced dice game played with six eight-sided dice.

Your task in this kata is not to implement the full game, but only the scoring logic.

If you like this kata, you may be interested in my website [Parlons Craft](https://craft.coach).

# Rules

## Scoresheet

Each player has a scoresheet consisting of four colored rows and four "failed roll" spaces.

The red and yellow rows increase from left to right, while the green and blue rows decrease:

```
        ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐
   RED  │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │10 │11 │12 │13 │14 │15 │16 │ 
        ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤
YELLOW  │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │10 │11 │12 │13 │14 │15 │16 │ 
        ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤
 GREEN  │16 │15 │14 │13 │12 │11 │10 │ 9 │ 8 │ 7 │ 6 │ 5 │ 4 │ 3 │ 2 │ 
        ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤
  BLUE  │16 │15 │14 │13 │12 │11 │10 │ 9 │ 8 │ 7 │ 6 │ 5 │ 4 │ 3 │ 2 │ 
        └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘
```

## Dice

On a player's turn, all six eight-sided dice are rolled:

- 2 white dice
- 1 red die
- 1 yellow die
- 1 green die
- 1 blue die

## Crossing off numbers

After rolling, the active player may take one, both, or none of the following actions:
- Add the two white dice and cross off that total in any colored row.
- Add one white die and one colored die and cross off that total in the corresponding colored row.

Numbers must be crossed off from **left to right** in each row. You may skip numbers, but once skipped,
they may no longer be crossed off later.

### Example

If you cross off 4 and then 7 in the red row, all numbers lower than 8 are no longer available:
```
                  X           X
        ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐
   RED  │ 2 │ 3 │ 4 │ 5 │ 6 │ 7 │ 8 │ 9 │10 │11 │12 │13 │14 │15 │16 │ 
        └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘
```

You can still cross off 8 or any higher number in this row, or choose to cross off a number in a different row.

## Failed rolls

If, after both actions, the player cannot (or chooses not to) cross off any number, they must mark one of their failed roll spaces.
Each failed roll is worth -5 points at the end of the game.

## Locking a row

Locking a row means crossing off one of its two rightmost numbers.

Before you can cross one of these numbers, you must first have crossed off at least six numbers in that row.

### Examples

In this example, the red row cannot be locked yet, as it still needs one more crossed-off number.
The yellow row, however, can be locked because it already has six.
By crossing off either 15 or 16 in the yellow row, the row will be locked.

```
        ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐
   RED  │ 2 │ 3 │ x │ 5 │ 6 │ x │ 8 │ x │10 │11 │ x │ x │14 │15 │16 │ 
        ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤
YELLOW  │ x │ x │ 4 │ x │ x │ 7 │ x │ x │10 │11 │12 │13 │14 │15 │16 │ 
        └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘
```

## End of the Game

The game ends when any player either:
- locks a **second row** in their scoresheet
- crosses off their **fourth failed roll**

### Examples

#### Two rows locked

```
        ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐
   RED  │ 2 │ x │ 4 │ x │ 6 │ 7 │ 8 │ x │ x │11 │ x │ x │14 │15 │ x │ 
        ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤
  BLUE  │ x │15 │14 │ x │ x │11 │10 │ x │ x │ 7 │ 6 │ x │ 4 │ x │ 2 │ 
        └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘
```
A second row was locked, game is over.

#### Four failed rolls

```
Failed rolls: X X X X
```
A fourth failed roll was crossed off, game is over.

## Scoring

Each row scores based on how many boxes are crossed off, as shown below:

```
         ┌───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┬───┐
crosses  │1x │2x │3x │4x │5x │6x │7x │8x │9x │10x│11x│12x│13x│14x│15x│
         ├───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┼───┤
 points  │ 1 │ 3 │ 6 │10 │15 │21 │28 │36 │45 │55 │66 │78 │91 │105│120│
         └───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┴───┘
```

Each failed roll subtracts 5 points from the total score.
Add up the points from all four color rows, then subtract the penalties:

`T = ∑(RED, YELLOW, GREEN, BLUE) − 5 × FAILED ROLLS`

The player with the highest total score wins.

## What you will learn

The goal of this kata is to experiment with different styles of modeling and consider their potential tradeoffs.

Experiment with different approaches. For instance:
- Can you use a divide and conquer approach to solve this problem?
- How would you ensure most of the program proves itself at compile-time?
- How will you use tests to define behavior that hasn't been implemented yet?

## Acknowledgments

This kata was inspired by [this wonderful Kata](https://github.com/emilybache/Yatzy-Refactoring-Kata/) from Emily Bache.

The Qwixx game was designed by [Steffen Benndorf](https://de.wikipedia.org/wiki/Steffen_Benndorf). This kata is based on a (slight) personal variation of the official rules.