package cis.monopoly;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DiceDrawer {

    public static final int DICE_BOWL_DIAMETER = 250;
    public static final int DICE_HEIGHT = 100;
    public static final int DICE_DOT_DIAMETER = 10;

    public static void drawDiceBowl(GraphicsContext gc, int xPos, int yPos) {
        gc.setFill(BoardDrawer.GV_BLUE);
        gc.fillOval(xPos, yPos, DICE_BOWL_DIAMETER, DICE_BOWL_DIAMETER);
    }


    public static void drawDie(GraphicsContext gc, int xPos, int yPos, int roll) {
        gc.setFill(Color.FLORALWHITE);
        gc.fillRect(xPos, yPos, DICE_HEIGHT, DICE_HEIGHT);

        gc.setFill(Color.BLACK);

        if (roll == 1) {

            gc.fillOval(xPos + 50, yPos + 50, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);

        } else if (roll == 2) {

            gc.fillOval(xPos + 25, yPos + 25, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
            gc.fillOval(xPos + 75, yPos + 75, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);

        } else if (roll == 3) {

            gc.fillOval(xPos + 25, yPos + 75, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
            gc.fillOval(xPos + 50, yPos + 50, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
            gc.fillOval(xPos + 75, yPos + 25, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);

        } else if (roll == 4) {

            gc.fillOval(xPos + 25, yPos + 25, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
            gc.fillOval(xPos + 25, yPos + 75, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
            gc.fillOval(xPos + 75, yPos + 75, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
            gc.fillOval(xPos + 75, yPos + 25, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);

        } else if (roll == 5) {

            gc.fillOval(xPos + 25, yPos + 25, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
            gc.fillOval(xPos + 25, yPos + 75, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
            gc.fillOval(xPos + 50, yPos + 50, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
            gc.fillOval(xPos + 75, yPos + 75, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
            gc.fillOval(xPos + 75, yPos + 25, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);

        } else if (roll == 6) {

            gc.fillOval(xPos + 25, yPos + 25, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
            gc.fillOval(xPos + 25, yPos + 75, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
            gc.fillOval(xPos + 50, yPos + 25, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
            gc.fillOval(xPos + 50, yPos + 75, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
            gc.fillOval(xPos + 75, yPos + 75, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
            gc.fillOval(xPos + 75, yPos + 25, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);

        } else {
            AlertBox.display("Dice Roll Error", "Somehow you rolled outside the range of the die!");
        }

    }
}
