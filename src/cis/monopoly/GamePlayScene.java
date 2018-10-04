package cis.monopoly;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuButton;



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
        topMenu.getMenus().addAll(menuFile, menuHelp, menuExit);
        menuPane.getChildren().add(topMenu);


        //PLAYER PANE//

        //BOARD PANE//
        boardPane.setPrefWidth(BoardDrawer.BOARD_LENGTH);
        boardPane.setPrefHeight(BoardDrawer.BOARD_LENGTH);

        Canvas canvas = new Canvas(BoardDrawer.BOARD_LENGTH, BoardDrawer.BOARD_LENGTH);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        BoardDrawer.drawBoard(gc);
        boardPane.getChildren().add(canvas);

        //gameScene = new Scene(gamePane);

        return gamePane;

    }

    public static Scene getGameScene() {
        return gameScene;
    }

}
