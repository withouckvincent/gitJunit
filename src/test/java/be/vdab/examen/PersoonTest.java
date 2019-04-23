package be.vdab.examen;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import be.vdab.examen.Persoon;

public class PersoonTest {
	private Persoon persoon;

	@Before
	public void before() {
		persoon = new Persoon();
		persoon.add("Vincent1");
		persoon.add("Vincent2");
	}

	@Test(expected = IllegalArgumentException.class)
	public void voornaamIsEenBlanco() {
		persoon.add(" ");
	}

	@Test(expected = IllegalArgumentException.class)
	public void voornaamIsLeeg() {
		persoon.add("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void geenDubbeleVoornamenToelaten() {
		persoon.add("Vincent1");
	}

	@Test
	public void deToStringTesten() {
		assertEquals("Vincent1 Vincent2", persoon.toString());
	}

	@Test
	public void fouteVolgorde() {
		assertNotEquals(persoon.toString(), "Vincent2 Vincent1");
	}
}
