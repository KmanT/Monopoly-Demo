package cis.monopoly;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    Stage windowMain;
    Scene mainMenuScene, gameScene;
    Label lblWelcome;
    Button btnStartGame, btnExit;


    public static void main(String[] args) { launch(args);   }

    @Override
    public void start(Stage primaryStage) {
        windowMain = primaryStage;
        windowMain.setTitle("GVSU Monopoly");
        windowMain.setMinHeight(800);
        windowMain.setMinWidth(800);

        lblWelcome = new Label("Welcome to GVSU Monopoly!");

        btnStartGame = new Button("Start Game");
        btnStartGame.setOnAction( e -> {
            try {

            } catch (Exception el){

            }
        });

        btnExit = new Button("Exit");
        btnExit.setOnAction( e -> {
            try {
                primaryStage.close();
            } catch (Exception el) {
                AlertBox.display("Error", "There was an error when Exiting.");
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10,10,10,10));
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(lblWelcome,btnStartGame,btnExit);
        mainMenuScene = new Scene(layout);
        windowMain.setScene(mainMenuScene);
        windowMain.show();
    }
}
