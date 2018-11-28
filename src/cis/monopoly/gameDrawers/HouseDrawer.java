package cis.monopoly.gameDrawers;

import cis.monopoly.gamePlay.Property;
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
	public void drawHouse(final GraphicsContext gc, final int xpos,
			final int ypos) {
		gc.setFill(Color.DARKGREEN);
        
        double[] xPoints = new double[] {xpos, xpos,  xpos + 10,
        		xpos + 20, xpos + 20};
        
        double[] yPoints = new double[] {ypos, ypos - 10, ypos - 20,
        		ypos -  10, ypos};
        
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
	public void drawHousesHorizontal(final GraphicsContext gc,
			final int xpos, final int ypos, final int num) {
		
		int xMover = 0;
		
		for (int i = 0; i < num; i++) {
			drawHouse(gc, xpos + xMover, ypos);
			
			xMover += 22;
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
	public void drawHousesVertical(final GraphicsContext gc, final int xpos,
			final int ypos, final int num) {
		
		int yMover = 0;
		
		for (int i = 0; i < num; i++) {
			drawHouse(gc, xpos, ypos + yMover);
			
			yMover += 22;
		}
		
	}
	
	/**
	 * Draws a single hotel on the board.
	 * @param gc The graphics context connected to the board canvas.
	 * @param xpos The horizontal location where the house will be drawn.
	 * @param ypos The vertical location where the house will be drawn.
	 */
	public void drawHotel(final GraphicsContext gc, final int xpos,
			final int ypos) {
		gc.setFill(Color.DARKRED);
        
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
	 * @param prop The property that contains the houses to draw
	 */
	public void drawHouseOnProperty(final GraphicsContext gc,
			final Property prop) {
		
		//BOTTOM ROW//
		
		//LEFT COLUMN//
		
		//TOP ROW//
		
		//RIGHT COLUMN//
		
		//IF ANYTHING ELSE//
		
	}

}
