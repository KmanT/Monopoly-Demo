package cis.monopoly.guiElements;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**<h1>PieceCellFactory</h1>
 * This is used to generate the different cells within the combo box used to 
 * select the player's piece. The combo box is inside the PlayerInfoGUI class.
 * 
 * @author Kyle Turske
 * @version 0.7
 *
 */
public class PieceCellFactory implements Callback<ListView<String>,
	ListCell<String>> {
	
	@Override
	public ListCell<String> call(final ListView<String> listview) {
		return new PieceCell();
	}

}

