package clientAccount;
import bankAccount.AbstractAccount;
import bankAccount.Courrant;
import bankAccount.Epargne;
import bankUser.User;

public abstract class AccountFactory {
	public AbstractAccount getAccount(String accountType, User u) {
			if (accountType == null) {
			return null;
		}
		if (accountType.equalsIgnoreCase("Epargne")) {
			return new Epargne(u, accountType, 0);
		} else if (accountType.equalsIgnoreCase("Courrant")) {
			return new Courrant(u, accountType, 0);
		}
		return null;
	}
}
