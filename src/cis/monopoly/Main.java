package cis.monopoly;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the main class that holds together the entire program/
 * @author Kyle Turske
 * @version 0.1
 */

public class Main extends Application{


    public static void main(String[] args) { launch(args);   }

    @Override
    public void start(Stage primaryStage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
       primaryStage.setTitle("GVSU Monopoly");
       primaryStage.setScene(new Scene(root, 1200, 800));
       primaryStage.show();
    }
}
