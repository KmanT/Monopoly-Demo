package cis.monopoly.gameDrawers;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**<h1>BoardDrawer</h1>
 * This class draws all the elements on the board including the board itslef
 * and the players on the board.
 * @author Kyle Turske
 * @version 0.5
 */
public final class BoardDrawer {

    //BOARD VALUES//
	/**
	 * The length of the board if the screen is big. Also used for the
	 * height since that the board is square.
	 */
    public static final int BOARD_LENGTH_BIG = 814;
    
    /**
	 * The length of the board if the screen is small. Also used for the
	 * height since that the board is square.
	 *  is square.
	 */
    public static final int BOARD_LENGTH_SMALL = 412;
    
    /**
     * The height of the properties if they are on the top or bottom row of the
     * board if the screen size is big. Also used to define the width of the
     * spaces that are on the left and right side of the board.
     */
    public static final int PROPERTY_HEIGHT_BIG = 110;
    
    /**
     * The height of the properties if they are on the top or bottom row of the
     * board if the screen size is small. Also used to define the width of the
     * spaces that are on the left and right side of the board.
     */
    public static final int PROPERTY_HEIGHT_SMALL = 55;
    
    /**
     * The width of the properties if they are on the top or bottom row of the
     * board. Also used to define the height of the spaces that are on the left
     * and right side of the board. Bigger variation.
     */
    public static final int PROPERTY_WIDTH_BIG = 66;
    
    /**
     * The width of the properties if they are on the top or bottom row of the
     * board. Also used to define the height of the spaces that are on the left
     * and right side of the board. Smaller variation.
     */
    public static final int PROPERTY_WIDTH_SMALL = 33;
    
    /**
     * Each property has a part of the their space that shows their
     * corresponding color. This will be draw on the inner part of the space. So
     * if the space is is on the side, then this value defines the height of
     * flag. Bigger variation
     */
    public static final int PROPERTY_FLAG_HEIGHT_BIG = 30;
    
    /**
     * Each property has a part of the their space that shows their
     * corresponding color. This will be draw on the inner part of the space. So
     * if the space is is on the side, then this value defines the height of
     * flag. Smaller variation
     */
    public static final int PROPERTY_FLAH_HEIGHT_SMALL = 30;

    /**
     * This defines the height and width of each player piece, as each piece is
     * a square. Bigger variation.
     */
    public static final int PIECE_WIDTH_BIG = 32;
    
    /**
     * This defines the height and width of each player piece, as each piece is
     * a square. Smaller variation.
     */
    public static final int PIECE_WIDTH_SMALL = 16;
    
    /**
     * If you go to Grand Valley State University's web site, you can see that
     * this hex value defines the color for "Grand Valley Blue." Used for the
     * lettering, buttons, the dice drawer, and the center of the board as
     * well. 
     */
    public static final Color GV_BLUE = Color.web("#0065a4");
    
    /**
     * Private constructor.
     */
    private BoardDrawer() {
    	
    }
    
    /**
     * Draws all of the properties on the top of the board.
     * @param gc This parameter accepts the Graphics context of a canvas in
     * which will draw the property on the top of the board.
     * @param xpos This defines the horizontal position of the property.
     * @param ypos This defines the vertical position of the property.
     * @param color This defines the color of the flag.
     * 
     */
    public static void drawPropertyTop(final GraphicsContext gc, final int xpos,
    		final int ypos, final Color color) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos, ypos, PROPERTY_WIDTH_BIG, PROPERTY_HEIGHT_BIG);

        gc.setFill(color);
        gc.fillRect(xpos, ypos + 80, PROPERTY_WIDTH_BIG,
        		PROPERTY_FLAG_HEIGHT_BIG);
        gc.strokeRect(xpos, ypos, PROPERTY_WIDTH_BIG, PROPERTY_HEIGHT_BIG);

    }
    
    /**
     * Draws all of the properties on the bottom row of the board.
     * @param gc This parameter accepts the Graphics context of a canvas in
     * which will draw the property on the top of the board.
     * @param xpos This defines the horizontal position of the property.
     * @param ypos This defines the vertical position of the property.
     * @param color This defines the color of the flag.
     * 
     */
    public static void drawPropertyBottom(final GraphicsContext gc,
    		final int xpos, final int ypos, final  Color color) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos, ypos, PROPERTY_WIDTH_BIG, PROPERTY_HEIGHT_BIG);

        gc.setFill(color);
        gc.fillRect(xpos, ypos, PROPERTY_WIDTH_BIG, PROPERTY_FLAG_HEIGHT_BIG);
        gc.strokeRect(xpos, ypos, PROPERTY_WIDTH_BIG, PROPERTY_HEIGHT_BIG);

    }
    
    /**
     * 
     * Draws all of the properties on the left side of the board.
     * @param gc This parameter accepts the Graphics context of a canvas in
     * which will draw the property on the top of the board.
     * @param xpos This defines the horizontal position of the property.
     * @param ypos This defines the vertical position of the property.
     * @param color This defines the color of the flag.
     */
    public static void drawPropertyLeft(final GraphicsContext gc,
    		final int xpos,	final int ypos,	final Color color) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos, ypos, PROPERTY_HEIGHT_BIG, PROPERTY_WIDTH_BIG);

        gc.setFill(color);
        gc.fillRect(xpos + 80, ypos,
        		PROPERTY_FLAG_HEIGHT_BIG, PROPERTY_WIDTH_BIG);
        gc.strokeRect(xpos, ypos, PROPERTY_HEIGHT_BIG, PROPERTY_WIDTH_BIG);

    }
    
    /**
     * Draws all of the properties on the right side of the board.
     * @param gc This parameter accepts the Graphics context of a canvas in
     * which will draw the property on the top of the board.
     * @param xpos This defines the horizontal position of the property.
     * @param ypos This defines the vertical position of the property.
     * @param color This defines the color of the flag.
     * @param name This defines the name of the property, all though this
     * parameter might be removed all together.
     */
    public static void drawPropertyRight(final GraphicsContext gc, 
    		final int xpos, final int ypos, final Color color,
    		final String name) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos, ypos, PROPERTY_HEIGHT_BIG, PROPERTY_WIDTH_BIG);

        gc.setFill(color);
        gc.fillRect(xpos, ypos, PROPERTY_FLAG_HEIGHT_BIG, PROPERTY_WIDTH_BIG);
        gc.strokeRect(xpos, ypos, PROPERTY_HEIGHT_BIG, PROPERTY_WIDTH_BIG);
        gc.strokeText(name, xpos, ypos + 15);
    }
    
    /**
     * Used to draw all of the corners on the board.
     * @param gc This parameter accepts the Graphics context of a canvas in
     * which will draw the property on the top of the board.
     * @param xpos This defines the horizontal position of the property.
     * @param ypos This defines the vertical position of the property.
     * @param color This defines the color of the flag.
     * @param name This defines the name of the property, all though this
     * parameter might be removed all together.
     */
    public static void drawCorner(final GraphicsContext gc, final double xpos,
    		final double ypos, final Color color, final String name) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos, ypos, PROPERTY_HEIGHT_BIG, PROPERTY_HEIGHT_BIG);
        gc.strokeRect(xpos, ypos, PROPERTY_HEIGHT_BIG, PROPERTY_HEIGHT_BIG);
    }
    
    /**
     * Takes all of the different "drawProperty" methods and loops through an
     * array of all the different colors of the board (36) colors in total, and
     * draws all of the properties starting at pos[1]. Pos[0] would be the
     * bottom right corner. From positions 1-9, the method drawPropertyBottom is
     * called. From positions 11-19, the method drawPropertyLeft is called. From
     * positions 21-29 the method drawPropertTop is called. Finally after that,
     * from the positions 31-39, the method drawProperty right is called. After
     * all of the regular properties are drawn, next all of the corners are
     * drawn in their respective position.
     * @param gc This parameter accepts the Graphics context of a canvas in
     * which will draw the property on the top of the board. The last thing
     * this method does is draw all four pieces on the board. Will eventually
     * add a parameter that accepts the number of players that are currently
     * playing
     */
    public static void drawBoard(final GraphicsContext gc) {
        Color[] colors = {Color.SIENNA, Color.FLORALWHITE,
                Color.SIENNA, Color.FLORALWHITE, Color.BLACK,
                Color.POWDERBLUE, Color.FLORALWHITE, Color.POWDERBLUE,
                Color.POWDERBLUE, Color.ORCHID, Color.GRAY,
                Color.ORCHID, Color.ORCHID, Color.BLACK,
                Color.ORANGE, Color.FLORALWHITE, Color.ORANGE,
                Color.ORANGE, Color.RED, Color.FLORALWHITE,
                Color.RED, Color.RED, Color.BLACK,
                Color.YELLOW, Color.YELLOW, Color.GRAY,
                Color.YELLOW, Color.MEDIUMSPRINGGREEN, Color.MEDIUMSPRINGGREEN,
                Color.FLORALWHITE, Color.MEDIUMSPRINGGREEN, Color.BLACK,
                Color.FLORALWHITE, Color.DODGERBLUE, Color.FLORALWHITE,
                Color.DODGERBLUE}; //new Color[36];

        gc.setFill(GV_BLUE);
        gc.fillRect(0, 0, 814, 814);

        int colorCounter = 0;
        int xPos = 638;
        int yPos = 704;
        for (int i = 0; i <= 8; i++) {
            drawPropertyBottom(gc, xPos, yPos, colors[colorCounter]);
            xPos -= 66;
            colorCounter++;
        }

        xPos = 0;
        yPos = 638;
        for (int i = 0; i <= 8; i++) {
            drawPropertyLeft(gc, xPos, yPos, colors[colorCounter]);
            yPos -= 66;
            colorCounter++;
        }

        xPos = 110;
        yPos = 0;
        for (int i = 0; i <= 8; i++) {
            drawPropertyTop(gc, xPos, yPos, colors[colorCounter]);
            xPos += 66;
            colorCounter++;
        }

        xPos = 704;
        yPos = 110;
        for (int i = 0; i <= 8; i++) {
            drawPropertyRight(gc, xPos, yPos, colors[colorCounter], "");
            yPos += 66;
            colorCounter++;
        }

        drawCorner(gc, 0, 0, Color.FLORALWHITE, "");
        drawCorner(gc, 704, 0, Color.FLORALWHITE, "");
        drawCorner(gc, 0, 704, Color.FLORALWHITE, "");
        drawCorner(gc, 704, 704, Color.FLORALWHITE, "");

        for (int i = 0; i <= 3; i++) {
        	PieceDrawer.movePiece(gc, i + 1, 0, i + 1);
        }
           
    }
    
}
