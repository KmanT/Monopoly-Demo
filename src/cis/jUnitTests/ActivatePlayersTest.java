package cis.jUnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import cis.monopoly.gamePlay.GameController;

class ActivatePlayersTest {
	
	GameController gc = new GameController();
	
	@Test
	void test1() {
		gc.activatePlayers(0);
		assertEquals(gc.getActivePlayerCount(), 0);
	}
	
	@Test
	void test2() {
		gc.activatePlayers(1);
		assertEquals(gc.getActivePlayerCount(), 1);
	}
	
	@Test
	void test3() {
		gc.activatePlayers(2);
		assertEquals(gc.getActivePlayerCount(), 2);
	}
	
	@Test
	void test4() {
		gc.activatePlayers(3);
		assertEquals(gc.getActivePlayerCount(), 3);
	}
	
	@Test
	void test5() {
		gc.activatePlayers(4);
		assertEquals(gc.getActivePlayerCount(), 4);
	}
	
	@Test
	void test6() {
		gc.activatePlayers(10);
		assertEquals(gc.getActivePlayerCount(), 4);
	}

}
