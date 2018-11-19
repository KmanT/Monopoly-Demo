package cis.monopoly.guiElements;

import cis.monopoly.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**<h1>HowManyPlayersGUI</h1>
 * This class hold the layout for the the menu where you choose the number of
 * active players. There is a label that asks how many players that will be in
 * the game, and then four buttons corresponding to the number of active
 * players. There is also a button which will bring the user back to the main
 * menu.
 * @author Kyle Turske
 * @version 0.5
 */
public final class HowManyPlayersGUI {
	
	/**The player count menu layout.*/
	private static VBox howManyPane;
	
	/**The next scene to be shown.*/
	private static Scene infoScene;
	
	/**
	 * Private constructor.
	 */
	private HowManyPlayersGUI() {
		
	}
	
	/**
	 * Sets up the layout for the MainMenuGUI.
	 * @return The layout for the scene that allows the user to select the
	 * number of players.
	 */
	public static VBox howManyScene() {
		howManyPane = new VBox(10);
		howManyPane.getStylesheets().add(
        		"cis/monopoly/guiElements/main-style.css");
		Label lblMessage = new Label("How Many Players?");
		GridPane buttonPane = new GridPane();
		buttonPane.setAlignment(Pos.CENTER);
		
		Button btnOnePlayer = new Button("Player vs Computer");
		btnOnePlayer.setOnAction(e -> {
			Main.getGc().deactivateAllPlayers();
			Main.getGc().activatePlayers(1);
			changeScene(btnOnePlayer);
		});
		
		Button btnTwoPlayer = new Button("Two Players");
		btnTwoPlayer.setOnAction(e -> {
			Main.getGc().deactivateAllPlayers();
			Main.getGc().activatePlayers(2);
			changeScene(btnTwoPlayer);			
		});
		
		Button btnThreePlayer = new Button("Three Players");
		btnThreePlayer.setOnAction(e -> {
			Main.getGc().deactivateAllPlayers();
			Main.getGc().activatePlayers(3);
			changeScene(btnThreePlayer);			
		});
		
		Button btnFourPlayer = new Button("Four Players");
		btnFourPlayer.setOnAction(e -> {
			Main.getGc().deactivateAllPlayers();
			Main.getGc().activatePlayers(4);
			changeScene(btnFourPlayer);			
		});
		
		GridPane.setConstraints(btnOnePlayer, 0, 0);
		GridPane.setConstraints(btnTwoPlayer, 1, 0);
		GridPane.setConstraints(btnThreePlayer, 0, 1);
		GridPane.setConstraints(btnFourPlayer, 1, 1);
		
		buttonPane.setVgap(10);
		buttonPane.setHgap(10);
		buttonPane.getChildren().addAll(btnOnePlayer, btnTwoPlayer, 
				btnThreePlayer, btnFourPlayer);
		Button btnBack = new Button("Back");
		btnBack.setOnAction(e -> {
			Stage stage = (Stage) btnBack.getScene().getWindow();
			stage.setScene(Main.getMainScene());
		});
		
		howManyPane.setPadding(new Insets(10, 10, 10, 10));
		howManyPane.setAlignment(Pos.CENTER);
		howManyPane.getChildren().addAll(lblMessage, buttonPane,
				btnBack);
		return howManyPane;
	}
	
	/**
	 * Allows the next scene to be shown.
	 * @param btn Can be either The one player, two player, three player, or
	 * four player. This allows the activation of the corresponding number
	 * of players in each of the button's respective lambda statements.
	 */
	private static void changeScene(final Button btn) {
		Stage stage = (Stage) btn.getScene().getWindow();
		infoScene = new Scene(PlayerInfoGUI.infoPane(),
				Main.getWindowWidth(), Main.getWindowHeight());
		stage.setScene(infoScene);
	}
	
	/**
	 * Gets the next scene to be shown.
	 * @return The layout for the scene to set the player information (name,
	 * and what piece they use.)
	 */
	public static Scene getInfoScene() {
		return infoScene;
	}	
	
}
