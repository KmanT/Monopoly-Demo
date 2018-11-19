package cis.monopoly.guiElements;

import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;

/**<h1>PieceCell</h1>
 * Used inside of the combo boxes inside the PlayerInfoGUI class. Shows the
 * picture of the piece that the user selects for each of the players.
 * @author Kyle Turske
 * @version 0.7
 *
 */
public class PieceCell extends ListCell<String> {
	
	/**
	 * Used to create the cell with the image along with the piece number.
	 * @param pieceID the number for the piece. Each of the different
	 * pictures are stored with their number, so this is used to get the
	 * correct image for each pieceID.
	 * @param empty determines if the pieceID is empty.
	 */
	protected void updateItem(final String pieceID, final boolean empty) {
		super.updateItem(pieceID, empty);
		setGraphic(null);
		setText(null);
		if (pieceID != null) {
			try {
				ImageView iv = new ImageView(
					"cis/monopoly/images/piece"	
					+ pieceID + ".png");
				iv.setFitWidth(32);
				iv.setFitHeight(32);
				setGraphic(iv);
				setText(pieceID);
			} catch (Exception e) {
				System.out.println(System.err);
			}			
			
		}
	}
}
