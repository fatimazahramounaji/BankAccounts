package accountRepository;

import bankUser.User;
import exceptions.MyAccountException;

import java.util.HashSet;
import bankAccount.AbstractAccount;

public interface IAccountReposiroty {
	public void addAccount(AbstractAccount account) throws MyAccountException; 
	public HashSet<AbstractAccount> readAccounts(User User) throws MyAccountException; 
	public void deleteAccount(AbstractAccount account) throws MyAccountException; 
	public void updateAccount(AbstractAccount accountOld, AbstractAccount accountNew) throws MyAccountException;
	public int sumAllAccounts(User user) throws MyAccountException;
}
