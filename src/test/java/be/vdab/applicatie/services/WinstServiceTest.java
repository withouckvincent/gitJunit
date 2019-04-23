package be.vdab.applicatie.services;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import be.vdab.applicatie.repositories.KostRepository;
import be.vdab.applicatie.repositories.KostRepositoryStub;
import be.vdab.applicatie.repositories.OpbrengstRepository;
import be.vdab.applicatie.repositories.OpbrengstRepositoryStub;

@RunWith(MockitoJUnitRunner.class)

public class WinstServiceTest {
	private WinstService winstService;
	@Mock private OpbrengstRepository opbrengstRepository;
	private KostRepository kostRepository;

	public void before() {
		when(opbrengstRepository.findTotaleOpbrengst()).thenReturn(BigDecimal.valueOf(200));
		when(kostRepository.findTotaleKost()).thenReturn(BigDecimal.valueOf(169));
		winstService = new WinstService(opbrengstRepository, kostRepository);
	}



	@Test
	public void winstIsOpbrengstMinKost() {
		verify(opbrengstRepository).findTotaleOpbrengst();
		verify(kostRepository).findTotaleKost();
		assertEquals(0, BigDecimal.valueOf(31).compareTo(winstService.getWinst()));
	}
}
