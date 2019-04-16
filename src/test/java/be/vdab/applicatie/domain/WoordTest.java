package be.vdab.applicatie.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class WoordTest {


	@Test
	public void lepelIsEenPalindroom() {
		Woord woord = new Woord("lepel");
		assertTrue(woord.isPalindroom());
	}

	@Test
	public void vorkIsGeenPalindroom() {
		Woord woord = new Woord("vork");
		assertFalse(woord.isPalindroom());
	}

	@Test
	public void eenLegeStringIsEenPalindroom() {
		Woord woord = new Woord("");
		assertTrue(woord.isPalindroom());
	}

}
