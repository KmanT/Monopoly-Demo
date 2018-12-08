package cis.jUnitTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ActivatePlayersTest.class, BankPayPlayerTest.class,
	EveryOnePayPlayerTest.class, GetSpecificPlayerTest.class,
	MovePlayerTest.class, PlayerPayBankTest.class,
	TransferPlayerFundsTest.class})
public class AllTests {

}
