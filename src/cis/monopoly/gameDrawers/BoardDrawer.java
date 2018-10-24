package cis.monopoly.gameDrawers;

import cis.monopoly.gamePlay.GameController;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class BoardDrawer {

    //BOARD VALUES//
    public static final int BOARD_LENGTH = 814;
    public static final int PROPERTY_HEIGHT = 110;
    public static final int PROPERTY_WIDTH = 66;
    public static final int PROPERTY_FLAG_HEIGHT = 30;

    //PIECE VALUES//
    public static final int PIECE_WIDTH = 32;

    public static final Color GV_BLUE = Color.web("#0065a4");

    public static void drawPropertyTop(GraphicsContext gc, int xpos, int ypos, Color color, String name) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos,ypos, PROPERTY_WIDTH, PROPERTY_HEIGHT);

        gc.setFill(color);
        gc.fillRect(xpos,ypos + 80, PROPERTY_WIDTH, PROPERTY_FLAG_HEIGHT);
        gc.strokeRect(xpos,ypos, PROPERTY_WIDTH, PROPERTY_HEIGHT);
        gc.strokeText(name,xpos,ypos + 95);

    }

    public static void drawPropertyBottom(GraphicsContext gc, int xpos, int ypos, Color color, String name) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos,ypos, PROPERTY_WIDTH, PROPERTY_HEIGHT);

        gc.setFill(color);
        gc.fillRect(xpos,ypos, PROPERTY_WIDTH, PROPERTY_FLAG_HEIGHT);
        gc.strokeRect(xpos,ypos, PROPERTY_WIDTH, PROPERTY_HEIGHT);
        gc.strokeText(name,xpos,ypos + 15);

    }

    public static void drawPropertyLeft(GraphicsContext gc, int xpos, int ypos, Color color, String name) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos,ypos, PROPERTY_HEIGHT, PROPERTY_WIDTH);

        gc.setFill(color);
        gc.fillRect(xpos + 80,ypos, PROPERTY_FLAG_HEIGHT, PROPERTY_WIDTH);
        gc.strokeRect(xpos,ypos, PROPERTY_HEIGHT, PROPERTY_WIDTH );
        gc.strokeText(name,xpos,ypos + 15);

    }

    public static void drawPropertyRight(GraphicsContext gc, int xpos, int ypos, Color color, String name) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos,ypos, PROPERTY_HEIGHT, PROPERTY_WIDTH);

        gc.setFill(color);
        gc.fillRect(xpos,ypos, PROPERTY_FLAG_HEIGHT, PROPERTY_WIDTH);
        gc.strokeRect(xpos,ypos, PROPERTY_HEIGHT, PROPERTY_WIDTH);
        gc.strokeText(name,xpos,ypos + 15);
    }

    public static void drawCorner(GraphicsContext gc, double xpos, double ypos, Color color, String name) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos,ypos, PROPERTY_HEIGHT, PROPERTY_HEIGHT);
        gc.strokeRect(xpos,ypos, PROPERTY_HEIGHT, PROPERTY_HEIGHT);
    }

    public static void drawBoard(GraphicsContext gc) {
        Color[] colors = {Color.SIENNA, Color.FLORALWHITE,
                Color.SIENNA, Color.FLORALWHITE, Color.BLACK,
                Color.POWDERBLUE, Color.FLORALWHITE, Color.POWDERBLUE,
                Color.POWDERBLUE, Color.ORCHID, Color.GRAY,
                Color.ORCHID, Color.ORCHID, Color.BLACK,
                Color.ORANGE, Color.FLORALWHITE, Color.ORANGE,
                Color.ORANGE, Color.RED, Color.FLORALWHITE,
                Color.RED, Color.RED, Color.BLACK,
                Color.YELLOW, Color.YELLOW, Color.GRAY,
                Color.YELLOW,Color.MEDIUMSPRINGGREEN, Color.MEDIUMSPRINGGREEN,
                Color.FLORALWHITE, Color.MEDIUMSPRINGGREEN, Color.BLACK,
                Color.FLORALWHITE, Color.DODGERBLUE, Color.FLORALWHITE,
                Color.DODGERBLUE}; //new Color[36];

        gc.setFill(GV_BLUE);
        gc.fillRect(0,0, 814, 814);

        int colorCounter = 0;
        int xPos = 638;
        int yPos = 704;
        for (int i = 0; i <= 8; i++) {
            drawPropertyBottom(gc, xPos, yPos, colors[colorCounter], "");
            xPos -= 66;
            colorCounter++;
        }

        xPos = 0;
        yPos = 638;
        for (int i = 0; i <=8; i++) {
            drawPropertyLeft(gc, xPos, yPos, colors[colorCounter], "");
            yPos -= 66;
            colorCounter++;
        }

        xPos = 110;
        yPos = 0;
        for (int i = 0; i <= 8; i++) {
            drawPropertyTop(gc, xPos, yPos, colors[colorCounter], "");
            xPos += 66;
            colorCounter++;
        }

        xPos = 704;
        yPos = 110;
        for (int i = 0; i<= 8; i++) {
            drawPropertyRight(gc, xPos, yPos, colors[colorCounter], "");
            yPos += 66;
            colorCounter++;
        }

        drawCorner(gc, 0, 0, Color.FLORALWHITE, "");
        drawCorner(gc, 704, 0, Color.FLORALWHITE, "");
        drawCorner(gc, 0, 704, Color.FLORALWHITE, "");
        drawCorner(gc, 704, 704, Color.FLORALWHITE, "");

        for (int i = 0; i <= 3; i++)
            movePiece(gc, i + 1, 0, i + 1); //draws each piece on the starting position

    }

    public static void drawPiece(GraphicsContext gc, double xpos, double ypos, Color color) {
        gc.setFill(color);
        gc.fillRect(xpos,ypos, PIECE_WIDTH, PIECE_WIDTH);
    }

    public static void movePiece(GraphicsContext gc, int playerID, int position, int pieceID) {
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
        }


        if (position == 0) {
            //GO CORNER//
            originX = 704;
            originY = 704;
            switch (playerID) {
                case 1: drawPiece(gc, originX + 78, originY, playerColor);
                    break;
                case 2: drawPiece(gc, originX + 78, originY + 46, playerColor);
                    break;
                case 3: drawPiece(gc, originX + 46, originY + 78, playerColor);
                    break;
                case 4: drawPiece(gc, originX, originY + 78, playerColor);
                    break;
            }

        } else if (position > 0 && position <= 9) {
            //BOTTOM ROW//
            originX = 704 - PROPERTY_WIDTH * position;
            originY = 704;
            switch (playerID) {
                case 1: drawPiece(gc, originX, originY + 40, playerColor);
                    break;
                case 2: drawPiece(gc, originX + 34, originY + 40, playerColor);
                    break;
                case 3: drawPiece(gc, originX, originY + 74, playerColor);
                    break;
                case 4: drawPiece(gc, originX + 34, originY + 74, playerColor);
                    break;
            }

        } else if (position == 10) {
            //JAIL CORNER//
            originX = 0;
            originY = 704;
            switch (playerID) {
                case 1: drawPiece(gc, originX + 78, originY + 78, playerColor);
                    break;
                case 2: drawPiece(gc, originX + 32, originY + 78, playerColor);
                    break;
                case 3: drawPiece(gc, originX, originY + 46, playerColor);
                    break;
                case 4: drawPiece(gc, originX, originY, playerColor);
                    break;
            }

        } else if (position > 10 && position <= 19) {
            //LEFT COLUMN//
            originX = 0;
            originY = 704 - PROPERTY_WIDTH * (position - 10);
            switch (playerID) {
                case 1: drawPiece(gc, originX + 4, originY, playerColor);
                    break;
                case 2: drawPiece(gc, originX + 34, originY, playerColor);
                    break;
                case 3: drawPiece(gc, originX + 4, originY + 34, playerColor);
                    break;
                case 4: drawPiece(gc, originX + 34, originY + 34, playerColor);
                    break;
            }

        } else if (position == 20) {
            //FREE CORNER//
            originX = 0;
            originY = 0;
            switch (playerID) {
                case 1: drawPiece(gc, originX, originY + 78, playerColor);
                    break;
                case 2: drawPiece(gc, originX, originY + 32, playerColor);
                    break;
                case 3: drawPiece(gc, originX + 32, originY, playerColor);
                    break;
                case 4: drawPiece(gc, originX + 78, originY, playerColor);
                    break;
            }
        } else if (position > 20 && position <= 29) {
            //TOP ROW//
            originX = 110 + PROPERTY_WIDTH * (position - 20);
            originY = 0;
            switch (playerID) {
                case 1: drawPiece(gc, originX, originY + 4, playerColor);
                    break;
                case 2: drawPiece(gc, originX + 34, originY + 4, playerColor);
                    break;
                case 3: drawPiece(gc, originX, originY + 34, playerColor);
                    break;
                case 4: drawPiece(gc, originX + 34, originY + 34, playerColor);
                    break;
            }
        }  else if (position == 30) {
            //GO TO JAIL CORNER//
            originX = 704;
            originY = 110;
            switch (playerID) {
                case 1: drawPiece(gc, originX, originY, playerColor);
                    break;
                case 2: drawPiece(gc, originX + 46, originY, playerColor);
                    break;
                case 3: drawPiece(gc, originX + 78, originY + 32, playerColor);
                    break;
                case 4: drawPiece(gc, originX + 78, originY + 78, playerColor);
                    break;
            }
        } else if (position > 30 && position <= 39) {
            //RIGHT COLUMN//
            originX = 704;
            originY = 110 + PROPERTY_WIDTH * (position - 30);
            switch (playerID) {
                case 1: drawPiece(gc, originX + 34, originY, playerColor);
                    break;
                case 2: drawPiece(gc, originX + 68, originY, playerColor);
                    break;
                case 3: drawPiece(gc, originX + 34, originY + 34, playerColor);
                    break;
                case 4: drawPiece(gc, originX + 68, originY + 34, playerColor);
                    break;
            }
        }

    }

    public static void drawFullPlayerMove(GraphicsContext gc, int playerID, int position, int roll, int pieceID) {
        //Draws a white square over the previous position
        if (position - roll < 0) { // if the player position was previous in the right column
            movePiece(gc, playerID, GameController.MAX_SPACES + position - roll, 0);
        } else { //any other space
            movePiece(gc, playerID, position - roll, 0);
        }
        movePiece(gc, playerID, position, pieceID);
    }
}
