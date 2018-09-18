package cis.monopoly;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class is used to for confirmation of a decision. The ConfirmBox will return a boolean
 * based upon whether the user chooses "YES" or "NO."
 * @author Kyle Turske
 * @version 0.1
 *
 */

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message)
    {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(350);
        Label label = new Label();
        label.setText(message);

        //Create two buttons
        Button btnYes = new Button("Yes");
        Button btnNo = new Button("No");

        btnYes.setOnAction(e -> {
            answer = true;
            window.close();
        });

        btnNo.setOnAction(e -> {
            answer = false;
            window.close();
        });


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(label, btnYes, btnNo);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;

    }

}
