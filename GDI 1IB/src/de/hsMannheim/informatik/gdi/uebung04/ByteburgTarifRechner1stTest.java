package de.hsMannheim.informatik.gdi.uebung04;

import static org.junit.Assert.*;

import org.junit.Test;

public class ByteburgTarifRechner1stTest {

	@Test
	public final void normaleFahrt() {
		assertEquals("Fahrt von 11 nach 13: ", 2, ByteburgTarifRechner.ermittleFahrtkosten(11, 13));
	}

	@Test
	public final void ueberquereZonengrenze() {
		assertEquals("Fahrt von 11 nach 14: ", 3, ByteburgTarifRechner.ermittleFahrtkosten(11, 14));
	}

	@Test
	public final void benutzeEndstation() {
		assertEquals("Fahrt von 11 nach 16: ", 4, ByteburgTarifRechner.ermittleFahrtkosten(11, 16));
	}

	@Test
	public final void mittelstation() {
		assertEquals("Fahrt von 12 nach 00: ", 2, ByteburgTarifRechner.ermittleFahrtkosten(12, 00));
	}

	@Test
	public final void nachbarstationen() {
		assertEquals("Fahrt von 13 nach 14: ", 1, ByteburgTarifRechner.ermittleFahrtkosten(13, 14));
		assertEquals("Fahrt von 15 nach 16: ", 1, ByteburgTarifRechner.ermittleFahrtkosten(15, 16));
		assertEquals("Fahrt von 13 nach 23: ", 1, ByteburgTarifRechner.ermittleFahrtkosten(13, 23));
	}

}
