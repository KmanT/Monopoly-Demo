package cis.monopoly.guiElements;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**<h1>ChanceBox</h1>
 * This class is used to create an AlertBox that will display information from
 * a chance card that a player has received.
 * @author Kyle Turske
 * @version 0.6
 */
public final class ChanceBox {
	
	/**
	 * Private constructor.
	 */
	private ChanceBox() {
		
	}
	
	/**
	 * Shows the chance box once called.
	 * @param cardText The text on the card.
	 */
    public static void display(final String cardText) {
    	Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Chance");
        window.setMinWidth(300);
        window.setMinHeight(400);
        
        Label label = new Label();
        label.setText(cardText);
        
        
        Button closeButton = new Button("OK");
        closeButton.setOnAction(e -> window.close());
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setAlignment(Pos.CENTER);
        try {
        	Image image = new Image("cis/monopoly/images/chance.png");
        	ImageView imv = new ImageView(image);
        	imv.getStyleClass().add(".image");
        	layout.getChildren().addAll(imv, label, closeButton);
        	
        } catch (Exception FileNotFoundException) {
        	AlertBox.display("Image not found", "The image you were looking"
        			+ " for was not found.");
        	layout.getChildren().addAll(label, closeButton);
        }
          

        Scene scene = new Scene(layout);
        scene.getStylesheets().add(
        		"cis/monopoly/guiElements/chance-style.css");
        window.setScene(scene);
        window.showAndWait();
    }

}
