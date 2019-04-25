package be.vdab.extra;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Before;
import org.junit.Test;

import be.vdab.extra.RekeningNummerException;
import be.vdab.extra.Spaarrekening;

public class SpaarrekeningTest {
	private Spaarrekening rekening;
	private Spaarrekening rekening2;
	
	@Before
	public void before() {
		rekening=new Spaarrekening("BE68 1234 5678 9002", 1.5);
		
		//Testen constructor met reknr, intrest, saldo
		rekening2 = new Spaarrekening("BE68 1234 5678 9002", 1.5,1500);
	}
	

	
	@Test(expected=RekeningNummerException.class)
	public void verkeerdRekeningNummerMetIntrestMetsaldo() {
		new Spaarrekening("BE68 1234 5678 9003", 1.5, 1500);
	}
	
	@Test(expected=RekeningNummerException.class)
	public void verkeerdRekeningNummerMetIntrestMetNegatiefsaldo() {
		new Spaarrekening("BE68 1234 5678 9002", 1.5, -1500);
	}
		
	
	//Testen van method : checkIBANnummer(String reknr)
	
	
	
	@Test(expected=RekeningNummerException.class)
	public void verkeerdRekeningNummerFormaat() {
		new Spaarrekening("BEXX AAAA BBBB CCCC", 1.5);
	}

	@Test(expected=RekeningNummerException.class)
	public void nullRekeningNummer()  {
		new Spaarrekening(null, 1.5);
	}

	
	@Test(expected=RekeningNummerException.class)
	public void verkeerdBuitenlandseRekeningNummer()  {
		new Spaarrekening("FR68 1234 5678 9002", 1.5);
	}

	@Test(expected=RekeningNummerException.class)
	public void legeRekeningNummer()  {
		new Spaarrekening("", 1.5);
	}
	
	@Test(expected=RekeningNummerException.class)
	public void teLangeRekeningNummer()  {
		new Spaarrekening("BE68 1234 5678 90022", 1.5);
	}	
	
	
	@Test(expected=RekeningNummerException.class)
	public void verkeerdRekeningNummer()  {
		new Spaarrekening("BE68 1234 5678 9003", 1.5);
	}
	
	//Einde Testen van method : checkIBANnummer(String reknr)
	
	@Test(expected = RekeningNummerException.class)
	public void stortenMetNullKanNiet() {
		rekening.storten(-0.5);
	}
	
	
	
	
	@Test(expected = RekeningNummerException.class)
	public void meerAfhalenDanSaldo() {
		rekening.afhalen(5);
	}

	@Test(expected = RekeningNummerException.class)
	public void afhalenSaldoMoetPositiefZijn() {
		rekening2.afhalen(-5);
	}

	
	 // ToString
	@Test
	public void deToStringTesten() {
		assertEquals("BE68 1234 5678 9002, 1500.0, 1.5", rekening2.toString());
	}
     // getIntrest() testen : double terug -------> navragen "static way ???"

	@Test
	public void deGetIntrestTesten() {
		assertEquals(1.5, Spaarrekening.getIntrest(), 0.00);
	}

	// setIntrest() testen : moet positief zijn. 
	@Test(expected=RekeningNummerException.class)
	public void deSetIntrestTestenPosistief() {
		rekening2.setIntrest(-1.1);
	}
	
	// Equals() testen
	@Test
	public void equalsTestenGelijk() {
		assertEquals(rekening,rekening);
	}

	@Test
	public void equalsTestenNietGelijk() {
		assertEquals(rekening,rekening2);
	}

	
	// instanceof testen ==> lukt niet echt denkt ik
	@Test
	public void instanceofTesten() {
		String anderObject = "";
		assertNotEquals( rekening.getClass(), anderObject.getClass() );
	}

    // hashcode testen
	@Test
	public void hashCodeTesten() {
		
		assertEquals(rekening.hashCode(),336146735);
	}

}




