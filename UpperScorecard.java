import java.util.*;

public class UpperScorecard
{ 
    int dice = Dice.diceNums;
    UpperScorecard(){
    }

    Dice die = new Dice();
    
    PlayCard play = new PlayCard(dice);



    /**
    * method that prints the upper scores of yahtzee 
    * 
    * @author	Louis Cerda
    *
    * @param hand the arry of ints filled with dice roll
    * 
    * @param list arraylist of string that has all the possible scoring values
    *
    */
    public void printUpperScore(int[] hand, ArrayList<String> list)
    {   
        if (list.contains("3K"))
        {
            if (play.maxOfAKindFound(hand) >= 3)
                System.out.println("3K (3K) : " + die.totalAllDice(hand));
            else System.out.println("3K (3K) : 0");
        }

        if (list.contains("4K"))
        {
            if (play.maxOfAKindFound(hand) >= 4)
                System.out.println("4K (4K) : " + die.totalAllDice(hand));
            else System.out.println("4k (4K) : 0");
        }

        if (list.contains("FH"))
        {
            if (play.fullHouseFound(hand))
                System.out.println("Full House (FH) : 25 ");
            else System.out.println("Full House (FH) : 0");
        }

        if (list.contains("SS"))
        {
            if (play.maxStraightFound(hand) >= 4)
                System.out.println("Small Straight (SS) : 30");
            else System.out.println("Small Straight (SS) : 0");
        }

        if (list.contains("LS"))
        {
            if (play.maxStraightFound(hand) >= 5)
                System.out.println("Large Straight (LS) : 40");
            else System.out.println("Large Straight (LS) : 0");
        }


        if (list.contains("YL"))
        {
            if (play.maxOfAKindFound(hand) >= 5)
                System.out.println("Yahtzee line (YL) : 50 ");
            else System.out.println("Yahtzee line (YL) : 0");
        }


        if (list.contains("C"))
            System.out.println("Chance (C) : " + die.totalAllDice(hand));
    }






    // for test purposes
    public String testPrintingUpper(ArrayList<String> list)
    {
        if (list.contains("C"))
            return "Chance (C)";
        return null;
    }
}










