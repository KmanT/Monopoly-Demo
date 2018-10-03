package cis.monopoly;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

import static com.sun.corba.se.impl.util.Utility.printStackTrace;

/**
 * This class controls the UI and FXML Elements for the program.
 * All GUI related logic will go inside here
 * @author Kyle Turske
 * @version 0.1
 *
 */

public class Controller {

    public Button btnNewGame, btnExit, btnMainMenu, btnTwoPlayer;
    public VBox gamePane;
    public Canvas canvas = new Canvas(BoardDrawer.BOARD_LENGTH, BoardDrawer.BOARD_LENGTH);
    public GraphicsContext gc = canvas.getGraphicsContext2D();

    public void exitClick() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    public void newGameClick() {
        Stage stage = (Stage) btnNewGame.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource
                    ("HowManyPlayers.fxml"));
            stage.setScene(new Scene(root, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
        } catch (java.io.IOException e ) {
            AlertBox ioAlert = new AlertBox();
            ioAlert.display("ioException", "You have encountered an IO Exception");
        }
    }

    @FXML private void drawCanvas(ActionEvent event) {

    }

    public void mainMenuClick() {
        Stage stage = (Stage) btnMainMenu.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource
                    ("MainMenu.fxml"));
            stage.setScene(new Scene(root, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
        } catch (java.io.IOException e ) {
            AlertBox ioAlert = new AlertBox();
            ioAlert.display("ioException", "You have encountered an IO Exception");
        }
    }

    public void startGameClick() {
        Stage stage = (Stage) btnTwoPlayer.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource
                    ("GamePlay.fxml"));
            stage.setScene(new Scene(root, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
            //drawBoard(gc);
        } catch (java.io.IOException e ) {
            AlertBox ioAlert = new AlertBox();
            ioAlert.display("ioException", "You have encountered an IO Exception");
            printStackTrace();
        }


    }
/*
    public void drawPropertyTop(GraphicsContext gc, int xpos, int ypos, Color color, String name) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos,ypos, PROPERTY_WIDTH, PROPERTY_HEIGHT);

        gc.setFill(color);
        gc.fillRect(xpos,ypos + 80, PROPERTY_WIDTH, PROPERTY_FLAG_HEIGHT);
        gc.strokeRect(xpos,ypos, PROPERTY_WIDTH, PROPERTY_HEIGHT);
        gc.strokeText(name,xpos,ypos + 95);

    }

    public void drawPropertyBottom(GraphicsContext gc, int xpos, int ypos, Color color, String name) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos,ypos, PROPERTY_WIDTH, PROPERTY_HEIGHT);

        gc.setFill(color);
        gc.fillRect(xpos,ypos, PROPERTY_WIDTH, PROPERTY_FLAG_HEIGHT);
        gc.strokeRect(xpos,ypos, PROPERTY_WIDTH, PROPERTY_HEIGHT);
        gc.strokeText(name,xpos,ypos + 15);

    }

    public void drawPropertyLeft(GraphicsContext gc, int xpos, int ypos, Color color, String name) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos,ypos, PROPERTY_HEIGHT, PROPERTY_WIDTH);

        gc.setFill(color);
        gc.fillRect(xpos + 80,ypos, PROPERTY_FLAG_HEIGHT, PROPERTY_WIDTH);
        gc.strokeRect(xpos,ypos, PROPERTY_HEIGHT, PROPERTY_WIDTH );
        gc.strokeText(name,xpos,ypos + 15);

    }

    public void drawPropertyRight(GraphicsContext gc, int xpos, int ypos, Color color, String name) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos,ypos, PROPERTY_HEIGHT, PROPERTY_WIDTH);

        gc.setFill(color);
        gc.fillRect(xpos,ypos, PROPERTY_FLAG_HEIGHT, PROPERTY_WIDTH);
        gc.strokeRect(xpos,ypos, PROPERTY_HEIGHT, PROPERTY_WIDTH);
        gc.strokeText(name,xpos,ypos + 15);
    }

    public void drawCorner(GraphicsContext gc, double xpos, double ypos, Color color, String name) {
        gc.setFill(Color.FLORALWHITE);
        gc.setStroke(Color.BLACK);
        gc.fillRect(xpos,ypos, 110, 110);
        gc.strokeRect(xpos,ypos, 110, 110);
    }

    public void drawBoard(GraphicsContext gc) {
        Color[] colors = new Color[36];

        colors[0] = Color.SIENNA;
        colors[1] = Color.FLORALWHITE;
        colors[2] = Color.SIENNA;
        colors[3] = Color.FLORALWHITE;
        colors[4] = Color.BLACK;
        colors[5] = Color.POWDERBLUE;
        colors[6] = Color.FLORALWHITE;
        colors[7] = Color.POWDERBLUE;
        colors[8] = Color.POWDERBLUE;
        colors[9] = Color.ORCHID;
        colors[10] = Color.GRAY;
        colors[11] = Color.ORCHID;
        colors[12] = Color.ORCHID;
        colors[13] = Color.BLACK;
        colors[14] = Color.ORANGE;
        colors[15] = Color.FLORALWHITE;
        colors[16] = Color.ORANGE;
        colors[17] = Color.ORANGE;
        colors[18] = Color.RED;
        colors[19] = Color.FLORALWHITE;
        colors[20] = Color.RED;
        colors[21] = Color.RED;
        colors[22] = Color.BLACK;
        colors[23] = Color.YELLOW;
        colors[24] = Color.YELLOW;
        colors[25] = Color.GRAY;
        colors[26] = Color.YELLOW;
        colors[27] = Color.MEDIUMSPRINGGREEN;
        colors[28] = Color.MEDIUMSPRINGGREEN;
        colors[29] = Color.FLORALWHITE;
        colors[30] = Color.MEDIUMSPRINGGREEN;
        colors[31] = Color.BLACK;
        colors[32] = Color.FLORALWHITE;
        colors[33] = Color.DODGERBLUE;
        colors[34] = Color.FLORALWHITE;
        colors[35] = Color.DODGERBLUE;

        gc.setFill(Color.FLORALWHITE);
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


    }
*/


    /*
    public void sceneChange(Button btn, String sceneName) {
        Stage stage = (Stage) btn.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource
                    (sceneName + ".fxml"));
            stage.setScene(new Scene(root, 1200, 800));
        } catch (java.io.IOException e ) {
            AlertBox ioAlert = new AlertBox();
            ioAlert.display("ioException", "You have encountered an IO Exception");
        }
    }
    */
}
