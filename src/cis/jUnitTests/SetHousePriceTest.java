package cis.jUnitTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import cis.monopoly.gamePlay.Property;

/**
 * Tests the method setHousePrice in the Property class.
 * @author Kyle Turske
 *
 */
class SetHousePriceTest {
	
	Property prop = new Property();
	
	@Test
	void test1() {
		prop.setPropGroup(0);
		prop.setHousePrice();
		assertEquals(prop.getHousePrice(), 0);
	}
	
	@Test
	void test2() {
		prop.setPropGroup(1);
		prop.setHousePrice();
		assertEquals(prop.getHousePrice(), 50);
	}
	
	@Test
	void test3() {
		prop.setPropGroup(2);
		prop.setHousePrice();
		assertEquals(prop.getHousePrice(), 50);
	}
	
	@Test
	void test4() {
		prop.setPropGroup(3);
		prop.setHousePrice();
		assertEquals(prop.getHousePrice(), 100);
	}
	
	@Test
	void test5() {
		prop.setPropGroup(4);
		prop.setHousePrice();
		assertEquals(prop.getHousePrice(), 100);
	}
	
	@Test
	void test6() {
		prop.setPropGroup(5);
		prop.setHousePrice();
		assertEquals(prop.getHousePrice(), 150);
	}
	
	@Test
	void test7() {
		prop.setPropGroup(6);
		prop.setHousePrice();
		assertEquals(prop.getHousePrice(), 150);
	}
	
	@Test
	void test8() {
		prop.setPropGroup(7);
		prop.setHousePrice();
		assertEquals(prop.getHousePrice(), 200);
	}
	
	@Test
	void test9() {
		prop.setPropGroup(8);
		prop.setHousePrice();
		assertEquals(prop.getHousePrice(), 200);
	}
	
	@Test
	void test10() {
		prop.setPropGroup(9);
		prop.setHousePrice();
		assertEquals(prop.getHousePrice(), 0);
	}
	
	
	

}
