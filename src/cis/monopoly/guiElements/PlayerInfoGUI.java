package cis.monopoly.guiElements;

import cis.monopoly.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**<h1>PlayerInfoGUI</h1>
 * This class hold the layout for the the menu where you set the different
 * information for the Players. Here you can choose their name and select the
 * piece they use. The number selection slots will be based on what button
 * was pressed in the previous scene.
 * @author Kyle Turske
 * @version 0.5
 */
public final class PlayerInfoGUI {
	
	/**The layout for this scene.*/
	private static VBox infoPane;
	
	/**The next scene to be loaded.*/
	private static Scene gamePlayScene;
	
	/**
	 * Private constructor.
	 */
	private PlayerInfoGUI() {
		
	}
	
	/**
	 * Returns the layout to be used.
	 * @return The PlayerInfo layout.
	 */
	public static VBox infoPane() {
		infoPane = new VBox(10);
		infoPane.getStylesheets().add(
        		"cis/monopoly/guiElements/main-style.css");
		Label lblMessage = new Label("Name your players and"
				+ " choose your piece.");
		GridPane choosePane = new GridPane();
		choosePane.setAlignment(Pos.CENTER);
		
		Label lblPlayerOne = new Label("Player One");
		TextField txtPlayerOne = new TextField();
		ComboBox<String> cmbPlayerOne = new ComboBox<>();
		cmbPlayerOne.getItems().addAll("1", "2", "3", "4");
		cmbPlayerOne.setCellFactory(new PieceCellFactory());
		cmbPlayerOne.setButtonCell(new PieceCell());
		cmbPlayerOne.getSelectionModel().selectFirst();
		
		Label lblPlayerTwo = new Label("Player Two");
		TextField txtPlayerTwo = new TextField();
		ComboBox<String> cmbPlayerTwo = new ComboBox<>();
		cmbPlayerTwo.getItems().addAll("1", "2", "3", "4");
		cmbPlayerTwo.setCellFactory(new PieceCellFactory());
		cmbPlayerTwo.setButtonCell(new PieceCell());
		cmbPlayerTwo.getSelectionModel().select(1);
		
		Label lblPlayerThree = new Label("Player Three");
		TextField txtPlayerThree = new TextField();
		ComboBox<String> cmbPlayerThree = new ComboBox<>();
		cmbPlayerThree.getItems().addAll("1", "2", "3", "4");
		cmbPlayerThree.setCellFactory(new PieceCellFactory());
		cmbPlayerThree.setButtonCell(new PieceCell());
		cmbPlayerThree.getSelectionModel().select(2);
		
		
		Label lblPlayerFour = new Label("Player Four");
		TextField txtPlayerFour = new TextField();
		ComboBox<String> cmbPlayerFour = new ComboBox<>();
		cmbPlayerFour.getItems().addAll("1", "2", "3", "4");
		cmbPlayerFour.setCellFactory(new PieceCellFactory());
		cmbPlayerFour.setButtonCell(new PieceCell());
		cmbPlayerFour.getSelectionModel().select(3);
		
		
		GridPane.setConstraints(lblPlayerOne, 0, 0);
		GridPane.setConstraints(txtPlayerOne, 1, 0);
		GridPane.setConstraints(cmbPlayerOne, 2, 0);
		hideControls(1, lblPlayerOne, txtPlayerOne, cmbPlayerOne);
		
		GridPane.setConstraints(lblPlayerTwo, 0, 1);
		GridPane.setConstraints(txtPlayerTwo, 1, 1);
		GridPane.setConstraints(cmbPlayerTwo, 2, 1);
		hideControls(2, lblPlayerTwo, txtPlayerTwo, cmbPlayerTwo);
		
		GridPane.setConstraints(lblPlayerThree, 0, 2);
		GridPane.setConstraints(txtPlayerThree, 1, 2);
		GridPane.setConstraints(cmbPlayerThree, 2, 2);
		hideControls(3, lblPlayerThree, txtPlayerThree, cmbPlayerThree);
		
		GridPane.setConstraints(lblPlayerFour, 0, 3);
		GridPane.setConstraints(txtPlayerFour, 1, 3);
		GridPane.setConstraints(cmbPlayerFour, 2, 3);
		hideControls(4, lblPlayerFour, txtPlayerFour, cmbPlayerFour);
		
		choosePane.getChildren().addAll(lblPlayerOne, txtPlayerOne,
				cmbPlayerOne, lblPlayerTwo, txtPlayerTwo,
				cmbPlayerTwo, lblPlayerThree, txtPlayerThree,
				cmbPlayerThree, lblPlayerFour, txtPlayerFour,
				cmbPlayerFour);
		choosePane.setVgap(10);
		choosePane.setHgap(15);
		
		HBox buttonPane = new HBox();
		
		Button btnBack = new Button("Back");
		btnBack.setOnAction(e -> {
			Stage stage = (Stage) btnBack.getScene().getWindow();
			stage.setScene(MainGUI.getHowManyScene());
		});
		
		Button btnContinue = new Button("Continue");
		btnContinue.setOnAction(e -> {
			//boolean hasValidInput = false;
				
			setPlayerInformation(1, txtPlayerOne, cmbPlayerOne);
			setPlayerInformation(2, txtPlayerTwo, cmbPlayerTwo);
			setPlayerInformation(3, txtPlayerThree, cmbPlayerThree);
			setPlayerInformation(4, txtPlayerFour, cmbPlayerFour);
			
			Stage stage = (Stage) btnBack.getScene().getWindow();
			gamePlayScene = new Scene(GamePlayGUI.gamePlayScene(),
					Main.getWindowWidth(),
					Main.getWindowHeight());
			stage.setScene(gamePlayScene);
			
		});
		
		buttonPane.getChildren().addAll(btnBack, btnContinue);
		buttonPane.setSpacing(300);
		buttonPane.setAlignment(Pos.CENTER);
		
		infoPane.setPadding(new Insets(10, 10, 10, 10));
		infoPane.setAlignment(Pos.CENTER);
		infoPane.getChildren().addAll(lblMessage, choosePane,
				buttonPane);
		return infoPane;
	}
	
	/**
	 * This is used to hide the controls based on what players are active.
	 * The button in the previous scene determines this.
	 * @param playerID The id of the player that is not in play.
	 * @param lbl The inactive player's corresponding label.
	 * @param txt The inactive player's corresponding text field.
	 * @param cmb The inactive player's corresponding combo box.
	 */
	private static void hideControls(final int playerID, final Label lbl,
			final TextField txt, final ComboBox<String> cmb) {
		if (!Main.getGc().getSpecificPlayer(
				playerID).isInPlay()) {
			lbl.setVisible(false);
			txt.setVisible(false);
			cmb.setVisible(false);
		}
	}
	
	/**
	 * Changes the player's information based on what they put in the text
	 * field and what piece they selected in the combo box.
	 * @param playID The ID of the player.
	 * @param txt The text field tied to that player.
	 * @param cmb The combo box tied to that player.
	 */
	private static void setPlayerInformation(final int playID,
			final TextField txt, final ComboBox<String> cmb) {
		Main.getGc().getSpecificPlayer(playID).
			setPlayName(txt.getText());
		Main.getGc().getSpecificPlayer(playID).setPlayPieceID(
				Integer.parseInt(cmb.getSelectionModel().
						getSelectedItem()));
	}
	
}
