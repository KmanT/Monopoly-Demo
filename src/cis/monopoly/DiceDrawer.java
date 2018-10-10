package cis.monopoly;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DiceDrawer {

    public static final int DICE_BOWL_DIAMETER = 250;
    public static final int DICE_HEIGHT = 100;


    public static void drawDice(GraphicsContext gc, int xPos, int yPos, int roll) {
        gc.setFill(Color.FLORALWHITE);
        gc.fillRect(xPos, yPos, DICE_HEIGHT, DICE_HEIGHT);

        gc.setFill(Color.BLACK);

        if (roll == 1) {

        } else if (roll == 2) {

        } else if (roll == 3) {

        } else if (roll == 4) {

        } else if (roll == 5) {

        } else if (roll == 6) {

        } else {
            AlertBox.display("Dice Roll Error", "Somehow you rolled outside the range of the die!");
        }

    }
}
