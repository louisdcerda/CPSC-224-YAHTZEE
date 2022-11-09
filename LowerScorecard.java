import java.util.*;
public class LowerScorecard {


    int dice = Dice.diceNums;

    LowerScorecard(){
    }
    
    PlayCard play = new PlayCard(dice);

    Dice die = new Dice();






    /**
    * method that prints the lower scores of yahtzee 
    * 
    * @author	Louis Cerda
    *
    * @param hand the arry of ints filled with dice roll
    * 
    * @param list arraylist of string that has all the possible scoring values
    *
    */
    public void printLowerScore(int[] hand, ArrayList<String> list)
    {
        for (int dieVal = 1; dieVal <= dice+1; dieVal++)
        {
            String match = String.valueOf(dieVal);
            if (list.contains(match))
            {
                int currentCount = 0;
                for (int diePos = 0; diePos < dice; diePos++)
                {
                    if (hand[diePos] == dieVal)
                        currentCount++;
                }
                System.out.print(dieVal + " line : " + dieVal*currentCount + "\n");
            }
        }
    }

    /**
    * method that returns the random int for a score on the dice
    * 
    * @author	Louis Cerda
    *
    * @param list is the inital empty arrayList
    * 
    * @return ArrayList the initail array list populated with the lower score card and upper score card depending on dice nums
    */
    public ArrayList<String> changeInitialArr(ArrayList<String> list)
    {
        for (int i = 1; i <= Dice.diceNums; i++) 
        {
            String x  = String.valueOf(i);
            list.add(x);
        }
        String[] upperArr = {"3K", "4K", "FH", "SS", "LS", "YL", "C"};
        for (String name : upperArr)
        list.add(name);
        return list;
    }
}
