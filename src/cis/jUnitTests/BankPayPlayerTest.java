package cis.jUnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import cis.monopoly.gamePlay.GameController;
import cis.monopoly.gamePlay.Player;

/**
 * This JUnit test tests the bankPayPlayerMethod in the 
 * GameController class.
 * @author Kyle
 *
 */

class BankPayPlayerTest {
	

	/**Test game controller.*/
	private GameController gc = new GameController();
	/**The test player.*/
	private Player p1 = new Player(1, true, 1);
	
	@Test
	void test() {
		gc.bankPayPlayer(p1, 500);
		int output = p1.getPlayBalance();
		int updateBank = gc.getBankFunds();
		assertEquals(output, 2000);
		assertEquals(updateBank, 20080);
	}
	
	@Test
	void test2() {
		gc.bankPayPlayer(p1, 20580);
		int output = p1.getPlayBalance();
		int updateBank = gc.getBankFunds();
		assertEquals(output, 22080);
		assertEquals(updateBank, 0);
	}

}
