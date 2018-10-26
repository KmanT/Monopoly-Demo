package cis.monopoly.guiElements;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * This class is used to create an AlertBox that will
 * notify the user of an issue or error. Used for
 * exception handling.
 * @author Kyle Turske
 * @version 0.1
 */

public class AlertBox {

    /**
     *
     * @param title This is the title for the AlertBox in which the type of error
     *             or message is displayed here
     * @param message This is the actual message displayed inside the AlertBox.
     *                Specific details of the error can be passed through here.
     */

    public static void display(String title, String message)
    {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);

        Label label = new Label();
        label.setText(message);
        Button closeButton = new Button("Close window");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();


    }

}
