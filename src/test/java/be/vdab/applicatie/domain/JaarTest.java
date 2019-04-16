package be.vdab.applicatie.domain;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class JaarTest {

	@Test
	public void eenJaarDeelbaarDoor400IsEenSchrikkeljaar() {
		Jaar jaar = new Jaar(2000);
		assertTrue(jaar.isSchrikkeljaar());
	}

	@Test
	public void eenJaarDeelbaarDoor100IsGeenSchrikkeljaar() {
		assertFalse(new Jaar(1900).isSchrikkeljaar());
	}

	@Test
	public void eenJaarDeelbaarDoor4IsEenSchrikkeljaar() {
		assertTrue(new Jaar(2012).isSchrikkeljaar());
	}

	@Test
	public void eenJaarNietDeelbaarDoor4IsGeenSchrikkeljaar() {
		assertFalse(new Jaar(2015).isSchrikkeljaar());
	
	}
	
	@Test
	public void equalsOpTweeDezelfdeJarenMoetTrueZijn() {
	assertEquals(new Jaar(2015), new Jaar(2015));
	}
	@Test
	public void equalsOpTweeVerschillendeJarenMoetFalseZijn() {
	assertNotEquals(new Jaar(2015), new Jaar(2016));
	}

	@Test
	public void hashCodeOpTweeDezelfdeJarenMoetGelijkZijn() {
	assertEquals(new Jaar(2015).hashCode(), new Jaar(2015).hashCode());
	}

}
