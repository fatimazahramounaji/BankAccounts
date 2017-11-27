package accountRepository;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import bankAccount.AbstractAccount;
import bankAccount.Courrant;
import bankAccount.Epargne;
import bankUser.User;
import exceptions.MyAccountException;
import exceptions.PhoneNumberException;

public class TestAccountRepository {

	User u1;
	User u2;
	String creationDate;
	Integer balance;
	Epargne epargneAccount, epargneAccount2;
	Courrant courrantAccount, courrantAccount2, newCourrantAccount;
	/** HashMap<User, HashSet<AbstractAccount>> accountsHMAp; */
	AccountRepository accountsRepository;

	@Before
	public void testPrerequisit() throws PhoneNumberException {
		u1 = new User("toto", 35, "10RUEHAVRE", "0666666666", 1);
		u2 = new User("tata", 35, "10RUEHAVRE", "0666666666", 2);
		creationDate = "20/04/2000";
		balance = 20;
		epargneAccount = new Epargne(u1, creationDate, balance);
		courrantAccount = new Courrant(u1, creationDate, balance);
		newCourrantAccount = new Courrant(u1, creationDate, 10);
		epargneAccount2 = new Epargne(u2, creationDate, balance);
		courrantAccount2 = new Courrant(u2, creationDate, balance);
		accountsRepository = new AccountRepository();
	}

	@Test
	public void testAddAccount() throws MyAccountException {
		assertNotNull(courrantAccount);
		assertNotNull(courrantAccount.getU());
		accountsRepository.addAccount(courrantAccount);
		accountsRepository.addAccount(epargneAccount);
		assertEquals(u1, courrantAccount.getU());
		assertEquals(u1, epargneAccount.getU());
		assertEquals(u2, courrantAccount2.getU());
		assertEquals(u2, epargneAccount2.getU());
	}

	@Test
	public void testUpddateAccount() throws MyAccountException {
		assertNotNull(newCourrantAccount);
		assertNotNull(newCourrantAccount.getU());
		accountsRepository.addAccount(courrantAccount);
		accountsRepository.updateAccount(courrantAccount, newCourrantAccount);
		assertTrue(accountsRepository.readAccounts(u1).contains(newCourrantAccount));
		assertTrue(!accountsRepository.readAccounts(u1).contains(courrantAccount));
	}
	
	@Test
	public void testDeleteAccount() throws MyAccountException {
		assertNotNull(newCourrantAccount);
		assertNotNull(newCourrantAccount.getU());
		accountsRepository.addAccount(newCourrantAccount);
		assertTrue(accountsRepository.readAccounts(u1).contains(newCourrantAccount));
		accountsRepository.deleteAccount(newCourrantAccount);
		assertTrue(!accountsRepository.readAccounts(u1).contains(newCourrantAccount));
	}
	
	@Test
	public void testSumAllAccounts() throws MyAccountException {
		courrantAccount2.deposit(10);
		epargneAccount2.withdraw(5);
		accountsRepository.addAccount(courrantAccount2);
		accountsRepository.addAccount(epargneAccount2);
		assertEquals(35, accountsRepository.sumAllAccounts(u2));
	}
	
}
