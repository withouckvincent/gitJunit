package be.vdab.examen;

import java.util.stream.Collectors;

import java.util.LinkedHashSet;
import java.util.Set;

public class Persoon {

	private final Set<String> voornamen = new LinkedHashSet<>();

	public void add(String voornaam) {

		if (voornaam.trim().isEmpty()) {
			throw new IllegalArgumentException("De voornaam moet minstens één niet-blanco teken bevatten.");
		}

		if (!voornamen.add(voornaam)) { 
			throw new IllegalArgumentException("Geen dubbele voornamen toegelaten.");
		}
		
	}

	@Override
	public String toString() {
		return voornamen.stream().map(voornaam -> voornaam.toString()).collect(Collectors.joining(" "));
	}
}
