// author: louis cerda
// file: yahtzee.java
// date: oct 9 2022
// class: CPSC224

import java.util.*;

public class Yahtzee
{
    Yahtzee()
    {
    }

    public char playAgainInput(Scanner kb)
    {
        System.out.println("Would you like to keep playing (y/n) ");
        String Line2 = kb.nextLine();
        // playAgain = Line2.charAt(0);
        return  Line2.charAt(0);
    }


    public void printingRoll(int[] hand, int diceInPlay)
    {
        System.out.println("Your roll was: ");
        for (int dieNum = 0; dieNum < diceInPlay; dieNum++)
            System.out.print(hand[dieNum] + " ");

    }

    public String makeNoString(int diceInPlay)
    {
        String keep = "";
        for (int i = 0; i < diceInPlay; i++)
                keep += "n";
        return keep;
    }

    public void rollDieAtIdx(int diceInPlay, String keep, int[] hand, int sides, Dice die)
    {
        for (int dieNum = 0; dieNum < diceInPlay; dieNum++)
        {
            char idx = keep.charAt(dieNum);
            char y = 'y';
            if (idx != y)
                hand[dieNum] = die.rollDie(sides);
        }
    }


    public String scoreboardOrEnterDiceInput(int turn, int maxRolls, Scanner kb, int[] hand, ArrayList<String> upperLowerArr, ScoreCard score)
    {
        String line1 = "";
        boolean flag = true;
        if (turn < maxRolls)
        {
            if (flag)
                System.out.print("\nEnter dice to keep (y or n) or enter S for scorecard\n");
            line1 = kb.nextLine();
            if (line1.contains("S") || (line1.contains("s")))
            {
                score.printScoreCard(hand, upperLowerArr);
                System.out.println("Enter the dice you would like to keep: ");
                line1 = kb.nextLine();
                flag = false;
            }
            // this.keep = line1;
        }
        return line1;
    }
}