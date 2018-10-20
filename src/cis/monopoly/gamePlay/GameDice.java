package cis.monopoly.gamePlay;

import java.util.Random;

/**This class is used for the logic
 * of the dice.
 *
 */

public class GameDice {

    private static int DIE_MIN = 1;
    private static int DIE_MAX = 6;
    private int dieOne;
    private int dieTwo;

    public void GameDice() {
        dieOne = DIE_MIN;
        dieTwo = DIE_MIN;
    }

    public int roll(int die) {
        Random rand = new Random();

        return rand.nextInt(DIE_MAX - DIE_MIN) + DIE_MIN;
    }

    public void rollTwo() {
        dieOne = roll(dieOne);
        dieTwo = roll(dieTwo);
    }

    public boolean doubleCheck() {
        if (dieOne == dieTwo) return true;
        else return false;
    }

    public int getDieOne() {
        return dieOne;
    }

    public int getDieTwo() {
        return dieTwo;
    }

    public int getTotalRoll() {
        return dieOne + dieTwo;
    }
}
