package bankUser;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import bankUser.User;
import exceptions.PhoneNumberException;
import exceptions.UserReposirotyException;
import userRepository.UserRepository;

public class UserRepositoryTest {
	UserRepository uRepo = new UserRepository();
	User u1, u2;

	@Before
	public void testPrerequisit() throws PhoneNumberException {
		u1 = new User("toto", 35, "10RUEHAVRE", "0666666666", 1);
		u2 = new User("tata", 35, "10RUEHAVRE", "0666666666", 2);
	}

	@Test
	public void testAddAndReadUser() throws PhoneNumberException, UserReposirotyException {
		uRepo.addUser(u1);
		assertEquals(u1, uRepo.readuser(u1.getId()));
	}

	@Test
	public void testUpdateUser() throws PhoneNumberException, UserReposirotyException {
		assertNotNull(u1);
		uRepo.addUser(u1);
		assertNotNull(uRepo.readuser(u1.getId()));
		uRepo.updateUser(u1);
		assertEquals(u1, uRepo.readuser(u1.getId()));
	}
	
	@Test(expected = UserReposirotyException.class)
	public void testDeleteUser() throws PhoneNumberException, UserReposirotyException {
		uRepo.deleteUser(u1.getId());
		assertEquals(null, uRepo.readuser(u1.getId()));
	}

}
