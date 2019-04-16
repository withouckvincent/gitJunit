package be.vdab.applicatie.domain;

public class Jaar {

	private final int jaar;

	public Jaar(int jaar) {
		this.jaar = jaar;
	}

	public boolean isSchrikkeljaar() {
		//Refactoring ==> Code verbeteren, optimaliseren, leesbaarder, beter aanpasbaar
		
//		if (jaar % 400 == 0) {
//			return true;
//		}
//		if (jaar % 100 == 0) {
//			return false;
//		}
//		return jaar % 4 == 0;
		
		return jaar % 4 == 0 && jaar % 100 != 0 || jaar % 400 == 0;
	}

}
