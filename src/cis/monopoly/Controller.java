package cis.monopoly;

import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Controller {

    public Button btnNewGame, btnExit;

    public void exitClick() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

}
