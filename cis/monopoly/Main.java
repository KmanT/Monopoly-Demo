package cis.monopoly;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**<h1>Main</h1>
 * This is the main class that holds together the entire program. It will
 * initialize "MainMenu.fxml" and show the title along with two different
 * options: "Start Game" and "Exit"
 * @author Kyle Turske
 * @version 0.5
 */
public class Main extends Application {

	//BIG WINDOW//
    /**Defines the width of the window if it is big.*/
    public static final int WINDOW_WIDTH_BIG = 1500;
    
    /**Defines the height of the window if it is big.*/
    public static final int WINDOW_HEIGHT_BIG = 1000;
    
    //SMALL WINDOW//
    /**Defines the width of the window if it is small.*/
    public static final int WINDOW_WIDTH_SMALL = 1000;
    /**Defines the height of the window if it is big.*/
    public static final int WINDOW_HEIGHT_SMALL = 750;
	
    
    /**
     * This is the main method which launches the JavaFX GUI.
     * @param args the array for runtime in Java
     */
    public static void main(final String[] args) {
        launch(args);
    }
    /**
     * This the start method which loads the primary stage, MainMenu.fxml.
     * Sets the window height to 1000px and the window width to 1200.
     * @param primaryStage The main stage of the window
     * @throws Exception Any exception regarding the stage entered
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
       Parent root = FXMLLoader.load(getClass().
               getResource("guiElements/MainMenu.fxml"));
       primaryStage.setTitle("GVSU Monopoly");
       primaryStage.setScene(new Scene(root, WINDOW_WIDTH_BIG, WINDOW_HEIGHT_BIG));
       primaryStage.show();

       //test
       //JsonLoader.printPlayer();
    }
}
