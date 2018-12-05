package cis.monopoly.guiElements;

import java.io.IOException;
import java.util.List;

import cis.monopoly.Main;
import cis.monopoly.SoundPlayer;
import cis.monopoly.gameDrawers.HouseDrawer;
import cis.monopoly.gamePlay.Player;
import cis.monopoly.gamePlay.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**<h1>SellPropertyBox</h1>
 * This class defines the dialogue box when a player wants to upgrade their
 * house collection to a hotel for their property. It will display a table of
 * all the properties that can upgrade to a hotel in which the player must have
 * four houses on that property. The player must select the property they must
 * purchase. On the bottom, there are buttons to either buy the hotel or close
 * the window. When a property is selected and the user presses "Buy house"
 * the property's house count will go down to zero and the hasHotel attribute
 * for that property will be set to true. The table will update when the player
 * purchases a hotel for their property.
 * 
 * @author Kyle Turske
 * @version 0.9
 *
 */
public final class SellPropertyBox {
	
	/**
	 * Private constructor.
	 */
	private SellPropertyBox() {
		
	}
	
	/**
	 * The layout for the Buy Hotel Menu.
	 * @param p The current player who wants to purchase a hotel for their
	 * property.
	 * @param gc The graphics context that shows when houses are purchased on
	 * the board
	 */
	public static void display(final Player p, final GraphicsContext gc) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Sell properties. - " + p.getPlayName());
        
        Label lblText = new Label("Upgrade to a hotel for the properites with"
        		+ "four houses! properties!");
        
        ScrollPane tablePane = new ScrollPane();
        TableView<Property> tblProp = new TableView<>();
        tblProp.prefWidthProperty().setValue(410);
        
        TableColumn<Property, String> colPropName =
        		new TableColumn<>("Property");
        colPropName.setPrefWidth(200);
        colPropName.setCellValueFactory(
        		new PropertyValueFactory<Property, String>("spaceName"));
        
        TableColumn<Property, Integer> colPropVal =
        		new TableColumn<>("Property Value");
        colPropVal.setPrefWidth(100);
        colPropVal.setCellValueFactory(
        		new PropertyValueFactory<Property, Integer>("propPrice"));
        
        tblProp.setItems(getOwnedProperties(Main.getGc().getPropertyList(), p));
        tblProp.getColumns().addAll(colPropName, colPropVal);
        tblProp.getSelectionModel().selectFirst();
        
        tablePane.setContent(tblProp);
        
        Button btnSell = new Button("Sell Property");
        btnSell.setOnAction(e -> {
        	int searchID = 
        			tblProp.getSelectionModel().getSelectedItem().getSpaceID();
        	for (Property prop: Main.getGc().getPropertyList()) {
        		if (prop.getSpaceID() == searchID) {
        			Main.getGc().bankPayPlayer(p, prop.getHousePrice());
        			prop.setPropOwnerID(0);
        			prop.setPropPrice(prop.getPropPrice() * 2);
        			tblProp.refresh();
        			HouseDrawer.clearHouses(gc, prop);
        			try {
        				SoundPlayer.playWobble();
        			} catch (IOException el) {
        				
        			}
        			tblProp.getItems().remove(
        					tblProp.getSelectionModel().getSelectedItem());
        		}
        	}
        });
        
        Button btnDone = new Button("Done");
        btnDone.setOnAction(e -> {
        	window.close();
        });
        
        HBox buttonPane = new HBox();
        buttonPane.getChildren().addAll(btnSell, btnDone);
        
        VBox layout = new VBox();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(lblText, tablePane, buttonPane);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
	}
	
	/**
	 * Gets the list of all the properties owned by the player.
	 * @param list The property list from the GameController
	 * @param p The player selling properties
	 * @return An observable list used for the creation of the propTableView
	 */
	public static ObservableList<Property> getOwnedProperties(
			final List<Property> list, final Player p) {
		ObservableList<Property> propList =
				FXCollections.observableArrayList();
		
		for (Property prop: list) {
			if (prop.getpropOwnerID() == p.getPlayID()) {
				
				propList.add(prop);
										
			}
		}
		return propList;
	}
}
