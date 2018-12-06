package cis.monopoly.guiElements;

import cis.monopoly.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**<h1>MainGUI</h1>
 * This class hold the layout for the main menu. There is a label welcoming the
 * player, a button that changes the window to ask how many players are active,
 * and a button that closes the window.
 * @author Kyle Turske
 * @version 0.5
 */
public final class MainGUI {
	
	/**The main menu layout.*/
	private static VBox mainPane;
	
	/**The next scene to be displayed.*/
	private static Scene howManyScene;
	
	/**
	 * Private constructor.
	 */
	private MainGUI() {
		
	}
	
	/**
	 * Sets up the layout for the MainMenuGUI.
	 * @return The layout for the main menu.
	 */
	public static VBox mainScene() {
		mainPane = new VBox(10);
		mainPane.getStylesheets().add(
        		"cis/monopoly/guiElements/main-style.css");
		Label lblWelcome = new Label("Welcome to GVSU Monopoly!");
		Button btnStartGame = new Button("New Game");
		btnStartGame.setOnAction(e -> {
			Stage stage = (Stage) 
					btnStartGame.getScene().getWindow();
			howManyScene = new Scene(
					HowManyPlayersGUI.howManyScene(),
					Main.getWindowWidth(),
					Main.getWindowHeight());
			stage.setScene(howManyScene);
		});
		Button btnExit = new Button("Exit");
		btnExit.setOnAction(e -> {
			Stage stage = (Stage) btnExit.getScene().getWindow();
			stage.close();
		});
		
		mainPane.setPadding(new Insets(10, 10, 10, 10));
		mainPane.setSpacing(10);
		mainPane.setAlignment(Pos.CENTER);
		mainPane.getChildren().addAll(lblWelcome, btnStartGame,
				btnExit);
		return mainPane;
	}
	
	/**
	 * Gets the layout to determine how many players.
	 * @return The layout for "how many players"
	 */
	public static Scene getHowManyScene() {
		return howManyScene;
	}
	
	
}
