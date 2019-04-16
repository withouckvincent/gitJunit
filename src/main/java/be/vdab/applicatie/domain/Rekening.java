package be.vdab.applicatie.domain;

import java.math.BigDecimal;

public class Rekening {

	//private BigDecimal saldo = BigDecimal.valueOf(0);
	private BigDecimal saldo = BigDecimal.ZERO;
	
	public void stort(BigDecimal bedrag) {
		//throw new UnsupportedOperationException();
		saldo = saldo.add(bedrag);
	}

	public BigDecimal getSaldo() {
		//throw new UnsupportedOperationException();
		return saldo;
	}

}
