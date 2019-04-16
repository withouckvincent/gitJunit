package be.vdab.applicatie.domain;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before; //TEST FIXTURES EN @BEFORE
import org.junit.Test;

public class RekeningTest {

	// TEST FIXTURES EN @BEFORE

	private Rekening rekening;

	@Before
	public void before() {
		rekening = new Rekening();
	}

	@Test
	public void hetSaldoVanEenNieuweRekeningIsNul() {
		// Rekening rekening = new Rekening(); --> nvt doorTEST FIXTURES EN @BEFORE
		assertEquals(0, BigDecimal.ZERO.compareTo(rekening.getSaldo()));
	}

	@Test
	public void hetSaldoNaEenEersteStortingIsHetBedragVanDieStorting() {
		// Rekening rekening = new Rekening(); --> nvt doorTEST FIXTURES EN @BEFORE
		BigDecimal bedrag = BigDecimal.valueOf(2.5);
		rekening.stort(bedrag);
		assertEquals(0, bedrag.compareTo(rekening.getSaldo()));
	}

	@Test
	public void hetSaldoNaTweeStortingenIsDeSomVanDeBedragenVanDieStortingen() {
		// Rekening rekening = new Rekening(); --> nvt doorTEST FIXTURES EN @BEFORE
		rekening.stort(BigDecimal.valueOf(2.5));
		rekening.stort(BigDecimal.valueOf(1.2));
		assertEquals(0, BigDecimal.valueOf(3.7).compareTo(rekening.getSaldo()));
	}

}
