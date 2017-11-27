package accountRepository;
import java.util.HashMap;
import java.util.HashSet;
import exceptions.*;
import bankAccount.AbstractAccount;
import bankUser.User;

public  class AccountRepository implements IAccountReposiroty {

	private HashMap<User, HashSet<AbstractAccount>> accountRepo = new HashMap<User, HashSet<AbstractAccount>>();

	/**public  AccountRepository( HashMap<User, HashSet<AbstractAccount>> accountRepo) {
		this.accountRepo = accountRepo;
	}*/
	public  AccountRepository() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void addAccount(AbstractAccount account) throws MyAccountException {
		if(this.accountRepo.containsKey(account.getU()))
			if(account != null && account.getU() != null && accountRepo.get(account.getU()) != null )
				accountRepo.get(account.getU()).add(account);
			else
			throw new MyAccountException();
		else
		{
			HashSet newListAccount = new HashSet<AbstractAccount>();
			if(newListAccount.add(account))
			accountRepo.put(account.getU(), newListAccount);
	}
	}

	@Override
	public HashSet<AbstractAccount> readAccounts(User user) throws MyAccountException {
		if (user != null && accountRepo.containsKey(user))
			return accountRepo.get(user);
		else
			throw new MyAccountException();
	}

	@Override
	public void deleteAccount(AbstractAccount account) throws MyAccountException {
		if (account != null && account.getU() != null && accountRepo.containsKey(account.getU()))
			accountRepo.get(account.getU()).remove(account);
		else
			throw new MyAccountException();
	}

	@Override
	public void updateAccount(AbstractAccount accountOld, AbstractAccount accountNew) throws MyAccountException  {
		if(accountOld != null && accountOld.getU() != null &&  accountRepo.containsKey(accountOld.getU()))
			{accountRepo.get(accountOld.getU()).remove(accountOld);
			accountRepo.get(accountNew.getU()).add(accountNew);}
		else
			throw new MyAccountException();
	}
	@Override
	public int sumAllAccounts(User user) throws MyAccountException {
		return this.readAccounts(user).stream().mapToInt(i -> i.getBalance().intValue()).sum();
	}

}
