package cis.jUnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

import cis.monopoly.gamePlay.GameController;
import cis.monopoly.gamePlay.Player;

/**
 * This JUnit test tests the movePlayerPositionMethod in the GameController 
 * class.
 * @author Kyle
 *
 */
class MovePlayerTest {
	
	/**Test game controller.*/
	private GameController gc = new GameController();
	/**The test player.*/
	private Player p1 = new Player(1, true, 1);
	
	@Test
	void test1() {
		gc.movePlayer(p1, 8);
		int output = p1.getPlayPosition();
		assertEquals(output, 8);
	}
	
	@Test
	void test2() {
		
		p1.setPlayPosition(39);
		gc.movePlayer(p1, 1);
		int output = p1.getPlayPosition();
		assertEquals(output, 0);
	}
	
	@Test
	void test3() {
		p1.setPlayPosition(39);
		gc.movePlayer(p1, 8);
		int output = p1.getPlayPosition();
		assertEquals(output, 7);
	}
	
	@Test
	void test4() {
		p1.setPlayPosition(33);
		gc.movePlayer(p1, 10);
		int output = p1.getPlayPosition();
		assertEquals(output, 3);
	}

}
