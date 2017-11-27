package bankAccount;

import bankUser.User;

public class Courrant extends AbstractAccount {
	public Courrant(User u, String creationDate, Integer balance) {
		super(u, creationDate, balance);
		// TODO Auto-generated constructor stub
	}

	private static String accountType = "courrant";
	
	@Override
	public void withdraw(int x) {
		if (this.getBalance() > x)
			this.setBalance(this.getBalance() - x);
		else
			System.out.println("Impossible d'effectuer l'opération");
	}

	@Override
	public void deposit(int x) {
		this.setBalance(this.getBalance() + x);
	}
}
