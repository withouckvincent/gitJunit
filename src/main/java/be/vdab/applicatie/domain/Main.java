package be.vdab.applicatie.domain;

import java.math.BigDecimal;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hallo");
		System.out.println(BigDecimal.valueOf(3).equals(BigDecimal.valueOf(1.5).add(BigDecimal.valueOf(1.5))));
		System.out.println(BigDecimal.valueOf(3.0).equals(BigDecimal.valueOf(1.5).add(BigDecimal.valueOf(1.5))));
		System.out.println(BigDecimal.valueOf(3).compareTo(BigDecimal.valueOf(1.5).add(BigDecimal.valueOf(1.5))));
	}

}
