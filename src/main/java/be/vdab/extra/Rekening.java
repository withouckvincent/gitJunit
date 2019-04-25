
package be.vdab.extra;

import be.vdab.extra.RekeningNummerException;
import java.util.Objects;

public abstract class Rekening {
	// Members
	private String rekeningNummer;
	private double saldo;
	// methods

	public Rekening(String rekeningNummer) throws RekeningNummerException {
		setRekeningNummer(rekeningNummer);
	}

	public Rekening(String rekeningNummer, double saldo) throws RekeningNummerException {
		setRekeningNummer(rekeningNummer);
		if (saldo >= 0) {
			this.saldo = saldo;
		} else {
			throw new RekeningNummerException("Start saldo moet positief zijn", rekeningNummer);
		}
	}

	private boolean checkIBANnummer(String reknr) {
		// formaat van de string reknr: xxxx xxxx xxxx xxxx
		if (reknr == null || reknr.isEmpty() || reknr.length() != 19 || !reknr.substring(0, 2).equals("BE")) {
			return false;
		}
		try {
			Integer.parseInt(reknr.substring(2, 4));
			int d1 = Integer.parseInt(reknr.substring(5, 9));
			int d2 = Integer.parseInt(reknr.substring(10, 14));
			int d3 = Integer.parseInt(reknr.substring(15, 17));
			int d4 = Integer.parseInt(reknr.substring(17, 19));
			long tienCijfers = d1 * 1000000 + d2 * 100 + d3;
			int rest = (int) (tienCijfers % 97);
			return (rest == d4);
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	public String getRekeningNummer() {
		return rekeningNummer;
	}

	// ondersterstaande throws RekeningNumerException is niet meer nodig wegens
	// extends RuntimeException bij RekeningNummer !

	// public final void setRekeningNummer(String reknr) throws
	// RekeningNummerException {
	public final void setRekeningNummer(String reknr) {
		if (checkIBANnummer(reknr)) {
			rekeningNummer = reknr;
		} else {
			throw new RekeningNummerException("ongeldig reknr", reknr);
		}
	}

	public double getSaldo() {
		return saldo;
	}

	public void storten(double bedrag) {
		if (checkBedrag(bedrag)) {
			saldo += bedrag;
		} else {
			throw new RekeningNummerException("Bedrag moet positief zijn ", this.rekeningNummer);
		}

	}

	public void afhalen(double bedrag) {
		if (checkBedrag(bedrag)) {
			saldo -= bedrag;
		} else {
			throw new RekeningNummerException("Bedrag moet positief zijn ", this.rekeningNummer);
		}

	}

	public void overschrijven(Rekening rek, double bedrag) {
		if (checkBedrag(bedrag)) {
			saldo -= bedrag;
			rek.storten(bedrag);
		}
	}

	private boolean checkBedrag(double bedrag) {
		return bedrag > 0.0;
	}

	@Override
	public String toString() {
		return rekeningNummer + ", " + saldo;
	}

	// abstracte method

	public abstract double berekenIntrest();

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Rekening)) {
			return false;
		}
		Rekening rek = (Rekening) o;
		return rekeningNummer.equals(rek.rekeningNummer);
	}

	@Override
	public int hashCode() {
		int hash = 3;
		hash = 73 * hash + Objects.hashCode(this.rekeningNummer);
		return hash;
	}

}