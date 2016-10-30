package de.hsMannheim.informatik.gdi.uebung04;

import static org.junit.Assert.*;

import org.junit.Test;

public class PerfectNumber1stTest {

	@Test
	public void oneToSix() throws Exception {
		assertFalse(PerfectNumber.isPerfectNumber(1));
		assertFalse(PerfectNumber.isPerfectNumber(2));
		assertFalse(PerfectNumber.isPerfectNumber(3));
		assertFalse(PerfectNumber.isPerfectNumber(4));
		assertFalse(PerfectNumber.isPerfectNumber(5));
		
		assertTrue(PerfectNumber.isPerfectNumber(6));
	}

}