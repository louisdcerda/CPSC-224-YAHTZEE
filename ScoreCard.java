// author: louis cerda
// file: ScoreCard.java
// date: oct 09 2022
// class: CPSC224


import java.util.*;


public class ScoreCard{

    // int[] hand;
    public int totalScore;
    int dice = Dice.diceNums;

    ScoreCard(){
        // this.hand = hand;
    }

    LowerScorecard lower = new LowerScorecard();
    UpperScorecard upper = new UpperScorecard();
    Dice die = new Dice();
    PlayCard play = new PlayCard(dice);



    /**
    * method that prints the sorted hand  
    * 
    * @author	Louis Cerda
    *
    * @param hand is a int arr of the dice and their roll for that play
    * @param diceInPlay is the int dice that are in play during the game 
    *
    * @see Dice class sortedhand() would hlep in understandng
    * 
    */
    public void printSortedHand(int[] hand, int diceInPlay)
    {
        System.out.println("Here is your sorted hand: ");
        for (int dieNum = 0; dieNum < diceInPlay; dieNum++)
            System.out.print(hand[dieNum] + " ");
        System.out.println(" ");
    }




        /**
    * method that returns the random int for a score on the dice
    * 
    * @author	Louis Cerda
    *
    * @param hand int array of the dice rolled on each index
    *
    * @param upperLowerArr arraylist that is the upper and lower score card options left to score
    * 
    */
    public void printScoreCard(int[] hand, ArrayList<String> upperLowerArr)
    {
        lower.printLowerScore(hand, upperLowerArr);
        upper.printUpperScore(hand, upperLowerArr);
    }




    // change this to arrlist

    /**
    * method scores the array list that is populated with the options 
    * 
    * @author	Louis Cerda
    *
    * @param scan scanner object to get input
    *
    * @param list int array of the dice rolled on each index
    *
    * @param hand arraylist of possible options left to score in the game 
    *
    */
    public void scoreInputChange(Scanner scan, ArrayList<String> list, int[] hand)
    {
        System.out.println("What line would you want to keep score of? ");
        boolean flag = true;
        do{    
            String inputScoreLine = scan.nextLine();
            if (list.contains(inputScoreLine) && returnArrayListScores(list, hand, inputScoreLine) != 0)
            {
                // list.remove(inputScoreLine);
                flag = false;
                int x = list.indexOf(inputScoreLine);
                this.totalScore += returnArrayListScores(list, hand, inputScoreLine);
                System.out.print(totalScore + " is your total score \n");
                list.set(x, "0");
            } else 
                System.out.println("Invalid input score. Try again. \n");
        } while(flag);
    }




    /**
    * method scores the array list that is populated with the options 
    * 
    * @author	Louis Cerda
    *
    * @param list int array of the dice rolled on each index
    *
    * @param hand arraylist of possible options left to score in the game 
    *
    * @param input string input that is what the option that the user wants to score 
    *
    * @return int score given on the option inputed
    */
    public int returnArrayListScores(ArrayList<String> list, int[] hand, String input)
    {   
        for (int dieVal = 1; dieVal <= dice+1; dieVal++)
        {
            String match = String.valueOf(dieVal);
            if (list.contains(match) && match.equals(input))
            {
                int currentCount = 0;
                for (int diePos = 0; diePos < dice; diePos++)
                {
                    if (hand[diePos] == dieVal)
                        currentCount++;
                }
                return dieVal*currentCount;
            }
        }



        if (list.contains("3K") && input.equals("3K"))
        {
            if (play.maxOfAKindFound(hand) >= 3)
                return die.totalAllDice(hand);
        }

        if (list.contains("4K") && input.equals("4K"))
        {
            if (play.maxOfAKindFound(hand) >= 4)
                return die.totalAllDice(hand);
        }

        if (list.contains("FH") && input.equals("FH"))
        {
            if (play.fullHouseFound(hand))
                return 25;
        }

        if (list.contains("SS") && input.equals("SS"))
        {
            if (play.maxStraightFound(hand) >= 4)
                return 30;
        }

        if (list.contains("LS") && input.equals("LS"))
        {
            if (play.maxStraightFound(hand) >= 5)
                return 40;
        }

        if (list.contains("YL") && input.equals("YL"))
        {
            if (play.maxOfAKindFound(hand) >= 5)
                return 50;
        }

        if (list.contains("C") && input.equals("C"))
            return die.totalAllDice(hand);
        

        return 0;
    }
    
}
