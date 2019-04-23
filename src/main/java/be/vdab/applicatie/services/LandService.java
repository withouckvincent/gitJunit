package be.vdab.applicatie.services;

import java.math.BigDecimal;

import be.vdab.applicatie.domain.Land;
import be.vdab.applicatie.repositories.LandRepository;


public class LandService {
	// Onderste nog niet klaar om te gebruiken. 
	//private final LandRepository landRepository = new LandRepository(); 
	private final LandRepository landRepository;

	public LandService(LandRepository landRepository) {
		this.landRepository = landRepository;
		
		}
	
	
	
/*	public BigDecimal findVerhoudingOppervlakteLandTovOppervlakteAlleLanden(String landcode) {
		//throw new UnsupportedOperationException();
		landRepository.read(landcode); // Hier kan ik zogezegd landReposistory gebruiken zonder dat deze af is
		return BigDecimal.ZERO;

	}*/
	
	public BigDecimal findVerhoudingOppervlakteLandTovOppervlakteAlleLanden(
			String landcode) {
			Land land = landRepository.read(landcode);
			int oppervlakteAlleLanden = landRepository.findOppervlakteAlleLanden();
			return new BigDecimal(land.getOppervlakte())
			.divide(BigDecimal.valueOf(oppervlakteAlleLanden));
			}
}