// author: louis cerda
// file: PlayCard.java
// date: oct 09 2022
// class: CPSC224

public class PlayCard 
{
    int dice;
   
    PlayCard(int dice)
    {
        this.dice = dice;
    }


    /**
    * method that returns the score on max amount of how many of a kind there are
    * 
    * @author	Louis Cerda
    *
    * @param hand is the int array that displays the score value of each dice that was roll depending on how many are played
    * 
    * @return int the score that is given using the hand arr to calc and the yahtzee rules
    */
    public int maxOfAKindFound(int hand[])
    {
        int maxCount = 0;
        int currentCount;

        for (int dieVal = 1; dieVal <= dice+1; dieVal++)
        {
            currentCount = 0;
            for(int diePos = 0; diePos < dice; diePos++)
            {
                if (hand[diePos] == dieVal)
                    currentCount++;
            }
            if (currentCount > maxCount)
                maxCount = currentCount;
        }
        return maxCount;
    }




    

    /**
    * method that returns the score on max amount of straight found
    * 
    * @author	Louis Cerda
    *
    * @param hand is the int array that displays the score value of each dice that was roll depending on how many are played
    * 
    * @return int the score that is given using the hand arr to calc and the yahtzee rules
    */
    public int maxStraightFound(int hand[])
    {
        int maxLen = 1;
        int curLen = 1;
        
        for (int counter = 0; counter < dice-1; counter++)
        {
            if (hand[counter] + 1 == hand[counter + 1])
                curLen++;
            else if (hand[counter] + 1 < hand[counter + 1])
                curLen = 1;
            if (curLen > maxLen)
                maxLen = curLen;
        }
        return maxLen;
    }





    /**
    * method that returns true or false depending on if full house was found and then uses that to calc score
    * 
    * @author	Louis Cerda
    *
    * @param hand is the int array that displays the score value of each dice that was roll depending on how many are played
    * 
    * @return boolean true or false on whether a full house has been found within the hand
    */
    public boolean fullHouseFound(int hand[])
    {
        boolean foundFH = false;
        boolean found3K = false;
        boolean found2K = false;
        int currentCount;


        for (int dieVal = 1; dieVal <= dice+1; dieVal++)
        {
            currentCount = 0;
            for (int diePos = 0; diePos < dice; diePos++)
            {
                if (hand[diePos] == dieVal)
                    currentCount++;
            }
            if (currentCount == 2)
                found2K = true;
            if (currentCount == 3)
                found3K = true;
        }
        if (found2K && found3K)
            return true;
        return foundFH;
    }
}
