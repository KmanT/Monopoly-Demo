package cis.monopoly.guiElements;


import cis.monopoly.Main;
import cis.monopoly.gameDrawers.BoardDrawer;
import cis.monopoly.gameDrawers.DiceDrawer;
import cis.monopoly.gamePlay.GameController;
import cis.monopoly.gamePlay.GameDice;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * <h1>gamePlayScene</h1>
 * This class defines all the different elements that go into the main game
 * window. This window contains a menu bar with different options, a pane
 * dedicated to all the player information, a pane that contains the dice and
 * the roll button, a bottom pane with miscellaneous information and actions,
 * and then of course, the board which changes whenever the player rolls the
 * dice.
 */
public class GamePlayScene {

	/**Stores the scene information.*/
    private static Scene gameScene;
    
    /**Holds all the panes necessary for game play.*/
    private BorderPane gamePane = new BorderPane();
    
    /**Contains the menu */
    private HBox menuPane = new HBox();
    
    /**Shows the player information.*/
    private GridPane playerPane = new GridPane();
    
    /**Contains the canvas for the board.*/
    private StackPane boardPane = new StackPane();
    
    /**Contains the canvas for the dice.*/
    private VBox dicePane = new VBox();
    
    /**Shows the bank information. Will contain buttons for players to trade or
     * sell their houses.*/
    private HBox statusPane = new HBox();
    
    /**Sets up the layout for the gamePlayScene.*/
    public BorderPane gamePlayScene() {
    	
        gamePane.setPrefWidth(Main.WINDOW_WIDTH_BIG);
        gamePane.setPrefHeight(Main.WINDOW_HEIGHT_BIG);
        gamePane.getStylesheets().add("cis/monopoly/style.css");

        gamePane.setTop(menuPane);
        gamePane.setLeft(playerPane);
        gamePane.setCenter(boardPane);
        gamePane.setRight(dicePane);
        gamePane.setBottom(statusPane);

        GameController gControl = new GameController();

        MenuBar topMenu = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem itmNewGame = new MenuItem("New Game");

        itmNewGame.setOnAction(e -> {
            Stage stage = (Stage) topMenu.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource(
                		"HowManyPlayers.fxml"));
                stage.setScene(new Scene(root, Main.WINDOW_WIDTH_BIG,
                		Main.WINDOW_HEIGHT_BIG));
            } catch (java.io.IOException el) {
                AlertBox.display("ioException",
                		"You have encountered an IO Exception");
            }
        });

        MenuItem itmLoadGame = new MenuItem("Load Game");
        MenuItem itmSaveGame = new MenuItem("Save Game");
        menuFile.getItems().addAll(itmNewGame, itmSaveGame, itmLoadGame);
        Menu menuHelp = new Menu("Help");
        Menu menuExit = new Menu("Exit");
        MenuItem itmMainMenu = new MenuItem("Exit to Main Menu");

        itmMainMenu.setOnAction(e -> {
            Stage stage = (Stage) topMenu.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource(
                		"MainMenu.fxml"));
                stage.setScene(new Scene(root, Main.WINDOW_WIDTH_BIG,
                		Main.WINDOW_HEIGHT_BIG));
            } catch (java.io.IOException el) {
                AlertBox.display("ioException",
                		"You have encountered an IO Exception");
            }
        });

        MenuItem itmClose = new MenuItem("Close Window");
        menuExit.getItems().addAll(itmMainMenu, itmClose);
        topMenu.getMenus().addAll(menuFile, menuHelp, menuExit);
        menuPane.getChildren().add(topMenu);


        //PLAYER PANE//
        Label lblPlayer1 = new Label("Player 1: $"
                + gControl.getSpecificPlayer(1).getPlayBalance());
        lblPlayer1.getStyleClass().add("lblPlayer");

        //Label lblPName1 = new Label();
        //lblPName1.getStyleClass().add("lblPlayer");

        Label lblPlayer2 = new Label("Player 2: $"
                + gControl.getSpecificPlayer(2).getPlayBalance());
        lblPlayer2.getStyleClass().add("lblPlayer");

        //Label lblPName2 = new Label();
        //lblPName2.getStyleClass().add("lblPlayer");

        Label lblPlayer3 = new Label("Player 3: $"
                + gControl.getSpecificPlayer(3).getPlayBalance());
        lblPlayer3.getStyleClass().add("lblPlayer");

        //Label lblPName3 = new Label();
        //lblPName3.getStyleClass().add("lblPlayer");

        Label lblPlayer4 = new Label("Player 4: "
                + gControl.getSpecificPlayer(4).getPlayBalance());
        lblPlayer4.getStyleClass().add("lblPlayer");

        //Label lblPName4 = new Label();
        //lblPName4.getStyleClass().add("lblPlayer");

        GridPane.setConstraints(lblPlayer1, 0, 0);
        //playerPane.setConstraints(lblPName1, 1, 0);
        GridPane.setConstraints(lblPlayer2, 0, 1);
        //playerPane.setConstraints(lblPName2, 1, 1);
        GridPane.setConstraints(lblPlayer3, 0, 2);
        //playerPane.setConstraints(lblPName3, 1, 2);
        GridPane.setConstraints(lblPlayer4, 0, 3);
        //playerPane.setConstraints(lblPName4, 1, 3);
        /*
        playerPane.getChildren().addAll(lblPlayer1, lblPName1,
                lblPlayer2, lblPName2, lblPlayer3,
                lblPName3, lblPlayer4, lblPName4);
        */

        playerPane.getChildren().addAll(lblPlayer1, lblPlayer2,
                lblPlayer3, lblPlayer4);

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
        Label lblBank = new Label("Bank: $" + gControl.getBankFunds());
        statusPane.getChildren().addAll(lblBank);

        //DICE PANE//
        Canvas cvsDice = new Canvas(DiceDrawer.DICE_BOWL_DIAMETER,
        		DiceDrawer.DICE_BOWL_DIAMETER);
        GraphicsContext gcDice = cvsDice.getGraphicsContext2D();
        DiceDrawer.drawDiceBowl(gcDice, 0, 0);

        Button btnRoll = new Button("ROLL!");

        btnRoll.setOnAction(e -> {
            //changes the number on the die
            updateDicePane(gControl.getDice(), gcDice);

            //moves the current player's position behind the scenes
            gControl.movePlayer(gControl.getCurrentPlayer(),
                    gControl.getDice().getTotalRoll());

            //prints the current player and their position to the console
            System.out.println(gControl.getCurrentPlayer().getPlayID()
            + "Position: " + gControl.getCurrentPlayer().getPlayPosition()
            + " Roll: " + gControl.getDice().getTotalRoll());

            //draws the player movement
            BoardDrawer.drawFullPlayerMove(gcBoard,
            		gControl.getCurrentPlayer().getPlayID(),
            		gControl.getCurrentPlayer().getPlayPosition(),
                    gControl.getDice().getTotalRoll(),
                    gControl.getCurrentPlayer().getPlayPieceID());
            
            gControl.spaceCheck();

            updateLabels(gControl, lblBank, lblPlayer1, lblPlayer2, lblPlayer3, 
            		lblPlayer4);
            gControl.changeCurrentPlayer();
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
    public static void updateDicePane(final GameDice dice,
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
    public static void updateLabels(final GameController gc, final Label bank,
    		final Label playerOne, final Label playerTwo,
    		final Label playerThree, final Label playerFour) {
    	bank.setText("Bank: $" + gc.getBankFunds());
        playerOne.setText("Player 1: $" 
        		+ gc.getSpecificPlayer(1).getPlayBalance());
        playerTwo.setText("Player 2: $" 
        		+ gc.getSpecificPlayer(2).getPlayBalance());
        playerThree.setText("Player 3: $" 
        		+ gc.getSpecificPlayer(3).getPlayBalance());
        playerFour.setText("Player 4: $" 
        		+ gc.getSpecificPlayer(4).getPlayBalance());
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
