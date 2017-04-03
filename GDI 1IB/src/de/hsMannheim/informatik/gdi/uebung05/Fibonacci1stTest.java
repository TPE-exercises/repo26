package de.hsMannheim.informatik.gdi.uebung05;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Fibonacci1stTest {
	
	@Test
	public void folgeDerLängeEins() throws Exception {
		int[] array = Fibonacci.calculateFibonacci(1);
		
		assertEquals(1, array.length);
		assertEquals(0, array[0]);
	}

	
	@Test
	public void folgeDerLängeVier() throws Exception {
		int[] array = Fibonacci.calculateFibonacci(4);
		
		assertEquals(4, array.length);
		assertEquals(0, array[0]);
		assertEquals(1, array[1]);
		assertEquals(1, array[2]);
		assertEquals(2, array[3]);
	}
	
}