/**<h1>guiElements Package</h1>
 * This package includes all of the different classes for all of the classes
 * that create the UI for the program.
 */ 
package cis.monopoly.guiElements;

/**
 * <h2>MainGUIl</h2>
 * This is the class that defines the main menu. There is a label that
 * introduces the game, a button to start a new game, and a button to exit.
 * Accessed by the Controller class.
 * 
 * <h2>HowManyPlayersGUI</h2>
 * This is the class is used to define the menu to select the number of
 * players to play. The first button is player versus computer, the second is
 * two players, the third is for three players, and then the fourth activates
 * all four players.
 * 
 * <h2>PlayerInfoGUI</h2>
 * This is the class where the user can set the player's names and what piece
 * they use. The number of slots for selection will be determined by what
 * button the user clicked on in the previous scene.
 * 
 * <h2>PieceCell</h2>
 * Inside the PlayerInfoGUI class, there are combo boxes that allow the player
 * to select what piece they use. This is used to define the different buttons
 * inside the combo box.
 * 
 * <h2>PieceCellFactory</h2>
 * This is used to generate the PieceCells inside each of the different combo
 * boxes in the PlayerInfoGUI class.
 * 
 * <h2>ALertBox</h2>
 * This is used to inform the user of important information or if their is an
 * error that has occurred.
 * 
 * <h2>ConfirmBox</h2>
 * This is used for the player to make a decision. If they press yes, the
 * confirm box will return true, and if no then the confirm box will return
 * false.
 * 
 * <h2>ChanceBox</h2>
 * This class defines the dialogue box that pops up when a player lands on a
 * chance space. Gives the conditions of the card.
 * 
 * <h2>CommunityBox</h2>
 * This class defines the dialogue box that pops up when a player lands on a
 * community chest space. Gives the conditions of the card.
 * 
 * @version 0.6
 * @author Kyle Turske
 */
