package cis.jUnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import cis.monopoly.gamePlay.Property;

/**
 * Tests the method setHasHotel in the class Property.
 * @author Kyle Turske
 *
 */
class SetHasHotelTest {
	
	/**Property for testing.*/
	private Property prop = new Property();
	
	@Test
	void test1() {
		prop.setHasHotel();
		assertEquals(prop.isHasHotel(), false);
	}
	
	@Test
	void test2() {
		prop.setHouseCount(4);
		prop.setHasHotel();
		assertEquals(prop.isHasHotel(), true);
	}

}
