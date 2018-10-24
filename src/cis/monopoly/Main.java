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
 * @version 0.5
 */
public class Main extends Application{

    public static final int WINDOW_WIDTH = 1200;
    public static final int WINDOW_HEIGHT = 1000;

    /**
     * This is the main method which lauches the JavaFX GUI
     * @param args
     */
    public static void main(String[] args) { launch(args);   }

    /**
     * This the start method which loads the primary stage, MainMenu.fxml.
     * Sets the window height to 1000px and the window width to 1200
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("guiElements/MainMenu.fxml"));
       primaryStage.setTitle("GVSU Monopoly");
       primaryStage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
       primaryStage.show();

       //test
       //JsonLoader.printPlayer();
    }
}
