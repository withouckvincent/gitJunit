package be.vdab.extra;


import be.vdab.extra.RekeningNummerException;

/**
 *
 * @author Vincent Media
 */
public class Zichtrekening extends Rekening {
// Members    
    private int maxKrediet;
    
    private static final double INTREST_ZICHTREKENING = 0.25;
    
//Methods    

    
public Zichtrekening(String rekeningNummer,int bedrag) throws RekeningNummerException {
    super(rekeningNummer);
    setMaxKrediet(bedrag);
}
public Zichtrekening(String rekeningNummer, double saldo, int bedrag) throws RekeningNummerException {
    super(rekeningNummer, saldo);
    setMaxKrediet(bedrag);
}
public final void setMaxKrediet(int maxKrediet) {
    if (maxKrediet > 0) {
        this.maxKrediet = maxKrediet;
    }
}    


public int getMaxKrediet() {
    return maxKrediet;
}


//override methods from base object Rekening

@Override 
public void afhalen(double bedrag) {
    if (bedrag > 0.0) {
        double testSaldo = getSaldo() - bedrag + maxKrediet; 
        if (testSaldo >= 0)
        super.afhalen(bedrag); 
    }
}

@Override
public String toString() {
    return super.toString() + ", " + maxKrediet;
}

// override method van rekening abstract
@Override
public double berekenIntrest() {
    if (getSaldo()>0)
        return getSaldo() * INTREST_ZICHTREKENING / 100;
    else
        return 0.0;
}

}
