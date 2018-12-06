package cis.jUnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import cis.monopoly.gamePlay.Property;

/**
 * Tests the method addHouseCount from the Property Class.
 * @author Kyle Turske
 *
 */
class AddHouseCountTest extends Property {

	/**The test property.*/
	private Property prop = new Property();
	
	@Test
	void test1() {
		prop.addHouseCount();
		assertEquals(prop.getHouseCount(), 1);
	}
	
	@Test
	void test2() {
		prop.setHouseCount(4);
		prop.addHouseCount();
		assertEquals(prop.getHouseCount(), 4);
	}
	
	@Test
	void test3() {
		prop.setHouseCount(0);
		prop.setHasHotel(true);
		prop.addHouseCount();
		assertEquals(prop.getHouseCount(), 0);
	}

}
