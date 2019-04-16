package be.vdab.applicatie.domain;

public class Land {
	private final String landcode;
	private final int oppervlakte; // je maakt getters voor de private variabelen

	public Land(String landcode, int oppervlakte) {
		this.landcode = getLandcode();
		this.oppervlakte = getOppervlakte() ;
	}

	public String getLandcode() {
		return landcode;
	}

	public int getOppervlakte() {
		return oppervlakte;
	}
	
}
