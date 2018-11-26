package cis.monopoly.guiElements;

import cis.monopoly.Main;
import cis.monopoly.gameDrawers.BoardDrawer;
import cis.monopoly.gameDrawers.DiceDrawer;
import cis.monopoly.gameDrawers.PieceDrawer;
import cis.monopoly.gamePlay.GameController;
import cis.monopoly.gamePlay.GameDice;
import cis.monopoly.gamePlay.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**<h1>GamePlayGUI</h1>
 * This class defines all the different elements that go into the main game
 * window. This window contains a menu bar with different options, a pane
 * dedicated to all the player information, a pane that contains the dice and
 * the roll button, a bottom pane with miscellaneous information and actions,
 * and then of course, the board which changes whenever the player rolls the
 * dice.
 * @author Kyle
 *
 */
public final class GamePlayGUI {

	/**Stores the scene information.*/
    private static Scene gameScene;
    
    /**Holds all the panes necessary for game play.*/
    private static BorderPane gamePane = new BorderPane();
    
    /**Contains the menu.*/
    private static HBox menuPane = new HBox();
    
    /**Shows the player information.*/
    private static GridPane playerPane = new GridPane();
    
    /**Contains the canvas for the board.*/
    private static StackPane boardPane = new StackPane();
    
    /**Contains the canvas for the dice.*/
    private static VBox dicePane = new VBox();
    
    /**Shows the bank information. Will contain buttons for players to trade or
     * sell their houses.*/
    private static HBox statusPane = new HBox();
    
    /**
	 * Private constructor.
	 */
    private GamePlayGUI() {
    	
    }
    
    /**
     * Sets up the layout for the gamePlayScene.
     * @return The game play layout
     */
    public static BorderPane gamePlayScene() {
    	
        gamePane.setPrefWidth(Main.WINDOW_WIDTH_BIG);
        gamePane.setPrefHeight(Main.WINDOW_HEIGHT_BIG);
        gamePane.getStylesheets().add(
        		"cis/monopoly/guiElements/main-style.css");

        gamePane.setTop(menuPane);
        gamePane.setLeft(playerPane);
        gamePane.setCenter(boardPane);
        gamePane.setRight(dicePane);
        gamePane.setBottom(statusPane);

        MenuBar topMenu = new MenuBar();
        topMenu.prefWidthProperty().bind(gamePane.widthProperty());
        Menu menuFile = new Menu("File");
        MenuItem itmNewGame = new MenuItem("New Game");

        itmNewGame.setOnAction(e -> {
        	Stage stage = (Stage) topMenu.getScene().getWindow();
        	stage.setScene(MainGUI.getHowManyScene());
        });

        MenuItem itmLoadGame = new MenuItem("Load Game");
        MenuItem itmSaveGame = new MenuItem("Save Game");
        menuFile.getItems().addAll(itmNewGame, itmSaveGame, itmLoadGame);
        Menu menuHelp = new Menu("Help");
        Menu menuExit = new Menu("Exit");
        MenuItem itmMainMenu = new MenuItem("Exit to Main Menu");

        itmMainMenu.setOnAction(e -> {
        	Stage stage = (Stage) topMenu.getScene().getWindow();
			stage.setScene(Main.getMainScene());
        });

        MenuItem itmClose = new MenuItem("Close Window");
        menuExit.getItems().addAll(itmMainMenu, itmClose);
        topMenu.getMenus().addAll(menuFile, menuHelp, menuExit);
        menuPane.getChildren().add(topMenu);

        //PLAYER PANE//
        Label lblPlayer1 = new Label(Main.getGc().getSpecificPlayer(1).
        		getPlayName() + " : $"
                + Main.getGc().getSpecificPlayer(1).getPlayBalance());
        lblPlayer1.getStyleClass().add("lblPlayer");

        Label lblPlayer2 = new Label(Main.getGc().getSpecificPlayer(2).
        		getPlayName() + " : $"
                + Main.getGc().getSpecificPlayer(2).getPlayBalance());
        lblPlayer2.getStyleClass().add("lblPlayer");

        Label lblPlayer3 = new Label(Main.getGc().getSpecificPlayer(3).
        		getPlayName() + " : $"
                + Main.getGc().getSpecificPlayer(3).getPlayBalance());
        lblPlayer3.getStyleClass().add("lblPlayer");

        Label lblPlayer4 = new Label(Main.getGc().getSpecificPlayer(4).
        		getPlayName() + " : $"
                + Main.getGc().getSpecificPlayer(4).getPlayBalance());
        lblPlayer4.getStyleClass().add("lblPlayer");

        GridPane.setConstraints(lblPlayer1, 0, 0);
        GridPane.setConstraints(lblPlayer2, 0, 1);
        GridPane.setConstraints(lblPlayer3, 0, 2);
        GridPane.setConstraints(lblPlayer4, 0, 3);

        playerPane.getChildren().addAll(lblPlayer1, lblPlayer2, lblPlayer3,
        		lblPlayer4);
        playerPane.setVgap(10);

        //BOARD PANE//        
        boardPane.setPrefWidth(BoardDrawer.BOARD_LENGTH_BIG);
        boardPane.setPrefHeight(BoardDrawer.BOARD_LENGTH_BIG);

        Canvas cvsBoard = new Canvas(BoardDrawer.BOARD_LENGTH_BIG,
        		BoardDrawer.BOARD_LENGTH_BIG);
        GraphicsContext gcBoard = cvsBoard.getGraphicsContext2D();

        BoardDrawer.drawBoard(gcBoard);
        boardPane.getChildren().add(cvsBoard);

        //STATUS PANE//
        Label lblBank = new Label("Bank: $" + Main.getGc().getBankFunds());
        
        Button btnBuyHouse = new Button("Buy Houses");        
        Button btnHotelUpgrade = new Button("Upgrade to Hotel");        
        Button btnTrade = new Button("Trade Property");        
        Button btnSell = new Button("Sell Property to Bank");
        statusPane.getChildren().addAll(lblBank, btnBuyHouse, btnHotelUpgrade,
        		btnTrade, btnSell);
        statusPane.setPadding(new Insets(10, 10, 10, 10));
        statusPane.setSpacing(10);

        //DICE PANE//
        Canvas cvsDice = new Canvas(DiceDrawer.DICE_BOWL_DIAMETER,
        		DiceDrawer.DICE_BOWL_DIAMETER);
        GraphicsContext gcDice = cvsDice.getGraphicsContext2D();
        DiceDrawer.drawDiceBowl(gcDice, 0, 0);
        Button btnRoll = new Button("ROLL!");

        btnRoll.setOnAction(e -> {
            //changes the number on the die
            updateDicePane(Main.getGc().getDice(), gcDice);

            //moves the current player's position behind the scenes
            Main.getGc().movePlayer(Main.getGc().getCurrentPlayer(),
                    Main.getGc().getDice().getTotalRoll());

            //prints the current player and their position to the console
            System.out.println(Main.getGc().getCurrentPlayer().getPlayID()
            + " Position: " + Main.getGc().getCurrentPlayer().getPlayPosition()
            + " Roll: " + Main.getGc().getDice().getTotalRoll());

            //draws the player movement
            executePlayerTurn(Main.getGc(), gcBoard,
            		Main.getGc().getCurrentPlayer(),
            		Main.getGc().getDice().getTotalRoll());
            
            updateLabels(Main.getGc(), lblBank, lblPlayer1, lblPlayer2,
            		lblPlayer3, lblPlayer4);
            Main.getGc().changeCurrentPlayer();
        });

        dicePane.getChildren().addAll(cvsDice, btnRoll);
        dicePane.setAlignment(Pos.TOP_CENTER);
        dicePane.setSpacing(10);
        return gamePane;
    }
    
    /**
     * Used to roll the dice in the GameController class as well as draw
     * the corresponding values to the Dice Canvas.
     * @param dice Used to get the rolls for die one and die two.
     * @param gc The graphics context connected to the dice canvas.
     */
    private static void updateDicePane(final GameDice dice,
    		final GraphicsContext gc) {
        dice.rollTwo();
        DiceDrawer.drawDie(gc, 50, 50, dice.getDieOne());
        DiceDrawer.drawDie(gc, 150, 150, dice.getDieTwo());
    }
    
    /**
     * Updates all of the labels relating to the players and the bank. Called
     * after each turn is executed.
     * @param gc The gameController to get the accounts from the players and
     * the bank
     * @param bank The label for the bank.
     * @param playerOne The label for player one.
     * @param playerTwo The label for player two.
     * @param playerThree The label for player three.
     * @param playerFour The label for player four.
     */
    private static void updateLabels(final GameController gc, final Label bank,
    		final Label playerOne, final Label playerTwo,
    		final Label playerThree, final Label playerFour) {
    	bank.setText("Bank: $" + gc.getBankFunds());
        
    	playerOne.setText(Main.getGc().getSpecificPlayer(1).getPlayName()
        		+ ": $" + gc.getSpecificPlayer(1).getPlayBalance());
        
    	playerTwo.setText(Main.getGc().getSpecificPlayer(2).getPlayName()
        		+ ": $" + gc.getSpecificPlayer(2).getPlayBalance());
        
    	playerThree.setText(Main.getGc().getSpecificPlayer(3).getPlayName()
        		+ ": $" + gc.getSpecificPlayer(3).getPlayBalance());
        
    	playerFour.setText(Main.getGc().getSpecificPlayer(4).getPlayName()
        		+ ": $" + gc.getSpecificPlayer(4).getPlayBalance());
    }
    
    /**
     * Shows the full player movement on the board, checks the condition of the
     * space the player has landed on and moves the player if the resulting
     * space causes the player to move again.
     * @param controller The GameController
     * @param gc The Graphics Context of the board
     * @param player The current player who is making the turn
     * @param roll The roll of the dice which shows the number of spaces the
     * player has moved.
     */
    private static void executePlayerTurn(final GameController controller,
    	final GraphicsContext gc, final Player player, final int roll) {
    	
    	PieceDrawer.drawFullPlayerMove(gc, player.getPlayID(),
    			player.getPlayPosition(), roll, player.getPlayPieceID());
            
            if (player.getPlayPosition() == 30) {
            	PieceDrawer.drawPlayerGoToJail(gc, player.getPlayID(), 
            			player.getPlayPosition(), player.getPlayPieceID());
            }
            
           controller.spaceCheck(roll);
            
            if (player.getPlayPosition() != controller.getSpaceCheckID()) {
            	PieceDrawer.drawPlayerSpaceMove(gc,	player.getPlayID(),
            			controller.getSpaceCheckID(), player.getPlayPosition(),
            			player.getPlayPieceID());
            }
    }

    /**
     * Used to return the gameScene so that the window can be changed to
     * this scene.
     * @return gameScene
     */
    public static Scene getGameScene() {
        return gameScene;
    }
}
