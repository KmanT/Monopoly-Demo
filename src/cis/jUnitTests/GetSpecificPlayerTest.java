package cis.jUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cis.monopoly.gamePlay.GameController;
import cis.monopoly.gamePlay.Player;

/**
 * This JUnit test tests the movePlayerPositionMethod in the GameController 
 * class.
 * @author Kyle
 *
 */

class GetSpecificPlayerTest {

	/**Test game controller.*/
	private GameController gc = new GameController();
	/**The test player.*/
	private Player p1 = new Player(1, true, 1);
	
	
	@Test
	void test() {
		Player output = gc.getSpecificPlayer(1);
		assertEquals(output, p1);
	}

}
