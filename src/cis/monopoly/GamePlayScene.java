package cis.monopoly;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
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

        gamePane.setTop(menuPane);
        gamePane.setLeft(playerPane);
        gamePane.setCenter(boardPane);
        gamePane.setRight(dicePane);
        gamePane.setBottom(statusPane);

        //MENU PANE//
        MenuBar topMenu = new MenuBar();
        Menu menuFile = new Menu("File");
        MenuItem itmNewGame = new MenuItem("New Game");
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
        Label lblPlayer1 = new Label("Player 1: ");
        Label lblPName1 = new Label();
        Label lblPlayer2 = new Label("Player 2: ");
        Label lblPName2 = new Label();
        Label lblPlayer3 = new Label("Player 3: ");
        Label lblPName3 = new Label();
        Label lblPlayer4 = new Label("Player 4: ");
        Label lblPName4 = new Label();

        playerPane.setConstraints(lblPlayer1, 0, 0);
        playerPane.setConstraints(lblPName1, 1, 0);
        playerPane.setConstraints(lblPlayer2, 0, 1);
        playerPane.setConstraints(lblPName2, 1, 1);
        playerPane.setConstraints(lblPlayer3, 0, 2);
        playerPane.setConstraints(lblPName3, 1, 2);
        playerPane.setConstraints(lblPlayer4, 0, 3);
        playerPane.setConstraints(lblPName4, 1, 3);

        playerPane.getChildren().addAll(lblPlayer1, lblPName1,
                lblPlayer2, lblPName2, lblPlayer3,
                lblPName3, lblPlayer4, lblPName4);

        //BOARD PANE//
        boardPane.setPrefWidth(BoardDrawer.BOARD_LENGTH);
        boardPane.setPrefHeight(BoardDrawer.BOARD_LENGTH);

        Canvas cvsBoard = new Canvas(BoardDrawer.BOARD_LENGTH, BoardDrawer.BOARD_LENGTH);
        GraphicsContext gcBoard = cvsBoard.getGraphicsContext2D();

        BoardDrawer.drawBoard(gcBoard);
        boardPane.getChildren().add(cvsBoard);

        //DICE PANE//
        Canvas cvsDice = new Canvas(DiceDrawer.DICE_BOWL_DIAMETER, DiceDrawer.DICE_BOWL_DIAMETER);
        GraphicsContext gcDice = cvsDice.getGraphicsContext2D();
        DiceDrawer.drawDiceBowl(gcDice, 0, 0);

        Button btnRoll = new Button("ROLL!");

        //THIS DICE OBJECT IS NOT PERMANENT!//
        //JUST USED TO TEST DRAWER FUNCTIONALITY!!//

        GameDice dice = new GameDice();


        btnRoll.setOnAction( e -> {
            dice.rollTwo();
            DiceDrawer.drawDie(gcDice, 50, 50, dice.getDieOne());
            DiceDrawer.drawDie(gcDice, 150, 150, dice.getDieTwo());
        });

        dicePane.getChildren().addAll(cvsDice, btnRoll);
        dicePane.setAlignment(Pos.CENTER);


        return gamePane;


    }

    public static Scene getGameScene() {
        return gameScene;
    }

}
