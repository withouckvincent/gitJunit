package be.vdab.applicatie.services;

import java.math.BigDecimal;
import be.vdab.applicatie.repositories.KostRepository;
import be.vdab.applicatie.repositories.OpbrengstRepository;

public class WinstService {
	private final OpbrengstRepository opbrengstRepository;
	private final KostRepository kostRepository;

	public WinstService(OpbrengstRepository opbrengstRepository, KostRepository kostRepository) {
		this.opbrengstRepository = opbrengstRepository;
		this.kostRepository = kostRepository;
	}

	public BigDecimal getWinst() {
		throw new UnsupportedOperationException();
	}
}
