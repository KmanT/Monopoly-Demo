package cis.monopoly.gameDrawers;

import cis.monopoly.guiElements.AlertBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DiceDrawer {

    public static final int DICE_BOWL_DIAMETER = 250;
    public static final int DICE_HEIGHT = 50;
    public static final int DICE_DOT_DIAMETER = 10;
    public static final double DOT_TOP = 7.5;
    public static final double DOT_MIDDLE = 20;
    public static final double DOT_BOTTOM = 32.5;

    public static void drawDiceBowl(GraphicsContext gc, int xPos, int yPos) {
        gc.setFill(BoardDrawer.GV_BLUE);
        gc.fillOval(xPos, yPos, DICE_BOWL_DIAMETER, DICE_BOWL_DIAMETER);
    }


    public static void drawDie(GraphicsContext gc, int xPos, int yPos, int roll) {
        gc.setFill(Color.FLORALWHITE);
        gc.fillRect(xPos, yPos, DICE_HEIGHT, DICE_HEIGHT);

        gc.setFill(Color.BLACK);
        gc.strokeRect(xPos, yPos, DICE_HEIGHT, DICE_HEIGHT);

        if (roll == 1) {
            drawDotsOne(gc, xPos, yPos);
        } else if (roll == 2) {
            drawDotsTwo(gc, xPos, yPos);
        } else if (roll == 3) {
            drawDotsThree(gc, xPos, yPos);
        } else if (roll == 4) {
            drawDotsFour(gc, xPos, yPos);
        } else if (roll == 5) {
            drawDotsFive(gc, xPos, yPos);
        } else if (roll == 6) {
            drawDotsSix(gc, xPos, yPos);
        } else {
            AlertBox.display("Dice Roll Error", "Somehow you rolled outside the range of the die!");
        }

    }

    public static void drawDotsOne(GraphicsContext gc, int xPos, int yPos) {
        gc.fillOval(xPos + DOT_MIDDLE, yPos + DOT_MIDDLE, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
    }

    public static void drawDotsTwo(GraphicsContext gc, int xPos, int yPos) {
        gc.fillOval(xPos + DOT_TOP, yPos + DOT_TOP, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
        gc.fillOval(xPos + DOT_BOTTOM, yPos + DOT_BOTTOM, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
    }

    public static void drawDotsThree(GraphicsContext gc, int xPos, int yPos) {
        gc.fillOval(xPos + DOT_TOP, yPos + DOT_BOTTOM, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
        gc.fillOval(xPos + DOT_MIDDLE, yPos + DOT_MIDDLE, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
        gc.fillOval(xPos + DOT_BOTTOM, yPos + DOT_TOP, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
    }

    public static void drawDotsFour(GraphicsContext gc, int xPos, int yPos) {
        gc.fillOval(xPos + DOT_TOP, yPos + DOT_TOP, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
        gc.fillOval(xPos + DOT_TOP, yPos + DOT_BOTTOM, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
        gc.fillOval(xPos + DOT_BOTTOM, yPos + DOT_TOP, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
        gc.fillOval(xPos + DOT_BOTTOM, yPos + DOT_BOTTOM, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
    }

    public static void drawDotsFive(GraphicsContext gc, int xPos, int yPos) {
        gc.fillOval(xPos + DOT_TOP, yPos + DOT_TOP, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
        gc.fillOval(xPos + DOT_TOP, yPos + DOT_BOTTOM, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
        gc.fillOval(xPos + DOT_MIDDLE, yPos + DOT_MIDDLE, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
        gc.fillOval(xPos + DOT_BOTTOM, yPos + DOT_TOP, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
        gc.fillOval(xPos + DOT_BOTTOM, yPos + DOT_BOTTOM, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);

    }

    public static void drawDotsSix(GraphicsContext gc, int xPos, int yPos) {
        gc.fillOval(xPos + DOT_TOP, yPos + DOT_TOP, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
        gc.fillOval(xPos + DOT_TOP, yPos + DOT_BOTTOM, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
        gc.fillOval(xPos + DOT_TOP, yPos + DOT_MIDDLE, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
        gc.fillOval(xPos + DOT_BOTTOM, yPos + DOT_MIDDLE, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
        gc.fillOval(xPos + DOT_BOTTOM, yPos + DOT_TOP, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
        gc.fillOval(xPos + DOT_BOTTOM, yPos + DOT_BOTTOM, DICE_DOT_DIAMETER, DICE_DOT_DIAMETER);
    }
}
