package cis.monopoly.gamePlay;

import java.util.Random;

/**
 * <h1>GameDice</h1>
 * This class is used for the logic of the dice. You can either
 * get the total of the roll or get the value of each individual
 * die. This logic is used for the DiceDrawer class and is
 * accounted for in moving the player.
 * @author Kyle Turske
 * @version 0.5
 */

public class GameDice {

    private static int DIE_MIN = 1;
    private static int DIE_MAX = 6;
    private int dieOne;
    private int dieTwo;

    /**
     * GameDice constructor. Sets both dice to one.
     */
    public void GameDice() {
        dieOne = DIE_MIN;
        dieTwo = DIE_MIN;
    }

    /**
     * Randomly picks an integer from one to six
     * @param die
     * @return roll
     */
    public int roll(int die) {
        Random rand = new Random();

        return rand.nextInt(DIE_MAX - DIE_MIN) + DIE_MIN;
    }

    /**
     * Calls the roll method twice for each die, and sets them equal
     * to a random integer from one to six.
     */
    public void rollTwo() {
        dieOne = roll(dieOne);
        dieTwo = roll(dieTwo);
    }

    /**
     * Checks to see if the dice are equal to each other. This is used
     * to see if the player can roll again for a second consecutive roll.
     * @return true The dice are equal
     * @return false The dice are not equal
     */
    public boolean doubleCheck() {
        if (dieOne == dieTwo) return true;
        else return false;
    }

    /**
     * Used for the DrawDie method
     * @return dieOne
     */
    public int getDieOne() {
        return dieOne;
    }

    /**
     * Used for the DrawDie method
     * @return dieTwo
     */
    public int getDieTwo() {
        return dieTwo;
    }

    /**
     * Adds together both of the die in order to do calculations dealing
     * with player moves.
     * @return dieOne + dieTwo
     */
    public int getTotalRoll() {
        return dieOne + dieTwo;
    }
}
