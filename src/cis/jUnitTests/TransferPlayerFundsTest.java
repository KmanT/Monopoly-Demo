package cis.jUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import cis.monopoly.gamePlay.GameController;
import cis.monopoly.gamePlay.Player;

/**
 * This JUnit test tests the transferPlayerFundsMethod in the GameController 
 * class.
 * @author Kyle
 *
 */

class TransferPlayerFundsTest {
	
	/**Test game controller.*/
	private GameController gc = new GameController();
	/**The first test player.*/
	private Player p1 = new Player(1, true, 1);
	/**The second test player.*/
	private Player p2 = new Player (1, true, 1);
	
	@Test
	void test() {
		gc.transferPlayerFunds(p1, p2, 500);
		int p1output = p1.getPlayBalance();
		int p2output = p2.getPlayBalance();
		assertEquals(p1output, 1000);
		assertEquals(p2output, 2000);
	}

	@Test
	void test2() {
		gc.transferPlayerFunds(p1, p2, 1500);
		int p1output = p1.getPlayBalance();
		int p2output = p2.getPlayBalance();
		assertEquals(p1output, 0);
		assertEquals(p2output, 3000);
	}
	
}
