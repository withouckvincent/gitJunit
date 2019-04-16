package be.vdab.applicatie.domain;

import java.math.BigDecimal;

public class Rekening {

	//private BigDecimal saldo = BigDecimal.valueOf(0);
	private BigDecimal saldo = BigDecimal.ZERO;
	
	public void stort(BigDecimal bedrag) {
		//throw new UnsupportedOperationException();
		
		// Exceptions !
		if (bedrag.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException("Bedrag moet positief zijn");
		}
		saldo = saldo.add(bedrag);
	}

	public BigDecimal getSaldo() {
		//throw new UnsupportedOperationException();
		return saldo;
	}

}
