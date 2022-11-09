// author: louis cerda
// file: Dice.java
// date: oct 19 2022
// class: CPSC224

import java.io.*;
import java.util.*;

public class Dice
{
    static int diceNums;
    private int turns;
    private int sides;


    Dice(){
    }


    /**
    * method that returns the random int for a score on the dice
    * 
    * @author	Louis Cerda
    *
    * @param sides is how many sides the given die has
    * 
    * @return int the roll score that can be equal to or less than the number of sides
    */
    public int rollDie(int sides)
    {
        Random randy = new Random();
        int roll = randy.nextInt(sides - 1 + 1) % sides + 1;
        return roll;
    }


    /**
    * method that returns the total from adding each index inside the hand arr
    * 
    * @author	Louis Cerda
    *
    * @param hand is the int array that displays the score value of each dice that was roll depending on how many are played
    * 
    * @return int the total of all the indexes added up
    */
    public int totalAllDice(int hand[])
    {
        int total = 0;
        for (int diePos = 0; diePos < diceNums; diePos++)
            total += hand[diePos];
        return total;

    }


    /**
    * method that gets the dice value up inside the Dice class
    * 
    * @author	Louis Cerda
    *
    * @return int the dice that are in play during the game 
    * 
    */
    public int getDice()
    {
        return Dice.diceNums;
    }


    /**
    * method that sets the dice value up inside the Dice class
    * 
    * @author	Louis Cerda
    *
    * @param nums is the int dice that are in play during the game 
    * 
    */
    public void setDice(int nums)
    {
        Dice.diceNums = nums;
    }


    /**
    * method that gets the sides value up inside the Dice class
    * 
    * @author	Louis Cerda
    *
    * @return int the sides that are in play during the game 
    * 
    */
    public int getSides()
    {
        return this.sides;
    }


    /**
    * method that sets the sides value up inside the Dice class
    * 
    * @author	Louis Cerda
    *
    * @param sides is the int sides that are in play during the game 
    * 
    */
    public void setSides(int sides)
    {
        this.sides = sides;
    }


    /**
    * method that gets the turn value up inside the Dice class
    * 
    * @author	Louis Cerda
    *
    * @return int the turns that are being used during the game 
    * 
    */
    public int getTurns()
    {
        return this.turns;
    }


    /**
    * method that sets the turns value up inside the Dice class
    * 
    * @author	Louis Cerda
    *
    * @param turns is the int turns that are in play during the game 
    * 
    */
    public void setTurns(int turns)
    {
        this.turns = turns;
    }


    /**
    * method sorts the array in ascending order
    * 
    * @author	Louis Cerda
    *
    * @param size how large the array being passed in is
    * @param array is an int array of the value roll being each index of however large the size param is
    * 
    */
    public void sortArray(int array[], int size)
    {
        boolean swap;
        int temp;

        do 
        {
            swap = false;
            for (int count = 0; count < (size - 1); count++)
            {
                if (array[count] > array[count + 1])
                {
                    temp = array[count];
                    array[count] = array[count + 1];
                    array[count + 1] = temp;
                    swap = true;
                }
            }
        } while (swap);
    }



    /**
    *method that reads from yahtzeeConfig.txt and uses the data inputs to create the game vars 
    * 
    * @author	Louis Cerda
    *
    * @param kl is a scanner object that allows the system.in option 
    *
    * @exception getStackTrace if the file does not open properly
    * 
    */
    public void readFromFile(Scanner kl)
    {

        // setting strings that will be used to read lines from
        String line1 = "";
        String line2 = "";
        String line3 = "";
        String line4;

        String sides = "";
        String dice = "";
        String rolls = "";

        // opening file and then doing the try catch
        File myFile = new File("yahtzeeConfig.txt");

        try
        {
            // scanning next line inside the file
            Scanner scan = new Scanner(myFile);
            line1 = scan.nextLine();
            line2 = scan.nextLine();
            line3 = scan.nextLine();
            scan.close();

            // reading out data from file 
            System.out.print("You are playing with " + line2 + " ");
            System.out.print(line1 + "-sided dice\n");
            System.out.print(line3 + " rolls per hand\n");


            // configing according to user
            System.out.println("Enter 'y' if you want to change the configuration");
            line4 = kl.nextLine();

            if (line4.equals("y"))
            {
                System.out.print("enter the number of sides on each die ");
                sides = kl.nextLine();

                System.out.print("enter the number of dice in play ");
                dice = kl.nextLine();

                System.out.print("enter the number of rolls per hand ");
                rolls = kl.nextLine();
            }
            else
            {
                dice = line2;
                sides = line1;
                rolls = line3;
            }


            // setting die values up inside the class accoridng to the file config
            // setting the dice and sides and rolls
            setDice(Integer.parseInt(dice));
            setTurns(Integer.parseInt(rolls));
            setSides(Integer.parseInt(sides));



            // printing to the config
            PrintWriter pw = new PrintWriter(myFile);
            pw.println(dice);
            pw.println(sides);
            pw.println(rolls);

            pw.close();


        }
        catch (Exception ex)
        {
            ex.getStackTrace();
        }
    }
}
