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

class EveryOnePayPlayerTest {

	/**Test game controller.*/
	private GameController gc = new GameController();
	/**The First test player.*/
	private Player p1 = new Player(1, true, 1);
	/**The Second test player.*/
	private Player p2 = new Player(1, true, 1);
	/**The Third test player.*/
	private Player p3 = new Player(1, true, 1);
	/**The Fourth test player.*/
	private Player p4 = new Player(1, true, 1);
	
	@Test
	void test() {
		gc.everyonePayPlayer(p1, 500);
		int output = p1.getPlayBalance();
		int p2output = p2.getPlayBalance();
		int p3output = p3.getPlayBalance();
		int p4output = p4.getPlayBalance();
		assertEquals(output, 3000);
		assertEquals(p2output, 1000);
		assertEquals(p3output, 1000);
		assertEquals(p4output, 1000);
	}

}
