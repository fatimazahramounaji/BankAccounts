package bankAccount;

import bankUser.User;

public class Epargne extends AbstractAccount {
	
	public Epargne(User u, String creationDate, Integer balance) {
		super(u, creationDate, balance);
		
	}
	private final static int fraisEpargne = 10; 
	@Override
	public void withdraw(int x) {
		if(this.getBalance() > x + Epargne.fraisEpargne)
			this.setBalance(this.getBalance()- x- Epargne.fraisEpargne); 
		else 
			System.out.println("Impossible d'effectuer l'opération");
	}

	@Override
	public void deposit(int x) {
		this.setBalance(this.getBalance() + x - fraisEpargne);
	}
}
