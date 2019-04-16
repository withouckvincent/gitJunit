package be.vdab.applicatie.domain;

public class Woord {
	private final String woord;

	public Woord(String woord) {
		this.woord = woord;
	}

	public boolean isPalindroom() {
		String omgekeerdWoord = new StringBuilder(woord).reverse().toString();
		return woord.equals(omgekeerdWoord);
	}
}
