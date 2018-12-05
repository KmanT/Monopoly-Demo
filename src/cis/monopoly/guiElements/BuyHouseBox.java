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

/**<h1>BuyHouseBox</h1>
 * This class defines the dialogue box when a player wants to purchase a house
 * for their property. It will display a table of all the properties that can
 * have houses, have less than four houses, and don't have a hotel. The player
 * must select the property they must purchase. On the bottom, there are
 * buttons to either buy the house or close the window. When a property is
 * selected and the user presses "Buy house" the property's house count
 * increases by one. The table will update when the player purchases a house
 * for their property.
 * 
 * @author Kyle Turske
 * @version 0.8
 *
 */
public final class BuyHouseBox {
	
	/**
	 * Private constructor.
	 */
	private BuyHouseBox() {
		
	}
	
	/**
	 * The layout for the Buy House Menu.
	 * @param p The current player who wants to purchase a house for their
	 * property.
	 * @param gc The graphics context that shows when houses are purchased on
	 * the board
	 */
	public static void display(final Player p, final GraphicsContext gc) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Buy houses for property. - " + p.getPlayName());
        
        Label lblText = new Label("Buy up to four houses for your"
        		+ " properties!");
        
        ScrollPane tablePane = new ScrollPane();
        TableView<Property> tblProp = new TableView<>();
        tblProp.prefWidthProperty().setValue(410);
        
        TableColumn<Property, String> colPropName =
        		new TableColumn<>("Property");
        colPropName.setPrefWidth(200);
        colPropName.setCellValueFactory(
        		new PropertyValueFactory<Property, String>("spaceName"));
        
        TableColumn<Property, Integer> colHousePrice =
        		new TableColumn<>("House Price");
        colHousePrice.setPrefWidth(100);
        colHousePrice.setCellValueFactory(
        		new PropertyValueFactory<Property, Integer>("housePrice"));
        
        TableColumn<Property, Integer> colHouseCount =
        		new TableColumn<>("House Count");
        colHouseCount.setPrefWidth(100);
        colHouseCount.setCellValueFactory(
        		new PropertyValueFactory<Property, Integer>("houseCount"));
        
        tblProp.setItems(getOwnedProperties(Main.getGc().getPropertyList(), p));
        tblProp.getColumns().addAll(colPropName, colHousePrice, colHouseCount);
        tblProp.getSelectionModel().selectFirst();
        
        tablePane.setContent(tblProp);
        
        Button btnBuy = new Button("Buy House");
        btnBuy.setOnAction(e -> {
        	int searchID = 
        			tblProp.getSelectionModel().getSelectedItem().getSpaceID();
        	for (Property prop: Main.getGc().getPropertyList()) {
        		if (prop.getSpaceID() == searchID) {        			
        			if (prop.getHouseCount() < 4 && !prop.isHasHotel()) {
        				try {
            				SoundPlayer.playDing();
            			} catch (IOException el) {
            				
            			}
        				Main.getGc().playerPayBank(p, prop.getHousePrice());
        				prop.addHouseCount();
        				tblProp.refresh();
            			HouseDrawer.drawHouseOnProperty(gc, prop);
        			} else if (prop.getHouseCount() >= 4) {
        				AlertBox.display("Property has max houses.",
        						"The maximum number of houses has already been"
        						+ " met. You cannot buy more for this"
        						+ "property.");
        			} else if (prop.isHasHotel()) {
        				AlertBox.display("Property has hotel.", "You cannot"
        						+ "add a house to a property that has a"
        						+ " hotel.");
        			}  			
        			
        		}
        	}
        });
        
        Button btnDone = new Button("Done");
        btnDone.setOnAction(e -> {
        	window.close();
        });
        
        HBox buttonPane = new HBox();
        buttonPane.getChildren().addAll(btnBuy, btnDone);
        
        VBox layout = new VBox();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().addAll(lblText, tablePane, buttonPane);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
	}
	
	/**
	 * Gets the list of properties owned by the player that have less than
	 * three houses and no hotel.
	 * @param list The property list from the GameController
	 * @param p The player buying houses
	 * @return An observable list used for the creation of the propTableView
	 */
	public static ObservableList<Property> getOwnedProperties(
			final List<Property> list, final Player p) {
		ObservableList<Property> propList =
				FXCollections.observableArrayList();
		
		for (Property prop: list) {
			if (prop.getpropOwnerID() == p.getPlayID()) {
				
				if (prop.getPropGroup() != 9 || prop.getPropGroup() != 10) {
					
					if (prop.getHouseCount() < 4 && !prop.isHasHotel()) {
						propList.add(prop);
					}	
				}							
			}
		}
		return propList;
	}
}
