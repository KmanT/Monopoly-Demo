package cis.monopoly;

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
    public static final int P1_HORIZONTAL = 0;
    public static final int P1_VERTICAL = 0;
    public static final int P2_HORIZONTAL = 0;
    public static final int P2_VERTICAL = 0;
    public static final int P3_HORIZONTAL = 0;
    public static final int P3_VERTICAL = 0;
    public static final int P4_HORIZONTAL = 0;
    public static final int P4_VERTICAL = 0;

    public static final Color GV_BLUE = Color.web("#0065a4");

    /*public void BoardDrawer() {
        canvas = new Canvas(Main.WINDOW_LENGTH, Main.WINDOW_LENGTH);
        gc = canvas.getGraphicsContext2D();
    }*/

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

        drawPiece(gc, 710, 710, Color.SILVER );


    }

    public static void drawPiece(GraphicsContext gc, double xpos, double ypos, Color color) {
        gc.setFill(color);
        gc.fillRect(xpos,ypos, PIECE_WIDTH, PIECE_WIDTH);
    }

    public static void movePiece() {

        //get current playPos before roll

        //cover current playPos with "FLORAL_WHITE"

        //apply logic

        /*
        //GO CORNER//
        P1(origin_x + 78, origin_y)
        P2(origin_ x + 78, origin_y + 46)
        P3(origin_x + 64, origin_y + 78)
        P4(origin_x, origin_y + 78)

        //BOTTOM ROW//
        P1(origin_x, origin_y + 40)
        P2(origin_ x + 34, origin_y + 40)
        P3(origin_x, origin_ + 74)
        P4(origin_x + 34, origin_y + 74)

        //JAIL CORNER//
        P1(origin_x + 78, origin_y + 78)
        P2(origin_ x + 32, origin_y + 78)
        P3(origin_x, origin_y + 46)
        P4(origin_x, origin_y)

        //LEFT COLUMN//
        P1(origin_x + 4, origin_y)
        P2(origin_ x + 34, origin_y)
        P3(origin_x + 4, origin_y + 34)
        P4(origin_x + 34, origin_y + 34)

        //FREE CORNER//
        P1(origin_x, origin_y + 78)
        P2(origin_ x, origin_y + 32)
        P3(origin_x + 32, origin_y + 25)
        P4(origin_x, origin_y + 59)

        //TOP ROW//
        P1(origin_x, origin_y + 4)
        P2(origin_ x + 34, origin_y + 4)
        P3(origin_x, origin_y + 74)
        P4(origin_x + 34, origin_y + 74)

        //GOTO JAIL CORNER//
        P1(origin_x + 25, origin_y)
        P2(origin_ x + 59, origin_y)
        P3(origin_x + 91, origin_y + 25)
        P4(origin_x + 91, origin_y + 59)

        //RIGHT COLUMN//
        P1(origin_x + 40, origin_y)
        P2(origin_ x + 34, origin_y)
        P3(origin_x + 40, origin_y + 74)
        P4(origin_x + 34, origin_y + 74)

         */

    }
}
