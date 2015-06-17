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

    public static void main(String[] args) {
        final int DIE_LOW_VALUE = 1;
        final int DIE_HIGH_VALUE = 6;

        boolean done = false; //true if the game is over and false otherwise.
        Random random = new Random(); //the random generator.

        //1. while the game is not over.
        while (!done) {
            //2. roll two die.
//            int die1 = random.nextInt(DIE_HIGH_VALUE - DIE_LOW_VALUE) + 1;
            int die1 = random.ints(1, DIE_LOW_VALUE, DIE_HIGH_VALUE + 1).findFirst().getAsInt();
            int die2 = random.ints(1, DIE_LOW_VALUE, DIE_HIGH_VALUE + 1).findFirst().getAsInt();

            System.out.println("You rolled " + die1 + " and " + die2 + ".");

            //3. sum the total.
            int total = die1 + die2;

            //4. if the total is 2, 3, or 12.
            if (total == 2 || total == 3 || total == 12) {
                //the player loses.
                System.out.println("You lose.");
                done = true;
            } //5. else if the total is 7 or 11.
            else if (total == 7 || total == 11) {
                System.out.println("You win.");
                done = true;
            } //6. else, save the total as point.
            else {
                int point = total;

                //6a. roll two die.
                die1 = random.ints(1, DIE_LOW_VALUE, DIE_HIGH_VALUE + 1).findFirst().getAsInt();
                die2 = random.ints(1, DIE_LOW_VALUE, DIE_HIGH_VALUE + 1).findFirst().getAsInt();

                System.out.println("You rolled " + die1 + " and " + die2 + ".");

                //6b. sum the total.
                total = die1 + die2;

                //6c. if the total is point.
                if (total == point) {
                    //the player wins.
                    System.out.println("You win.");
                    done = true;
                }
            }
        }
    }
}
