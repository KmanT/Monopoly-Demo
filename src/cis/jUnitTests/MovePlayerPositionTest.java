package cis.jUnitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import cis.monopoly.gamePlay.Player;

/**
 * This JUnit test tests the movePlayerPositionMethod in the Player class.
 * @author Kyle
 *
 */
class MovePlayerPositionTest {
	
	/**The test player*/
	Player p1 = new Player(1, true, 1);
	/**The length of the board*/
	int boardLength = 39;
	
	@Test
	void test1() {
		
		p1.movePlayerPosition(boardLength, 8);
		int output = p1.getPlayPosition();
		assertEquals(output, 8);
	}
	
	@Test
	void test2() {
		
		p1.setPlayPosition(39);
		p1.movePlayerPosition(boardLength, 1);
		int output = p1.getPlayPosition();
		assertEquals(output, 0);
	}
	
	@Test
	void test3() {
		p1.setPlayPosition(39);
		p1.movePlayerPosition(boardLength, 8);
		int output = p1.getPlayPosition();
		assertEquals(output, 7);
	}
	
	@Test
	void test4() {
		p1.setPlayPosition(39);
		p1.movePlayerPosition(boardLength, 8);
		int output = p1.getPlayPosition();
		assertEquals(output, 7);
	}

}
