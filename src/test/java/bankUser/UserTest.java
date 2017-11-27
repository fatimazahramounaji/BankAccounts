package bankUser;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import bankUser.User;
import exceptions.PhoneNumberException;

public class UserTest {

	@Test
	public void testUser() throws PhoneNumberException
    {
       User user = new User("toto",35,"10RUEHAVRE", "0666666666",1);
       assertEquals("name","toto", user.getLastName());
       assertEquals("age",35, user.getAge());
       assertEquals("adresse","10RUEHAVRE", user.getAdresse());
       assertEquals("telephone","0666666666", user.getPhone());
       
    }
	
	@Test(expected = PhoneNumberException.class)
	public void exceptionThrowTest() throws PhoneNumberException{
		 User user = new User("toto",35,"10RUEHAVRE", "0666",1);
	}

}
