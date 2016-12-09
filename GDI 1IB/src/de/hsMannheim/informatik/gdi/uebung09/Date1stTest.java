package de.hsMannheim.informatik.gdi.uebung09;

import static org.junit.Assert.*;

import gdi.MakeItSimple.GDIException;

import org.junit.Test;

public class Date1stTest {
	
	/*
	 * Konstruktor und Getter
	 */
	
	@Test(expected=GDIException.class)
	public void dayTooLarge() throws Exception {
		new DateImplementation(32, 1, 2001);
	}
	
	@Test
	public void validDates() {
		assertEquals(1, new DateImplementation(1, 2, 2003).getDay());
		assertEquals(2, new DateImplementation(1, 2, 2003).getMonth());
		assertEquals(2003, new DateImplementation(1, 2, 2003).getYear());
	}
	
	@Test(expected=GDIException.class)
	public void yearTooSmall() throws Exception {
		new DateImplementation(31, 12, 1599);
	}
	
	
	
	/*
	 * equals
	 */
	
	@Test
	public void equalDates() throws Exception {
		assertTrue(new DateImplementation(9, 12, 2016).equals(new DateImplementation(9, 12, 2016)));
	}
	
	@Test
	public void unqualDates() throws Exception {
		assertFalse(new DateImplementation(9, 12, 2016).equals(new DateImplementation(10, 12, 2016)));
	}
	
	
	
	/*
	 * laterThan
	 */
	
	@Test
	public void later() throws Exception {
		assertTrue(new DateImplementation(9, 12, 2016).laterThan(new DateImplementation(8, 12, 2016)));
	}
	
	@Test
	public void before() throws Exception {
		assertFalse(new DateImplementation(9, 12, 2016).laterThan(new DateImplementation(10, 12, 2016)));
	}
	
	
	
	/*
	 * add
	 */
	
	private void myAssertEquals(Date d1, Date d2) {
		if (!d1.equals(d2))
			throw new AssertionError("expected " + d1 + "; was " + d2);
	}
	
	@Test
	public void addPositiveNumber() throws Exception {
		myAssertEquals(new DateImplementation(10, 12, 2016), new DateImplementation(9, 12, 2016).add( 1));
	}
	
	@Test
	public void addNegativeNumber() throws Exception {
		myAssertEquals(new DateImplementation( 8, 12, 2016), new DateImplementation(9, 12, 2016).add(-1));
	}
	
	
	
	/*
	 * subtract
	 */
	
	@Test
	public void subtractEarlierFromLater() {
		assertEquals(1, new DateImplementation(9, 12, 2016).differenceInDays(new DateImplementation(10, 12, 2016)));
	}
	
	@Test
	public void subtractLaterFromEarlier() {
		assertEquals(1, new DateImplementation(9, 12, 2016).differenceInDays(new DateImplementation(8, 12, 2016)));
	}
	
	
	
	/*
	 * getWeekday
	 */
	
	@Test
	public void getWeekday() {
		assertEquals("getWeekday(9.12.2016)", Weekday.FRIDAY, new DateImplementation(9, 12, 2016).getWeekday());
	}
	
	
	
	/*
	 * toString
	 */
	
	@Test
	public void toStringTest() throws Exception {
		assertEquals("9.12.2016", new DateImplementation(9, 12, 2016).toString());
	}
	
}