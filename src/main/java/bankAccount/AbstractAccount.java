package bankAccount;

import bankUser.User;

/**
 * 
 * @author Fatima-Zahra Mounaji
 *
 */

public abstract class AbstractAccount {
	private User u;
	private String creationDate;
	private Integer balance;
	static int counter = 0;
	private int id;

	public AbstractAccount(User u, String creationDate, Integer balance) {
		this.u = u;
		this.creationDate = creationDate;
		this.balance = balance;
		this.id = counter;
		AbstractAccount.counter++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public abstract void withdraw(int x);

	public abstract void deposit(int x);

	
	public int getCounter() {
		return counter;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	}
