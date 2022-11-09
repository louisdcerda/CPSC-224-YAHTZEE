// author: louis cerda
// file: yahtzee.java
// date: nov 1 2022
// class: CPSC224

import java.util.*;
public class yahtzeeMain {

    public static char playAgain = 'y';
    String keep = "";

    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        Dice die = new Dice();
        die.readFromFile(kb);

        Yahtzee yahtzee = new Yahtzee();
        ScoreCard score = new ScoreCard();

        LowerScorecard lower = new LowerScorecard();
        
        // creating an array list to make it easier to access which element are still in play 
        ArrayList<String> upperLowerArr = new ArrayList<String>();
        upperLowerArr = lower.changeInitialArr(upperLowerArr);

        // getting private data member from die class
        int diceInPlay = die.getDice();
        int maxRolls = die.getTurns();
        int sides = die.getSides();

        // instantalating a new hand
        int[] hand = new int[diceInPlay];  

        // while playagain var is 'y' 
        while (Character.compare(playAgain, 'y') == 0)
        {
            String keep = yahtzee.makeNoString(diceInPlay);
            int turn = 1;

            // string that is being compared to at the start 
            while (turn < 4 && keep.contains("n"))
            {
                yahtzee.rollDieAtIdx(diceInPlay, keep, hand, sides, die);
                yahtzee.printingRoll(hand,diceInPlay);
                keep = yahtzee.scoreboardOrEnterDiceInput(turn, maxRolls, kb, hand, upperLowerArr, score);
                turn ++;
            }
            // sorting and printing hand
            die.sortArray(hand, diceInPlay);
            score.printSortedHand(hand, diceInPlay);
            // printing scores from scoreCard class
            score.printScoreCard(hand, upperLowerArr);
            score.scoreInputChange(kb, upperLowerArr, hand);
            playAgain = yahtzee.playAgainInput(kb);
        }
        kb.close();
    }
}
