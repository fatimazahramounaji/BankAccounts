package bankAccount;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import bankUser.User;
import exceptions.PhoneNumberException;

public class TestEpargneAccount {
	User u1;
	User u2;
	String creationDate;
	Integer balance;
	Epargne epargneAccount;

	@Before
	public void testPrerequisit() throws PhoneNumberException {
		u1 = new User("toto", 35, "10RUEHAVRE", "0666666666", 1);
		u2 = new User("tata", 35, "10RUEHAVRE", "0666666666", 2);
		creationDate = "20/04/2000";
		balance = 20;
		epargneAccount = new Epargne(u1, creationDate, balance);
	}

	@Test
	public void testEpargneAccount() {
		assertNotNull(u1);
		assertEquals(u1, epargneAccount.getU());
		assertEquals(creationDate, epargneAccount.getCreationDate());
		assertEquals(balance, epargneAccount.getBalance());
	}

	@Test
	public void testEpargneWithdraw() {
		epargneAccount.withdraw(5);
		int balaceUpdated = epargneAccount.getBalance();
		assertEquals(5, balaceUpdated);
	}
	
	@Test
	public void testEpargneDeposit() {
		epargneAccount.setBalance(0);
		epargneAccount.deposit(15);
		int balaceUpdated = epargneAccount.getBalance();
		assertEquals(5, balaceUpdated);
	}
}
