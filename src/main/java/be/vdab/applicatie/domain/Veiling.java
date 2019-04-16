package be.vdab.applicatie.domain;

public class Veiling {
	
	private int hoogsteBod; 
	
	public void doeBod(int bedrag) {
		//throw new UnsupportedOperationException();
		if (bedrag > hoogsteBod) {
			hoogsteBod = bedrag;
		}
	}

	public int getHoogsteBod() {
		//throw new UnsupportedOperationException();
		return hoogsteBod;
	}

}
