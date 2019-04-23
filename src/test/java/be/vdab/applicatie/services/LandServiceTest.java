package be.vdab.applicatie.services;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify; 
import static org.mockito.Mockito.when;

import be.vdab.applicatie.repositories.LandRepository;
import be.vdab.applicatie.repositories.LandRepositoryStub;

@RunWith(MockitoJUnitRunner.class)

public class LandServiceTest {
	@Mock private LandRepository landRepository;
	private LandService landService;

	@Before
	public void before() {
		landRepository = new LandRepositoryStub();
		landService = new LandService(landRepository);
	}

	@Test
	public void findVerhoudingOppervlakteLandTovOppervlakteAlleLanden() {
		assertEquals(0, BigDecimal.valueOf(0.25)
				.compareTo(landService.findVerhoudingOppervlakteLandTovOppervlakteAlleLanden("B")));
	}
}