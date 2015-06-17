/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package craps;

import java.util.Random;

/**
 *
 * @author rkhatchadourian
 */
public class Craps {

    public static void displayResultMessage(String result) {
        System.out.println("You " + result + ".");
    }

    public static void displayDieMessage(int firstDie, int secondDie) {
        System.out.println("You rolled " + firstDie + " and " + secondDie + ". Good job!");
    }

    /**
     * Rolls a single die.
     * @param randomGenerator The random generator to use.
     * @param lowValue The lowest die value.
     * @param highValue The highest die value.
     * @return The result of the die.
     */
    public static int rollDie(Random randomGenerator, int lowValue, int highValue) {
        return randomGenerator.nextInt(highValue - lowValue) + 1;
    }

    /**
     * Rolls two dice.
     * @param randomGenerator The random generator to use.
     * @param lowValue The lowest die value.
     * @param highValue The highest die value.
     * @return The total of the two dice.
     */
    public static int rollDice(Random randomGenerator, int lowValue, int highValue) {
        //2. roll two die.
        int die1 = rollDie(randomGenerator, lowValue, highValue);
        int die2 = rollDie(randomGenerator, lowValue, highValue);

        displayDieMessage(die1, die2);

        //3. sum the total.
        return die1 + die2;
    }

    public static void main(String[] args) {
        final int DIE_LOW_VALUE = 1;
        final int DIE_HIGH_VALUE = 6;

        boolean done = false; //true if the game is over and false otherwise.
        Random random = new Random(); //the random generator.

        //1. while the game is not over.
        while (!done) {
            int total = rollDice(random, DIE_LOW_VALUE, DIE_HIGH_VALUE);

            //4. if the total is 2, 3, or 12.
            if (total == 2 || total == 3 || total == 12) {
                //the player loses.
                displayResultMessage("lose");
                done = true;
            } //5. else if the total is 7 or 11.
            else if (total == 7 || total == 11) {
                displayResultMessage("win");
                done = true;
            } //6. else, save the total as point.
            else {
                int point = total;

                //6a. roll two die.
                total = rollDice(random, DIE_LOW_VALUE, DIE_HIGH_VALUE);

                //6c. if the total is point.
                if (total == point) {
                    //the player wins.
                    displayResultMessage("win");
                    done = true;
                }
            }
        }
    }
}
