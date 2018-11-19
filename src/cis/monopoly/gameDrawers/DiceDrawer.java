package cis.monopoly.gameDrawers;

import cis.monopoly.guiElements.AlertBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**<h1>DiceDrawer</h1>
 * Draws the two dice on the window based off the roll of the Dice class
 * contained within the GameController class.
 * @author Kyle Turske
 * @version 0.6
 */
public final class DiceDrawer {
    
	/**Defines the diameter of the dice bowl.*/
    public static final int DICE_BOWL_DIAMETER = 250;

    /**Defines the height of the dice.*/
    public static final int DICE_HEIGHT = 50;

    /**Defines the diameter of the dot on the dice.*/
    public static final int DICE_DOT_DIAMETER = 10;

    /**Defines the top dot on the dice.*/
    public static final double DOT_TOP = 7.5;

    /**Defines the middle dot of the dice.*/
    public static final double DOT_MIDDLE = 20;

    /**Defines the bottom dot of the dice.*/
    public static final double DOT_BOTTOM = 32.5;
    
    /**
	 * Private constructor.
	 */
    private DiceDrawer() {
    	
    }
    
    /**
     * This method draws dice bowl including the gv_color and draws the dot.
     * @param gc The GraphicsContext that draws on the corresponding canvas.
     * @param xPos this is the horizontal position of the bowl.
     * @param yPos this is the vertical position of the bowl.
     */
    public static void drawDiceBowl(final GraphicsContext gc, final int xPos,
    		final int yPos) {
        gc.setFill(BoardDrawer.GV_BLUE);
        gc.fillOval(xPos,  yPos, 250, 250);
    }

    /**
     * This method draws the dice and also draws the the number of dots on each
     * die depending on their roll.
     * @param gc The object of type GraphicsContext that draws the canvas of
     *           the dice.
     * @param xPos this is the horizontal position of the of the die.
     * @param yPos this is the vertical position of the of the die.
     * @param roll This is represents the number of dots on the die.
     */
    public static void drawDie(final GraphicsContext gc, final int xPos,
    		final int yPos, final int roll) {
        gc.setFill(Color.FLORALWHITE);
        gc.fillRect(xPos, yPos, 50, 50);
        gc.setFill(Color.BLACK);
        gc.strokeRect(xPos, yPos, 50, 50);
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
            AlertBox.display("Dice Roll Error",
            		"Somehow you rolled outside the range of the die!");
        }

    }
    /**
     * This method draws only one dot for a die.
     * @param gc The GraphicsContext that draws on the corresponding canvas.
     * @param xPos this is the horizontal position of the bowl.
     * @param yPos this is the vertical position of the bowl.
     */

    public static void drawDotsOne(final GraphicsContext gc, final int xPos,
    		final int yPos) {
        gc.fillOval(xPos + 20, yPos + 20, 10, 10);
    }

    /**
     * This method draws two dots on the die.
     * @param gc The GraphicsContext that draws on the corresponding canvas.
     * @param xPos this is the horizontal position of the bowl.
     * @param yPos this is the vertical position of the bowl.
     */
    public static void drawDotsTwo(final GraphicsContext gc,
    		final int xPos, final int yPos) {
        gc.fillOval(xPos + 7.5, yPos + 7.5, 10, 10);
        gc.fillOval(xPos + 32.5, yPos + 32.5, 10, 10);
    }

    /**
     * This method draws three dots on the die.
     * @param gc The GraphicsContext that draws on the corresponding canvas.
     * @param xPos this is the horizontal position of the bowl.
     * @param yPos this is the vertical position of the bowl.
     */
    public static void drawDotsThree(final GraphicsContext gc, final  int xPos,
    		final int yPos) {
        gc.fillOval(xPos + 7.5, yPos + 32.5, 10, 10);
        gc.fillOval(xPos + 20, yPos + 20, 10, 10);
        gc.fillOval(xPos + 32.5, yPos + 7.5, 10, 10);
    }


    /**
     * This method draws the fourth dot on the die.
     * @param gc The GraphicsContext that draws on the corresponding canvas.
     * @param xPos this is the horizontal position of the bowl.
     * @param yPos this is the vertical position of the bowl.
     */
    public static void drawDotsFour(final GraphicsContext gc, final int xPos,
    		final int yPos) {
        gc.fillOval(xPos + 7.5, yPos + 7.5, 10, 10);
        gc.fillOval(xPos + 7.5, yPos + 32.5, 10, 10);
        gc.fillOval(xPos + 32.5, yPos + 7.5, 10, 10);
        gc.fillOval(xPos + 32.5, yPos + 32.5, 10, 10);
    }

    /**
     * This method draws five dots on the die.
     * @param gc The GraphicsContext that draws on the corresponding canvas.
     * @param xPos this is the horizontal position of the bowl.
     * @param yPos this is the vertical position of the bowl.
     */
    public static void drawDotsFive(final GraphicsContext gc, final int xPos,
    		final int yPos) {
        gc.fillOval(xPos + 7.5, yPos + 7.5, 10, 10);
        gc.fillOval(xPos + 7.5, yPos + 32.5, 10, 10);
        gc.fillOval(xPos + 20, yPos + 20, 10, 10);
        gc.fillOval(xPos + 32.5, yPos + 7.5, 10, 10);
        gc.fillOval(xPos + 32.5, yPos + 32.5, 10, 10);
    }

    /**
     * This method draws six dots on the die.
     * @param gc The GraphicsContext that draws on the corresponding canvas.
     * @param xPos this is the horizontal position of the bowl.
     * @param yPos this is the vertical position of the bowl.
     */
    public static void drawDotsSix(final GraphicsContext gc, final int xPos,
    		final int yPos) {
        gc.fillOval(xPos + 7.5, yPos + 7.5, 10, 10);
        gc.fillOval(xPos + 7.5, yPos + 32.5, 10, 10);
        gc.fillOval(xPos + 7.5, yPos + 20, 10, 10);
        gc.fillOval(xPos + 32.5, yPos + 20, 10, 10);
        gc.fillOval(xPos + 32.5, yPos + 7.5, 10, 10);
        gc.fillOval(xPos + 32.5, yPos + 32.5, 10, 10);
    }
}
