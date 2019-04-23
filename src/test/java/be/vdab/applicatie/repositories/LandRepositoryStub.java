package be.vdab.applicatie.repositories;

import be.vdab.applicatie.domain.Land;

public class LandRepositoryStub implements LandRepository {
	@Override
	public Land read(String landcode) {
		return new Land(landcode, 5);
	}

	@Override
	public int findOppervlakteAlleLanden() {
		return 20;
	}
}
