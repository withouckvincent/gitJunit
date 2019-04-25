package be.vdab.extra;

public class RekeningNummerException extends RuntimeException { 
    
 
	private static final long serialVersionUID = 1L;
	private String foutRekeningNummer;
    
    public RekeningNummerException() {}
    
    public RekeningNummerException(String omschrijving) {
        super(omschrijving);
    }

    public RekeningNummerException(String omschrijving, String foutRekeningNummer) {
        super(omschrijving);
        this.foutRekeningNummer = foutRekeningNummer;
    }
    
    public String getFoutRekeningNummer() {
        return foutRekeningNummer;
    }
    
}