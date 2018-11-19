package cis.monopoly.guiElements;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * This class is used to for confirmation of a decision.
 * The ConfirmBox will return a boolean based upon whether the user chooses
 * "YES" or "NO."
 * @author Kyle Turske
 * @version 0.1
 *
 */

public final class ConfirmBox {
    
	/**This defines the what the user clicked ("Yes" or "No).*/
    private static boolean answer;
    
    /**
	 * Private constructor.
	 */
    private ConfirmBox() {
    	
    }

    /**
     * This is a method that displays a pop-up of the confirmation the user.
     * @param title This the title of the pop-up.
     * @param message This the message that comes with the pop-up.
     * @return answer This is either a "Yes" or "No".
     * */
    public static boolean display(final String title, final String message) {
        Stage window = new Stage();
        window.initStyle(StageStyle.UNDECORATED);        
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
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(label, btnYes, btnNo);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;

    }

}
