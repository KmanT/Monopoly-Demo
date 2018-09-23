package cis.monopoly;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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

    public void exitClick() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    public void newGameClick() {
        Stage stage = (Stage) btnNewGame.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource
                    ("HowManyPlayers.fxml"));
            stage.setScene(new Scene(root, 1200, 800));
        } catch (java.io.IOException e ) {
            AlertBox ioAlert = new AlertBox();
            ioAlert.display("ioException", "You have encountered an IO Exception");
        }
    }

    public void mainMenuClick() {
        Stage stage = (Stage) btnMainMenu.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource
                    ("MainMenu.fxml"));
            stage.setScene(new Scene(root, 1200, 800));
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
            stage.setScene(new Scene(root, 1200, 800));
        } catch (java.io.IOException e ) {
            AlertBox ioAlert = new AlertBox();
            ioAlert.display("ioException", "You have encountered an IO Exception");
            printStackTrace();
        }
    }

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
