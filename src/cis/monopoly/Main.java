package cis.monopoly;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**<h1>Main</h1>
 * This is the main class that holds together the entire program. It will intialize
 * "MainMenu.fxml" and show the title along with two different options: "Start Game"
 * and "Exit"
 * @author Kyle Turske
 * @version 0.1
 */

public class Main extends Application{

    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 1000;

    public static void main(String[] args) { launch(args);   }

    @Override
    public void start(Stage primaryStage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
       primaryStage.setTitle("GVSU Monopoly");
       primaryStage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
       primaryStage.show();

       //test
       //JsonLoader.printPlayer();
    }
}
