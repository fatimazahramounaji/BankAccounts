package bankUser;

import java.util.HashSet;
import bankAccount.*;
import exceptions.PhoneNumberException;

public class User {

	private String lastName;
	private int age;
	private String adresse;
	private String phone;
	private int id;
	private HashSet<AbstractAccount> accounts = new HashSet<>();

	public HashSet<AbstractAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(HashSet<AbstractAccount> accounts) {
		this.accounts = accounts;
	}

	public User(String lastName, int age, String adresse, String phone, int id) throws PhoneNumberException {
		if (phone.length() != 10)
			throw new PhoneNumberException();
		this.lastName = lastName;
		this.age = age;
		this.adresse = adresse;
		this.phone = phone;
		this.id = id;

	}

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
