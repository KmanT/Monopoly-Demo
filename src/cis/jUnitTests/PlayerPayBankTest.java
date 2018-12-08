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

class PlayerPayBankTest {

	/**Test game controller.*/
	private GameController gc = new GameController();
	/**The test player.*/
	private Player p1 = new Player(1, true, 1);

	
	@Test
	void test() {
		gc.playerPayBank(p1, 500);
		int output = p1.getPlayBalance();
		int updateBank = gc.getBankFunds();
		assertEquals(output, 1000);
		assertEquals(updateBank, 21080);
	}

	@Test
	void test2() {
		gc.playerPayBank(p1, 1500);
		int output = p1.getPlayBalance();
		int updateBank = gc.getBankFunds();
		assertEquals(output, 0);
		assertEquals(updateBank, 22080);
	}
}
