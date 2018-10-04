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
    //public VBox gamePane;

    @FXML
    private Canvas canvas;

    @FXML
    void intialize() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        BoardDrawer.drawBoard(gc);
    }

    public void exitClick() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    public void newGameClick() {
        Stage stage = (Stage) btnNewGame.getScene().getWindow();
        try {
            GamePlayScene gs = new GamePlayScene();
            Parent root = FXMLLoader.load(getClass().getResource
                    ("HowManyPlayers.fxml"));
            stage.setScene(new Scene(root, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
        } catch (java.io.IOException e) {
            AlertBox ioAlert = new AlertBox();
            ioAlert.display("ioException", "You have encountered an IO Exception");
        }
    }

    @FXML
    private void drawCanvas(ActionEvent event) {

    }

    public void mainMenuClick() {
        Stage stage = (Stage) btnMainMenu.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource
                    ("MainMenu.fxml"));
            stage.setScene(new Scene(root, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
        } catch (java.io.IOException e) {
            AlertBox ioAlert = new AlertBox();
            ioAlert.display("ioException", "You have encountered an IO Exception");
        }
    }

    public void startGameClick() {
        Stage stage = (Stage) btnTwoPlayer.getScene().getWindow();
        GamePlayScene gs = new GamePlayScene();
        Scene gameScene = new Scene(gs.GamePlayScene(), Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        stage.setScene(gameScene);


    }
}