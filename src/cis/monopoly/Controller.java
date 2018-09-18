package cis.monopoly;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Controller {

    public Button btnNewGame, btnExit, btnMainMenu;

    public void exitClick() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    public void newGameClick() {
        Stage stage = (Stage) btnNewGame.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("HowManyPlayers.fxml"));
            stage.setScene(new Scene(root, 1200, 800));
        } catch (java.io.IOException e ) {
            AlertBox ioAlert = new AlertBox();
            ioAlert.display("ioException", "You have encountered an IO Exception");
        }
    }

    public void mainMenuClick() {
        Stage stage = (Stage) btnMainMenu.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            stage.setScene(new Scene(root, 1200, 800));
        } catch (java.io.IOException e ) {
            AlertBox ioAlert = new AlertBox();
            ioAlert.display("ioException", "You have encountered an IO Exception");
        }
    }

}
