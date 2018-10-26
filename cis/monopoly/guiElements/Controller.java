package cis.monopoly.guiElements;

import cis.monopoly.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


/**
 * This class controls the UI and FXML Elements for the program.
 * All GUI related logic will go inside here
 * @author Kyle Turske
 * @version 0.5
 *
 */
public class Controller {

    public Button btnNewGame, btnExit, btnMainMenu,
            btnOnePlayer, btnTwoPlayer, btnThreePlayer,
            btnFourPlayer;

    /**
     * exitClick closes the window. btnExit utilizes this method.
     */
    public void exitClick() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    /**
     * Tied to the "New Game" button on the main menu. Changes the scene to
     * HowManyPlayers.fxml
     */
    public void newGameClick() {
        Stage stage = (Stage) btnNewGame.getScene().getWindow();
        try {
            Parent root = FXMLLoader.
                    load(getClass().getResource("HowManyPlayers.fxml"));
            stage.setScene(new Scene(root,
                    Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
        } catch (java.io.IOException e) {
            AlertBox ioAlert = new AlertBox();
            ioAlert.display("ioException",
                    "You have encountered an IO Exception");
        }
    }

    /**
     * Utilized by the "Back" button on the HowManyPlayers.fxml scene.
     * Returns the scene to MainMenu.fxml
     */
    public void mainMenuClick() {
        Stage stage = (Stage) btnMainMenu.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().
                    getResource("guiElements/MainMenu.fxml"));
            stage.setScene(new Scene(root,
                    Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
        } catch (java.io.IOException e) {
            AlertBox ioAlert = new AlertBox();
            ioAlert.display("ioException",
                    "You have encountered an IO Exception");
        }
    }

    /**
     * Changes the scene to the GamePlay scene where the actual game is played.
     * Activates one player and CPU (future feature).
     */
    public void startGameClickOne() {
        Stage stage = (Stage) btnOnePlayer.getScene().getWindow();
        GamePlayScene gs = new GamePlayScene();
        Scene gameScene = new Scene(gs.gamePlayScene(),
                Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        stage.setScene(gameScene);

    }


    /**
     * Changes the scene to the GamePlay scene where the actual game is played.
     * Activates two players (future feature).
     */
    public void startGameClickTwo() {
        Stage stage = (Stage) btnTwoPlayer.getScene().getWindow();
        GamePlayScene gs = new GamePlayScene();
        Scene gameScene = new Scene(gs.gamePlayScene(),
                Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        stage.setScene(gameScene);

    }

    /**
     * Changes the scene to the GamePlay scene where the actual game is played.
     * Activates three players (future feature).
     */
    public void startGameClickThree() {
        Stage stage = (Stage) btnThreePlayer.getScene().getWindow();
        GamePlayScene gs = new GamePlayScene();
        Scene gameScene = new Scene(gs.gamePlayScene(),
                Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        stage.setScene(gameScene);

    }

    /**
     * Changes the scene to the GamePlay scene where the actual game is played.
     * Activates all four players.
     */
    public void startGameClickFour() {
        Stage stage = (Stage) btnFourPlayer.getScene().getWindow();
        GamePlayScene gs = new GamePlayScene();
        Scene gameScene = new Scene(gs.gamePlayScene(),
                Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT);
        stage.setScene(gameScene);

    }
}