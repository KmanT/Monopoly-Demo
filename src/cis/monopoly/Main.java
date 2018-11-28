package cis.monopoly;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import cis.monopoly.gamePlay.GameController;
import cis.monopoly.guiElements.MainGUI;

/**<h1>Main</h1>
 * This is the main class that holds together the entire program. It will
 * initialize the MainGUI class as well as the GameController.
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
    
    //ACTIVE WINDOW DIMENSIONS//
    /**What the program will actively use to get the width of the window. Will
     * change based on options.*/
    private static int windowWidth = WINDOW_WIDTH_BIG;
    /**What the program will actively use to get the height of the window. Will
     * change based on options.*/
    private static int windowHeight = WINDOW_HEIGHT_BIG;
	
	/**This is what controls all of the game play elements.*/
    private static GameController gc = new GameController();
    
    /**Used to returning to the main menu in the HowManyPlayersGUI class.*/
    private static Scene mainScene;

	/**
     * This is the main method which launches the entire program.
     * @param args the array for runtime in Java
     */
	public static void main(final String[] args) {
		launch(args);
	}
	
	/**
     * This the start method which loads the primary stage as well as the 
     * Game Controller.
     * @param primaryStage The main stage of the window
     * @throws Exception Any exception regarding the stage entered
     */
	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("GVSU Monopoly");
		primaryStage.setWidth(windowWidth);
		primaryStage.setHeight(windowHeight);
		mainScene = new Scene(MainGUI.mainScene(), windowWidth, windowHeight);
		primaryStage.setScene(mainScene);
		 primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
	            if (KeyCode.F11.equals(event.getCode())) {
	                primaryStage.setFullScreen(!primaryStage.isFullScreen());
	            }
	        });
		
		System.out.println(System.getProperty("user.dir"));
		primaryStage.show();
	}
	
	/**
	 * Gets the width of the window.
	 * @return windowWidth
	 */
	public static int getWindowWidth() {
		return windowWidth;
	}
	
	/**
	 * Gets the height of the window.
	 * @return windowHeight
	 */
	public static int getWindowHeight() {
		return windowHeight;
	}
	
	/**
	 * Gets the game controller from the Main class.
	 * @return The game controller
	 */
	public static GameController getGc() {
		return gc;
	}

	/**
	 * Gets the main menu layout.
	 * @return The main menu scene
	 */
	public static Scene getMainScene() {
		return mainScene;
	}	

}
