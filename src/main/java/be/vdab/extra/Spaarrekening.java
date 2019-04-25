package be.vdab.extra;

import be.vdab.extra.RekeningNummerException;

/**
 *
 * @author Vincent Media
 */
public class Spaarrekening extends Rekening {
	// Members
	private static double intrest;

	// methods
	public Spaarrekening(String rekeningNummer, double intrest) throws RekeningNummerException {
		super(rekeningNummer);
		setIntrest(intrest);
	}

	public Spaarrekening(String rekeningNummer, double intrest, double saldo) throws RekeningNummerException {
		super(rekeningNummer, saldo);
		setIntrest(intrest);
	}

	public final void setIntrest(double intrest) {
		if (intrest > 0.0) {
			Spaarrekening.intrest = intrest;
		} else {
			throw new RekeningNummerException("Intrest moet positief zijn  ", getRekeningNummer());
		}
	}

	public static double getIntrest() {
		return intrest;
	}

	// override methods from base object Rekening

	@Override
	public void afhalen(double bedrag) {
		if (bedrag > 0.0) {
			double testSaldo = getSaldo() - bedrag;
			if (testSaldo >= 0) {
				super.afhalen(bedrag);
			} else {
				throw new RekeningNummerException("Saldo ontoereikend  ", getRekeningNummer());
			}
		}
		 else {
				throw new RekeningNummerException("Bedrag moet positief zijn  ", getRekeningNummer());
			}
	}

	@Override
	public String toString() {
		return super.toString() + ", " + intrest;
	}

	// override method van rekening

	@Override
	public double berekenIntrest() {
		return getSaldo() * intrest / 100;
	}
}
