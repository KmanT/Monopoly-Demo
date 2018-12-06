package cis.monopoly.gameDrawers;

import java.io.FileInputStream;

import cis.monopoly.Main;
import cis.monopoly.guiElements.AlertBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

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
     */
    public static void drawPropertyRight(final GraphicsContext gc, 
    		final int xpos, final int ypos, final Color color) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos, ypos, PROPERTY_HEIGHT_BIG, PROPERTY_WIDTH_BIG);

        gc.setFill(color);
        gc.fillRect(xpos, ypos, PROPERTY_FLAG_HEIGHT_BIG, PROPERTY_WIDTH_BIG);
        gc.strokeRect(xpos, ypos, PROPERTY_HEIGHT_BIG, PROPERTY_WIDTH_BIG);
        
    }
    
    /**
     * Used to draw all of the corners on the board.
     * @param gc This parameter accepts the Graphics context of a canvas in
     * which will draw the property on the top of the board.
     * @param xpos This defines the horizontal position of the property.
     * @param ypos This defines the vertical position of the property.
     * @param color This defines the color of the flag.
     * @param cornerID Defines which corner is being drawn
     */
    public static void drawCorner(final GraphicsContext gc, final double xpos,
    		final double ypos, final Color color, final int cornerID) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos, ypos, PROPERTY_HEIGHT_BIG, PROPERTY_HEIGHT_BIG);
        gc.strokeRect(xpos, ypos, PROPERTY_HEIGHT_BIG, PROPERTY_HEIGHT_BIG);
        
        switch (cornerID) {
	        case 1: gc.setFill(GV_BLUE);
	        	gc.setFont(new Font(36));
	        	gc.fillText("GO!", xpos + 10, ypos + 50);
	        	break;
			case 2: gc.setFill(Color.ORANGE);
				gc.fillRect(xpos + 54, ypos + 1, 55, 55);
				gc.setFill(Color.FLORALWHITE);
				gc.fillRect(xpos + 65, ypos + 10, 35, 35);
				gc.setFill(Color.BLACK);
				gc.fillRect(xpos + 65, ypos + 10, 5, 35);
				gc.fillRect(xpos + 75, ypos + 10, 5, 35);
				gc.fillRect(xpos + 85, ypos + 10, 5, 35);
				gc.fillRect(xpos + 95, ypos + 10, 5, 35);
				break;
			case 3: break;
			case 4: break;
			default: break;			
        }
    		
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
     * this method does is draw all the pieces that are in play.
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
            drawPropertyRight(gc, xPos, yPos, colors[colorCounter]);
            yPos += 66;
            colorCounter++;
        }
        
        drawCorner(gc, 704, 704, Color.FLORALWHITE, 1);
        drawCorner(gc, 0, 704, Color.FLORALWHITE, 2);
        drawCorner(gc, 0, 0, Color.FLORALWHITE, 3);
        drawCorner(gc, 704, 0, Color.FLORALWHITE, 4);
        
        
        
        
        if (Main.getGc().getSpecificPlayer(1).isInPlay()) {
        	PieceDrawer.movePiece(gc, 1, 0, Main.getGc().
        			getSpecificPlayer(1).getPlayPieceID());
        }

            
    }
    
    /**
     * Draws the piece on the canvas.
     * @param gc This is the graphics context that belongs to the canvas that
     * you want to  draw the piece on on
     * @param xpos The horizontal position
     * @param ypos The vertical position
     * @param color The color of the piece being drawn.
     */
    public static void drawPiece(final GraphicsContext gc, final double xpos,
    		final double ypos, final Color color) {
        gc.setFill(color);
        gc.fillRect(xpos, ypos, PIECE_WIDTH_BIG, PIECE_WIDTH_BIG);
    }
    /**
     * puts the image on the canvas.
     * @param pic This is the image that is to be put on the canvas
     * @param xpos The horizontal position
     * @param ypos The vertical position
     */
    public static void drawImage (final double xpos, final double ypos) {
    	 
    }
    
    public static Image getMonitor() {
    	Image pic = null ;
    	 try {
    		 pic = new Image(new FileInputStream(
              		"C:\\Users\\Kyle\\eclipse-workspace\\Monopoly-Demo\\cis"
              		+ "\\monopoly\\images\\Monitor.jpg"));
          	ImageView imv = new ImageView(pic);
          	imv.getStyleClass().add(".image");
          	
          } catch (Exception FileNotFoundException) {
          	AlertBox.display("Image not found", "The image you were looking"
          			+ " for was not found.");
          }
    	 
		return pic;
     }
    
    public static Image getKeyboard() {
    	Image pic = null ;
    	 try {
    		 pic = new Image(new FileInputStream(
              		"C:\\Users\\Kyle\\eclipse-workspace\\Monopoly-Demo\\cis"
              		+ "\\monopoly\\images\\Keyboard.jpg"));
          	ImageView imv = new ImageView(pic);
          	imv.getStyleClass().add(".image");
          	
          } catch (Exception FileNotFoundException) {
          	AlertBox.display("Image not found", "The image you were looking"
          			+ " for was not found.");
          }
    	 
		return pic;
     }
    
    public static Image getMouse() {
    	Image pic = null ;
    	 try {
    		 pic = new Image(new FileInputStream(
              		"C:\\Users\\Kyle\\eclipse-workspace\\Monopoly-Demo\\cis"
              		+ "\\monopoly\\images\\Mouse.png"));
          	ImageView imv = new ImageView(pic);
          	imv.getStyleClass().add(".image");
          	
          } catch (Exception FileNotFoundException) {
          	AlertBox.display("Image not found", "The image you were looking"
          			+ " for was not found.");
          }
    	 
		return pic;
     }
    
    public static Image getCPU() {
    	Image pic = null ;
    	 try {
    		 pic = new Image(new FileInputStream(
              		"C:\\Users\\Kyle\\eclipse-workspace\\Monopoly-Demo\\cis"
              		+ "\\monopoly\\images\\CPU.jpg"));
          	ImageView imv = new ImageView(pic);
          	imv.getStyleClass().add(".image");
          	
          } catch (Exception FileNotFoundException) {
          	AlertBox.display("Image not found", "The image you were looking"
          			+ " for was not found.");
          }
    	 
		return pic;
     }
    
    public static Image getPlayerimage (int pieceID) {
    	String filePath = "";
    	filePath = "C:\\Users\\Kyle\\eclipse-workspace\\Monopoly-Demo\\cis" +
    			+ "\\monopoly\\images\\" + Integer.toString(pieceID)+ ".jpg";
    	
    }
    
    /**
     * Draws the player piece based upon what pieceID they have selected (color,
     * and eventually icon) and what their ID is.
     * @param gc
     * @param playerID
     * @param position
     * @param pieceID
     */
    public static void movePiece(final GraphicsContext gc, final int playerID,
    		final int position, final int pieceID) {
        int originX = 0;
        int originY = 0;
        Color playerColor = Color.FLORALWHITE;

        //SET PLAYER COLOR//
        if (pieceID == 1) {
            playerColor = Color.RED;
        } else if (pieceID == 2) {
            playerColor = Color.BLUE;
        } else if (pieceID == 3) {
            playerColor = Color.PURPLE;
        } else if (pieceID == 4) {
            playerColor = Color.GREEN;
=======
        
        if (Main.getGc().getSpecificPlayer(2).isInPlay()) {
        	PieceDrawer.movePiece(gc, 2, 0, Main.getGc().
        			getSpecificPlayer(2).getPlayPieceID());
>>>>>>> fded1d61e476fdb732ed7b91f5822fe63a895d6e:src/cis/monopoly/gameDrawers/BoardDrawer.java
        }
        
        if (Main.getGc().getSpecificPlayer(3).isInPlay()) {
        	PieceDrawer.movePiece(gc, 3, 0, Main.getGc().
        			getSpecificPlayer(3).getPlayPieceID());
        }
        
        if (Main.getGc().getSpecificPlayer(4).isInPlay()) {
        	PieceDrawer.movePiece(gc, 4, 0, Main.getGc().
        			getSpecificPlayer(4).getPlayPieceID());
        }
    }
    
}
