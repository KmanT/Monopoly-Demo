package cis.monopoly.gameDrawers;

import cis.monopoly.guiElements.AlertBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DiceDrawer {
    /**Defines the diameter of the dice bowl.*/
    public static final int DICE_BOWL_DIAMETER = 250;

    /**Defines the height of the dice.*/
    public static final int DICE_HEIGHT = 50;

    /**Defines the diameter of the dot on the dice.*/
    public static final int DICE_DOT_DIAMETER = 10;

    /**Defines the top dot on the dice.*/
    public static final double DOT_TOP = 7.5D;

    /**Defines the middle dot of the dice.*/
    public static final double DOT_MIDDLE = 20.0D;

    /**Defines the bottom dot of the dice.*/
    public static final double DOT_BOTTOM = 32.5D;

    public DiceDrawer() {
    }

    /**
     * This method draws dice bowl including the gv_color and draws the dot
     * @param gc The object of type GraphicsContext that draws the canvas of
     *           the dice.
     * @param xpos this is the x position of the dice that makes a dot.
     * @param ypos this is the y position of the dice that makes a dot.
     * @param color this is the color of the canvas of the dice, which in this
     *              case is GV_blue
     */
    public static void drawDiceBowl(GraphicsContext gc, int xPos, int yPos) {
        gc.setFill(BoardDrawer.GV_BLUE);
        gc.fillOval((double)xPos, (double)yPos, 250.0D, 250.0D);
    }

    /**
     * This method draws dice and includes takes in total of the roll
     * @param gc The object of type GraphicsContext that draws the canvas of
     *           the dice.
     * @param xpos this is the x position of the size of the die.
     * @param ypos this is the y position of the size of the die.
     * @param roll This is represents the number of dots on the die.
     */
    public static void drawDie(GraphicsContext gc, int xPos, int yPos, int roll) {
        gc.setFill(Color.FLORALWHITE);
        gc.fillRect((double)xPos, (double)yPos, 50.0D, 50.0D);
        gc.setFill(Color.BLACK);
        gc.strokeRect((double)xPos, (double)yPos, 50.0D, 50.0D);
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
    /**
     * This method draws the first dot on the die
     * @param gc The object of type GraphicsContext that draws the canvas on
     *           the dice.
     * @param xpos this is the x position of the dot on the die
     * @param ypos this is the y position of the dot on the die
     */

    public static void drawDotsOne(GraphicsContext gc, int xPos, int yPos) {
        gc.fillOval((double)xPos + 20.0D, (double)yPos + 20.0D, 10.0D, 10.0D);
    }

    /**
     * This method draws the second dot on the die
     * @param gc The object of type GraphicsContext that draws the canvas on
     *           the dice.
     * @param xpos this is the x position of the dot on the die
     * @param ypos this is the y position of the dot on the die
     */
    public static void drawDotsTwo(GraphicsContext gc, int xPos, int yPos) {
        gc.fillOval((double)xPos + 7.5D, (double)yPos + 7.5D, 10.0D, 10.0D);
        gc.fillOval((double)xPos + 32.5D, (double)yPos + 32.5D, 10.0D, 10.0D);
    }

    /**
     * This method draws the Third dot on the die
     * @param gc The object of type GraphicsContext that draws the canvas on
     *           the dice.
     * @param xpos this is the x position of the dot on the die
     * @param ypos this is the y position of the dot on the die
     */
    public static void drawDotsThree(GraphicsContext gc, int xPos, int yPos) {
        gc.fillOval((double)xPos + 7.5D, (double)yPos + 32.5D, 10.0D, 10.0D);
        gc.fillOval((double)xPos + 20.0D, (double)yPos + 20.0D, 10.0D, 10.0D);
        gc.fillOval((double)xPos + 32.5D, (double)yPos + 7.5D, 10.0D, 10.0D);
    }


    /**
     * This method draws the fourth dot on the die
     * @param gc The object of type GraphicsContext that draws the canvas on
     *           the dice.
     * @param xpos this is the x position of the dot on the die
     * @param ypos this is the y position of the dot on the die
     */
    public static void drawDotsFour(GraphicsContext gc, int xPos, int yPos) {
        gc.fillOval((double)xPos + 7.5D, (double)yPos + 7.5D, 10.0D, 10.0D);
        gc.fillOval((double)xPos + 7.5D, (double)yPos + 32.5D, 10.0D, 10.0D);
        gc.fillOval((double)xPos + 32.5D, (double)yPos + 7.5D, 10.0D, 10.0D);
        gc.fillOval((double)xPos + 32.5D, (double)yPos + 32.5D, 10.0D, 10.0D);
    }

    /**
     * This method draws the fifth dot on the die
     * @param gc The object of type GraphicsContext that draws the canvas on
     *           the dice.
     * @param xpos this is the x position of the dot on the die
     * @param ypos this is the y position of the dot on the die
     */
    public static void drawDotsFive(GraphicsContext gc, int xPos, int yPos) {
        gc.fillOval((double)xPos + 7.5D, (double)yPos + 7.5D, 10.0D, 10.0D);
        gc.fillOval((double)xPos + 7.5D, (double)yPos + 32.5D, 10.0D, 10.0D);
        gc.fillOval((double)xPos + 20.0D, (double)yPos + 20.0D, 10.0D, 10.0D);
        gc.fillOval((double)xPos + 32.5D, (double)yPos + 7.5D, 10.0D, 10.0D);
        gc.fillOval((double)xPos + 32.5D, (double)yPos + 32.5D, 10.0D, 10.0D);
    }

    /**
     * This method draws the sixth dot on the die
     * @param gc The object of type GraphicsContext that draws the canvas on
     *           the dice.
     * @param xpos this is the x position of the dot on the die
     * @param ypos this is the y position of the dot on the die
     */
    public static void drawDotsSix(GraphicsContext gc, int xPos, int yPos) {
        gc.fillOval((double)xPos + 7.5D, (double)yPos + 7.5D, 10.0D, 10.0D);
        gc.fillOval((double)xPos + 7.5D, (double)yPos + 32.5D, 10.0D, 10.0D);
        gc.fillOval((double)xPos + 7.5D, (double)yPos + 20.0D, 10.0D, 10.0D);
        gc.fillOval((double)xPos + 32.5D, (double)yPos + 20.0D, 10.0D, 10.0D);
        gc.fillOval((double)xPos + 32.5D, (double)yPos + 7.5D, 10.0D, 10.0D);
        gc.fillOval((double)xPos + 32.5D, (double)yPos + 32.5D, 10.0D, 10.0D);
    }
}
