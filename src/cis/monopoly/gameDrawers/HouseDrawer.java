package cis.monopoly.gameDrawers;

import cis.monopoly.gamePlay.Property;
import cis.monopoly.guiElements.AlertBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**<h1>HouseDrawer</h1>
 * This class is responsible for drawing all of the houses and hotels on the
 * board once the player buys houses and hotels for their properties.
 * 
 * 
 * @author Kyle Turske
 * @version 0.6
 *
 */
public final class HouseDrawer {
	
	/**
	 * Private constructor.
	 */
	private HouseDrawer() {
		
	}
	
	/**
	 * Draws a single house on the board.
	 * @param gc The graphics context connected to the board canvas.
	 * @param xpos The horizontal location where the house will be drawn.
	 * @param ypos The vertical location where the house will be drawn.
	 */
	public static void drawHouse(final GraphicsContext gc, final int xpos,
			final int ypos) {
		gc.setFill(Color.GREEN);
        
        double[] xPoints = new double[] {xpos, xpos,  xpos + 7.5,
        		xpos + 15, xpos + 15};
        
        double[] yPoints = new double[] {ypos, ypos - 7.5, ypos - 12.5,
        		ypos -  7.5, ypos};
        
        int nPoints = 5;
        
        gc.fillPolygon(xPoints, yPoints, nPoints);
        gc.setStroke(Color.BLACK);
        gc.strokePolygon(xPoints, yPoints, nPoints);
	}
	
	/**
	 * Draws multiple houses on horizontal properties.
	 * @param gc The graphics context connected to the board canvas.
	 * @param xpos The horizontal location where the house will be drawn.
	 * @param ypos The vertical location where the house will be drawn.
	 * @param num The total number of houses drawn on the property.
	 * This must never go past three.
	 */
	public static void drawHousesHorizontal(final GraphicsContext gc,
			final int xpos, final int ypos, final int num) {
		int xMover = 0;
		for (int i = 0; i < num; i++) {
			drawHouse(gc, xpos + xMover, ypos);
			xMover += 16;
		}
	}
	
	/**
	 * Draws multiple houses on vertical properties.
	 * @param gc The graphics context connected to the board canvas.
	 * @param xpos The horizontal location where the house will be drawn.
	 * @param ypos The vertical location where the house will be drawn.
	 * @param num The total number of houses drawn on the property.
	 * This must never go past three.
	 */
	public static void drawHousesVertical(final GraphicsContext gc, final int xpos,
			final int ypos, final int num) {
		int yMover = 0;		
		for (int i = 0; i < num; i++) {
			drawHouse(gc, xpos, ypos + yMover);
			
			yMover += 15;
		}		
	}
	
	/**
	 * Draws a single hotel on the board.
	 * @param gc The graphics context connected to the board canvas.
	 * @param xpos The horizontal location where the house will be drawn.
	 * @param ypos The vertical location where the house will be drawn.
	 */
	public static void drawHotel(final GraphicsContext gc, final int xpos,
			final int ypos) {
		gc.setFill(Color.CRIMSON);
        final double[] xPoints = new double[] {xpos, xpos,  xpos + 13.75,
        		xpos + 27.5, xpos + 27.5};
        final double[] yPoints = new double[] {ypos, ypos - 12.5, ypos - 25,
        		ypos -  12.5, ypos};
        int nPoints = 5;
        gc.fillPolygon(xPoints, yPoints, nPoints);
        gc.setStroke(Color.BLACK);
        gc.strokePolygon(xPoints, yPoints, nPoints);
	}
	
	/**
	 * Draws the houses on a specific property based on the position requested.
	 * @param gc The graphics context for the board
	 * @param prop The property that contains the houses to draw. Will use the
	 * attributes spaceID and houseCount in order to count the houses
	 */
	public static void drawHouseOnProperty(final GraphicsContext gc,
			final Property prop) {
		int originX = 0;
		int originY = 0;
		
		if (prop.getSpaceID() >= 1 && prop.getSpaceID() <= 9) {
			originX = 704 - BoardDrawer.PROPERTY_WIDTH_BIG * prop.getSpaceID();
            originY = 730;
            drawHousesHorizontal(gc, originX + 1, originY - 7,
            		prop.getHouseCount());
		} else if (prop.getSpaceID() >= 11 && prop.getSpaceID() <= 19) {
			originX = 0;
            originY = 704 - BoardDrawer.PROPERTY_WIDTH_BIG
            		* (prop.getSpaceID() - 10);
            drawHousesVertical(gc, originX + 87, originY + 16,
            		prop.getHouseCount());
		} else if (prop.getSpaceID() >= 21 && prop.getSpaceID() <= 21) { //TOP//
			originX = 110 + BoardDrawer.PROPERTY_WIDTH_BIG
					* (prop.getSpaceID() - 21);
            originY = 107;
            drawHousesHorizontal(gc, originX + 1, originY - 7,
            		prop.getHouseCount());
		} else if (prop.getSpaceID() >= 31 && prop.getSpaceID() <= 39) {
			originX = 704;
            originY = 110 + BoardDrawer.PROPERTY_WIDTH_BIG
            		* (prop.getSpaceID() - 31);
            drawHousesVertical(gc, originX + 7, originY + 16,
            		prop.getHouseCount());
		} else {
			AlertBox.display("Space Error", "There was an error with the space"
					+ "you have entered. SpaceID out of range");
		}
		
	}
	
	/**
	 * Clears the flag for the top of the bottom properties.
	 * @param gc The graphics context of the board
	 * @param flagColor The property color
	 * @param xpos the horizontal position of the flag
	 * @param ypos the vertical position of the flag
	 */
	public static void clearFlagBottom(final GraphicsContext gc,
			final Color flagColor, final int xpos, final int ypos) {
		gc.setStroke(Color.BLACK);
        gc.setFill(flagColor);
        gc.fillRect(xpos, ypos, BoardDrawer.PROPERTY_WIDTH_BIG,
        		BoardDrawer.PROPERTY_FLAG_HEIGHT_BIG);
        gc.strokeRect(xpos, ypos, BoardDrawer.PROPERTY_WIDTH_BIG,
        		BoardDrawer.PROPERTY_HEIGHT_BIG);
	}
	
	/**
	 * Clears the flag for the top of the left properties.
	 * @param gc The graphics context of the board
	 * @param flagColor The property color
	 * @param xpos the horizontal position of the flag
	 * @param ypos the vertical position of the flag
	 */
	public static void clearFlagLeft(final GraphicsContext gc,
			final Color flagColor, final int xpos, final int ypos) {
		gc.setStroke(Color.BLACK);
        gc.setFill(flagColor);
        gc.fillRect(xpos + 80, ypos,
        		BoardDrawer.PROPERTY_FLAG_HEIGHT_BIG,
        		BoardDrawer.PROPERTY_WIDTH_BIG);
        gc.strokeRect(xpos, ypos,
        		BoardDrawer.PROPERTY_HEIGHT_BIG,
        		BoardDrawer.PROPERTY_WIDTH_BIG);
	}
	
	/**
	 * Clears the flag for the top of the top properties.
	 * @param gc The graphics context of the board
	 * @param flagColor The property color
	 * @param xpos the horizontal position of the flag
	 * @param ypos the vertical position of the flag
	 */
	public static void clearFlagTop(final GraphicsContext gc,
			final Color flagColor, final int xpos, final int ypos) {
		gc.setStroke(Color.BLACK);
        gc.setFill(flagColor);
        
        gc.fillRect(xpos, ypos + 80, BoardDrawer.PROPERTY_WIDTH_BIG,
        		BoardDrawer.PROPERTY_FLAG_HEIGHT_BIG);
        gc.strokeRect(xpos, ypos, BoardDrawer.PROPERTY_WIDTH_BIG,
        		BoardDrawer.PROPERTY_HEIGHT_BIG);
	}
	
	/**
	 * Clears the flag for the top of the top bottom.
	 * @param gc The graphics context of the board
	 * @param flagColor The property color
	 * @param xpos the horizontal position of the flag
	 * @param ypos the vertical position of the flag
	 */
	public static void clearFlagRight(final GraphicsContext gc,
			final Color flagColor, final int xpos, final int ypos) {
		gc.setStroke(Color.BLACK);
        gc.setFill(flagColor);
        gc.fillRect(xpos, ypos, BoardDrawer.PROPERTY_FLAG_HEIGHT_BIG,
        		BoardDrawer.PROPERTY_WIDTH_BIG);
        gc.strokeRect(xpos, ypos, BoardDrawer.PROPERTY_HEIGHT_BIG,
        		BoardDrawer.PROPERTY_WIDTH_BIG);
	}
	
	/**
	 * Draws a hotel on a specific property based on the position requested.
	 * @param gc The graphics context for the board
	 * @param prop The property that contains the houses to draw. Will use the
	 * attributes spaceID and houseCount in order to count the houses
	 */
	public static void drawHotelOnProperty(final GraphicsContext gc,
			final Property prop) {
		int originX = 0;
		int originY = 0;
		
		if (prop.getSpaceID() >= 1 && prop.getSpaceID() <= 9) {
			originX = 704 - BoardDrawer.PROPERTY_WIDTH_BIG * prop.getSpaceID();
            originY = 704;
            
            clearFlagBottom(gc, prop.getPropColor(), originX, originY);
            drawHotel(gc, originX + 18, originY + 29);
            
            
		} else if (prop.getSpaceID() >= 11 && prop.getSpaceID() <= 19) {
			originX = 0;
            originY = 704 - BoardDrawer.PROPERTY_WIDTH_BIG
            		* (prop.getSpaceID() - 10);
            
            clearFlagLeft(gc, prop.getPropColor(), originX, originY);
            drawHotel(gc, originX + 81, originY + 40);
            
		} else if (prop.getSpaceID() >= 21 && prop.getSpaceID() <= 21) {
			originX = 110 + BoardDrawer.PROPERTY_WIDTH_BIG
					* (prop.getSpaceID() - 21);
            originY = 0;
            
            clearFlagTop(gc, prop.getPropColor(), originX, originY);
            drawHotel(gc, originX + 18, originY + 109);
            
		} else if (prop.getSpaceID() >= 31 && prop.getSpaceID() <= 39) {
			originX = 704;
            originY = 110 + BoardDrawer.PROPERTY_WIDTH_BIG
            		* (prop.getSpaceID() - 31);
            
            clearFlagRight(gc, prop.getPropColor(), originX, originY);
            drawHotel(gc, originX + 1, originY + 40);
            
		} else {
			AlertBox.display("Space Error", "There was an error with the space"
					+ "you have entered. SpaceID out of range");
		}
	}
	
	/**
	 * This clears all of the houses or hotels that are on property. Used by
	 * the sell house box.
	 * @param gc The Graphics Context tied to the board.
	 * @param prop The property where the houses are being removed
	 */
	public static void clearHouses(final GraphicsContext gc,
			final Property prop) {
		int originX = 0;
		int originY = 0;
		
		if (prop.getSpaceID() >= 1 && prop.getSpaceID() <= 9) {
			originX = 704 - BoardDrawer.PROPERTY_WIDTH_BIG * prop.getSpaceID();
            originY = 704;
            
            clearFlagBottom(gc, prop.getPropColor(), originX, originY);
            
		} else if (prop.getSpaceID() >= 11 && prop.getSpaceID() <= 19) {
			originX = 0;
            originY = 704 - BoardDrawer.PROPERTY_WIDTH_BIG
            		* (prop.getSpaceID() - 10);
            
            clearFlagLeft(gc, prop.getPropColor(), originX, originY);
            
		} else if (prop.getSpaceID() >= 21 && prop.getSpaceID() <= 21) {
			originX = 110 + BoardDrawer.PROPERTY_WIDTH_BIG
					* (prop.getSpaceID() - 21);
            originY = 0;
            
            clearFlagTop(gc, prop.getPropColor(), originX, originY);
            
            
		} else if (prop.getSpaceID() >= 31 && prop.getSpaceID() <= 39) {
			originX = 704;
            originY = 110 + BoardDrawer.PROPERTY_WIDTH_BIG
            		* (prop.getSpaceID() - 31);
            
            clearFlagRight(gc, prop.getPropColor(), originX, originY);
            
            
		} else {
			AlertBox.display("Space Error", "There was an error with the space"
					+ "you have entered. SpaceID out of range");
		}
	}

}
