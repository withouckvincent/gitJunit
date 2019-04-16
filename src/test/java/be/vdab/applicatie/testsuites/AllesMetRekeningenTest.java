package be.vdab.applicatie.testsuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import be.vdab.applicatie.domain.RekeningTest;
import be.vdab.applicatie.domain.RekeningnummerTest;

@RunWith(Suite.class)
@SuiteClasses({ RekeningnummerTest.class, RekeningTest.class })
public class AllesMetRekeningenTest {
}