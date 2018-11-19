package cis.monopoly.gameDrawers;

import cis.monopoly.gamePlay.GameController;
import cis.monopoly.guiElements.AlertBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

/**<h1>PieceDrawer</h1>
 * This class is used to draw the pieces on the board as well as draw their 
 * movement. 
 * @author Kyle Turske
 * @version 0.7
 */
public final class PieceDrawer {
	
	/**Used to define the size of the piece if the board is big.*/
	public static final int PIECE_SIZE_BIG = 32;
	
	/**Used to define the size of the piece if the board is small.*/
	public static final int PIECE_SIZE_SMALL = 16;
	
	/**
	 * Private constructor.
	 */
	private PieceDrawer() {
		
	}
    
    /**
     * Draws the piece on the canvas as an image.
     * @param gc This is the graphics context that belongs to the canvas that
     * you want to  draw the piece on on
     * @param xpos The horizontal position
     * @param ypos The vertical position
     * @param pieceID The id of the piece used to draw on the board. All of the
     * different piece png's are have a filename called "piece#.png" where the
     * pound symbol represents the number. If the ID entered is 0, then a white
     * square will be drawn in that location.
     */
    public static void drawPiece(final GraphicsContext gc, final double xpos,
    		final double ypos, final int pieceID) {
    	
    	if (pieceID == 0) {
    		gc.setFill(Color.FLORALWHITE);
            gc.fillRect(xpos, ypos, PIECE_SIZE_BIG, PIECE_SIZE_BIG);
        	
    	} else {
    		Image piece = new Image("cis/monopoly/images/piece"
        			+ Integer.toString(pieceID) + ".png");
        	
        	gc.drawImage(piece, xpos, ypos);
    	}	
    	
    }
    
    /**
     * Draws the player piece based upon what pieceID they have selected (color,
     * and eventually icon) and what their ID is.
     * @param playerID The id of the player that is moving.
     * @param position The position of the player on the board (0-39).
     * @param gc This is the graphics context that belongs to the canvas that
     * you want to  draw the piece on on
     * @param pieceID The id of the piece used to draw on the board. All of the
     * different piece png's are have a filename called "piece#.png" where the
     * pound symbol represents the number. If the ID entered is 0, then a white
     * square will be drawn in that location.
     */
    public static void movePiece(final GraphicsContext gc, final int playerID,
    		final int position, final int pieceID) {
        int originX = 0;
        int originY = 0;
        

        if (position == 0) {
            //GO CORNER//
            originX = 704;
            originY = 704;
            switch (playerID) {
                case 1: drawPiece(gc, originX + 77, originY + 1, pieceID);
                    break;
                case 2: drawPiece(gc, originX + 77, originY + 46, pieceID);
                    break;
                case 3: drawPiece(gc, originX + 46, originY + 77, pieceID);
                    break;
                case 4: drawPiece(gc, originX + 1, originY + 77, pieceID);
                    break;
                default:
                    AlertBox.display("Player ID Error", "Something"
                            + "went wrong when fetching the playerID.");
            }

        } else if (position > 0 && position <= 9) {
            //BOTTOM ROW//
            originX = 704 - BoardDrawer.PROPERTY_WIDTH_BIG * position;
            originY = 704;
            switch (playerID) {
                case 1: drawPiece(gc, originX + 1, originY + 40, pieceID);
                    break;
                case 2: drawPiece(gc, originX + 33, originY + 40, pieceID);
                    break;
                case 3: drawPiece(gc, originX + 1, originY + 74, pieceID);
                    break;
                case 4: drawPiece(gc, originX + 33, originY + 74, pieceID);
                    break;
                default:
                    AlertBox.display("Player ID Error", "Something"
                            + " went wrong when fetching the playerID.");
            }

        } else if (position == 10) {
            //JAIL CORNER//
            originX = 0;
            originY = 704;
            switch (playerID) {
                case 1: drawPiece(gc, originX + 77, originY + 74, pieceID);
                    break;
                case 2: drawPiece(gc, originX + 33, originY + 74, pieceID);
                    break;
                case 3: drawPiece(gc, originX + 1, originY + 46, pieceID);
                    break;
                case 4: drawPiece(gc, originX + 4, originY + 1, pieceID);
                    break;
                default:
                    AlertBox.display("Player ID Error", "Something"
                            + "went wrong when fetching the playerID.");
            }

        } else if (position > 10 && position <= 19) {
            //LEFT COLUMN//
            originX = 0;
            originY = 704 - BoardDrawer.PROPERTY_WIDTH_BIG * (position - 10);
            switch (playerID) {
                case 1: drawPiece(gc, originX + 4, originY + 1, pieceID);
                    break;
                case 2: drawPiece(gc, originX + 33, originY + 1, pieceID);
                    break;
                case 3: drawPiece(gc, originX + 4, originY + 33, pieceID);
                    break;
                case 4: drawPiece(gc, originX + 33, originY + 33, pieceID);
                    break;
                default:
                    AlertBox.display("Player ID Error", "Something"
                            + "went wrong when fetching the playerID.");
            }

        } else if (position == 20) {
            //FREE CORNER//
            originX = 0;
            originY = 0;
            switch (playerID) {
                case 1: drawPiece(gc, originX + 4, originY + 77, pieceID);
                    break;
                case 2: drawPiece(gc, originX + 4, originY + 33, pieceID);
                    break;
                case 3: drawPiece(gc, originX + 33, originY + 4, pieceID);
                    break;
                case 4: drawPiece(gc, originX + 77, originY + 4, pieceID);
                    break;
                default:
                    AlertBox.display("Player ID Error", "Something"
                            + "went wrong when fetching the playerID.");
            }
        } else if (position > 20 && position <= 29) {
            //TOP ROW//
            originX = 110 + BoardDrawer.PROPERTY_WIDTH_BIG * (position - 21);
            originY = 0;
            switch (playerID) {
                case 1: drawPiece(gc, originX + 1, originY + 4, pieceID);
                    break;
                case 2: drawPiece(gc, originX + 33, originY + 4, pieceID);
                    break;
                case 3: drawPiece(gc, originX + 1, originY + 34, pieceID);
                    break;
                case 4: drawPiece(gc, originX + 33, originY + 34, pieceID);
                    break;
                default:
                    AlertBox.display("Player ID Error", "Something"
                            + "went wrong when fetching the playerID.");
            }
        }  else if (position == 30) {
            //GO TO JAIL CORNER//
            originX = 704;
            originY = 0;
            switch (playerID) {
                case 1: drawPiece(gc, originX + 1, originY + 4, pieceID);
                    break;
                case 2: drawPiece(gc, originX + 45, originY + 4, pieceID);
                    break;
                case 3: drawPiece(gc, originX + 77, originY + 33, pieceID);
                    break;
                case 4: drawPiece(gc, originX + 77, originY + 77, pieceID);
                    break;
                default:
                    AlertBox.display("Player ID Error", "Something"
                            + "went wrong when fetching the playerID.");
            }
        } else if (position > 30 && position <= 39) {
            //RIGHT COLUMN//
            originX = 704;
            originY = 110 + BoardDrawer.PROPERTY_WIDTH_BIG * (position - 31);
            switch (playerID) {
                case 1: drawPiece(gc, originX + 34, originY + 1, pieceID);
                    break;
                case 2: drawPiece(gc, originX + 68, originY + 1, pieceID);
                    break;
                case 3: drawPiece(gc, originX + 34, originY + 33, pieceID);
                    break;
                case 4: drawPiece(gc, originX + 68, originY + 33, pieceID);
                    break;
                default:
                    AlertBox.display("Player ID Error", "Something"
                            + "went wrong when fetching the playerID.");
            }
        }

    }
    
    /**
     * Draws the move of the player on the board. If the old position of the
     * player plus the roll is over the length of the board array, then the
     * new player position will go back to the beginning and continue.
     * Otherwise, the new player position will be the old position plus the
     * roll. Also draws a white square where the old player position is.
     * @param gc The graphics context connected to the board canvas.
     * @param playerID The id of the current player making a turn.
     * @param position Where the player currently is.
     * @param roll The number of spaces to move.
     * @param pieceID Determines the color (eventually icon) belonging to the
     * current player.
     */
    public static void drawFullPlayerMove(final GraphicsContext gc,
    		final int playerID, final int position, final int roll,
    		final int pieceID) {
        //Draws a white square over the previous position
        if (position - roll < 0) {
            movePiece(gc, playerID, GameController.MAX_SPACES
            		+ position - roll, 0);
        } else { //any other space
            movePiece(gc, playerID, position - roll, 0);
        }
        movePiece(gc, playerID, position, pieceID);
    }
    
    /**
     * When the player lands in jail, the BoardDrawer needs to reflect this.
     * So when the player lands on the go to Jail space, the player will be
     * moved to the Jail space.
     * @param gc The graphics context connected to the board canvas.
     * @param playerID The id of the current player making a turn.
     * @param position Where the player currently is.
     * @param pieceID Determines the color (eventually icon) belonging to the
     * current player.
     */
    public static void drawPlayerGoToJail(final GraphicsContext gc,
    		final int playerID, final int position, final int pieceID) {
    	movePiece(gc, playerID, position, 0);
    	movePiece(gc, playerID, 10, pieceID);
    }
	
}
