package be.vdab.applicatie.repositories;

import be.vdab.applicatie.domain.Land;

public interface LandRepository {
	
	Land read(String landcode);
	int findOppervlakteAlleLanden();

}
