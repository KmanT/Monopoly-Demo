package cis.monopoly;

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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class GamePlayScene {

    private static Scene gameScene;

    private BorderPane gamePane = new BorderPane();
    //top
    private HBox menuPane = new HBox();
    //left
    private GridPane playerPane = new GridPane();
    //center
    private VBox boardPane = new VBox();
    //right
    private VBox dicePane = new VBox();
    //bottom
    private HBox statusPane = new HBox();

    public BorderPane GamePlayScene() {

        gamePane.setPrefWidth(Main.WINDOW_WIDTH);
        gamePane.setPrefHeight(Main.WINDOW_HEIGHT);
        gamePane.getStylesheets().add("cis/monopoly/style.css");

        gamePane.setTop(menuPane);
        gamePane.setLeft(playerPane);
        gamePane.setCenter(boardPane);
        gamePane.setRight(dicePane);
        gamePane.setBottom(statusPane);

        GameController gControl = new GameController();

        //MENU PANE//
        MenuBar topMenu = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem itmNewGame = new MenuItem("New Game");

        itmNewGame.setOnAction( e -> {
            Stage stage = (Stage) topMenu.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource
                        ("HowManyPlayers.fxml"));
                stage.setScene(new Scene(root, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
            } catch (java.io.IOException el) {
                AlertBox ioAlert = new AlertBox();
                ioAlert.display("ioException", "You have encountered an IO Exception");
            }
        });


        MenuItem itmLoadGame = new MenuItem("Load Game");
        MenuItem itmSaveGame = new MenuItem("Save Game");
        menuFile.getItems().addAll(itmNewGame, itmSaveGame, itmLoadGame);
        Menu menuHelp = new Menu("Help");
        Menu menuExit = new Menu("Exit");
        MenuItem itmMainMenu = new MenuItem("Exit to Main Menu");

        itmMainMenu.setOnAction( e -> {
            Stage stage = (Stage) topMenu.getScene().getWindow();
            try {
                Parent root = FXMLLoader.load(getClass().getResource
                        ("MainMenu.fxml"));
                stage.setScene(new Scene(root, Main.WINDOW_WIDTH, Main.WINDOW_HEIGHT));
            } catch (java.io.IOException el) {
                AlertBox ioAlert = new AlertBox();
                ioAlert.display("ioException", "You have encountered an IO Exception");
            }
        });

        MenuItem itmClose = new MenuItem("Close Window");
        menuExit.getItems().addAll(itmMainMenu, itmClose);
        topMenu.getMenus().addAll(menuFile, menuHelp, menuExit);
        menuPane.getChildren().add(topMenu);


        //PLAYER PANE//
        Label lblPlayer1 = new Label("Player 1: $"
                + gControl.getPlayer1().getPlayBalance());
        lblPlayer1.getStyleClass().add("lblPlayer");

        //Label lblPName1 = new Label();
        //lblPName1.getStyleClass().add("lblPlayer");

        Label lblPlayer2 = new Label("Player 2: $"
                + gControl.getPlayer2().getPlayBalance());
        lblPlayer2.getStyleClass().add("lblPlayer");

        //Label lblPName2 = new Label();
        //lblPName2.getStyleClass().add("lblPlayer");

        Label lblPlayer3 = new Label("Player 3: $"
                + gControl.getPlayer3().getPlayBalance());
        lblPlayer3.getStyleClass().add("lblPlayer");

        //Label lblPName3 = new Label();
        //lblPName3.getStyleClass().add("lblPlayer");

        Label lblPlayer4 = new Label("Player 4: "
                + gControl.getPlayer4().getPlayBalance());
        lblPlayer4.getStyleClass().add("lblPlayer");

        //Label lblPName4 = new Label();
        //lblPName4.getStyleClass().add("lblPlayer");

        playerPane.setConstraints(lblPlayer1, 0, 0);
        //playerPane.setConstraints(lblPName1, 1, 0);
        playerPane.setConstraints(lblPlayer2, 0, 1);
        //playerPane.setConstraints(lblPName2, 1, 1);
        playerPane.setConstraints(lblPlayer3, 0, 2);
        //playerPane.setConstraints(lblPName3, 1, 2);
        playerPane.setConstraints(lblPlayer4, 0, 3);
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
        boardPane.setPrefWidth(BoardDrawer.BOARD_LENGTH);
        boardPane.setPrefHeight(BoardDrawer.BOARD_LENGTH);

        Canvas cvsBoard = new Canvas(BoardDrawer.BOARD_LENGTH, BoardDrawer.BOARD_LENGTH);
        GraphicsContext gcBoard = cvsBoard.getGraphicsContext2D();

        BoardDrawer.drawBoard(gcBoard);
        boardPane.getChildren().add(cvsBoard);

        //STATUS PANE//
        Label lblBank = new Label("Bank: $" + gControl.getBankFunds());
        statusPane.getChildren().addAll(lblBank);

        //DICE PANE//
        Canvas cvsDice = new Canvas(DiceDrawer.DICE_BOWL_DIAMETER, DiceDrawer.DICE_BOWL_DIAMETER);
        GraphicsContext gcDice = cvsDice.getGraphicsContext2D();
        DiceDrawer.drawDiceBowl(gcDice, 0, 0);

        Button btnRoll = new Button("ROLL!");

        btnRoll.setOnAction( e -> {
            updateDicePane(gControl.getDice(), gcDice);

            gControl.movePlayer(gControl.getCurrentPlayer(),
                    gControl.getDice().getTotalRoll());
            System.out.println(gControl.getCurrentPlayer().getPlayID()
            + ": " + gControl.getCurrentPlayer().getPlayPosition());
            BoardDrawer.drawFullPlayerMove(gcBoard, gControl.getCurrentPlayer().getPlayID(),
                    gControl.getCurrentPlayer().getPlayPosition(),
                    gControl.getDice().getTotalRoll(), gControl.getCurrentPlayer().getPlayPieceID());

            lblBank.setText("Bank: $" + gControl.getBankFunds());
            lblPlayer1.setText("Player 1: $" +
                    gControl.getPlayer1().getPlayBalance());
            lblPlayer2.setText("Player 2: $" +
                    gControl.getPlayer2().getPlayBalance());
            lblPlayer3.setText("Player 3: $" +
                    gControl.getPlayer3().getPlayBalance());
            lblPlayer4.setText("Player 4: $" +
                    gControl.getPlayer4().getPlayBalance());

            gControl.changeCurrentPlayer();
        });

        dicePane.getChildren().addAll(cvsDice, btnRoll);
        dicePane.setAlignment(Pos.TOP_CENTER);
        dicePane.setSpacing(10);



        return gamePane;
    }

    public static void updateDicePane(GameDice dice, GraphicsContext gc) {
        dice.rollTwo();
        DiceDrawer.drawDie(gc, 50, 50, dice.getDieOne());
        DiceDrawer.drawDie(gc, 150, 150, dice.getDieTwo());
    }

    public static Scene getGameScene() {
        return gameScene;
    }

}
