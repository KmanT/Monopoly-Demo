package cis.monopoly.guiElements;

import java.util.List;

import cis.monopoly.Main;
import cis.monopoly.gamePlay.Player;
import cis.monopoly.gamePlay.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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

public final class BuyHouseBox {
	
	/**
	 * Private constructor.
	 */
	private BuyHouseBox() {
		
	}
	
	public static void display(Player p) {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Buy houses for property. - " + p.getPlayName());
        
        Label lblText = new Label("Buy up to four houses for your"
        		+ " properties!");
        
        ScrollPane tablePane = new ScrollPane();
        TableView<Property> tblProp = new TableView();
        tblProp.prefWidthProperty().setValue(310);
        
        TableColumn<Property, String> colPropName =
        		new TableColumn<>("Property");
        colPropName.setPrefWidth(200);
        colPropName.setCellValueFactory(
        		new PropertyValueFactory<Property, String>("spaceName"));
        
        TableColumn<Property, Integer> colHouseCount =
        		new TableColumn<>("House Count");
        colHouseCount.setPrefWidth(100);
        colHouseCount.setCellValueFactory(
        		new PropertyValueFactory<Property, Integer>("houseCount"));
        
        tblProp.setItems(getOwnedProperties(Main.getGc().getPropertyList(), p));
        tblProp.getColumns().addAll(colPropName, colHouseCount);
        tblProp.getSelectionModel().selectFirst();
        
        tablePane.setContent(tblProp);
        
        Button btnBuy = new Button("Buy House");
        btnBuy.setOnAction(e -> {
        	int searchID = 
        			tblProp.getSelectionModel().getSelectedItem().getSpaceID();
        	for (Property prop: Main.getGc().getPropertyList()) {
        		if (prop.getSpaceID() == searchID) {
        			prop.addHouseCount();
        			tblProp.refresh();
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
				
				if (prop.getHouseCount() < 4 && !prop.isHasHotel()) {
					propList.add(prop);
				}				
			}
		}
		return propList;
	}
}
