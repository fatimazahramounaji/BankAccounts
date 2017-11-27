package userRepository;

import java.util.HashMap;

import bankUser.User;
import exceptions.UserReposirotyException;

public class UserRepository implements IUserRepository {

	private HashMap<Integer, User> userMap = new HashMap<Integer, User>();
	
	public void deleteUser(Integer id) throws UserReposirotyException {
		if(userMap.remove(id) == null)
		throw new UserReposirotyException();
	}

	public void addUser(User user) throws UserReposirotyException {
		if(user == null || userMap.containsKey(user.getId())) 
			throw new UserReposirotyException();
		else
		{
			userMap.put(user.getId(),user);
			
		}
	}

	public User readuser(Integer id) throws UserReposirotyException {
		if(id == null || !(userMap.containsKey(id))) 
			throw new UserReposirotyException();
		else
		return userMap.get(id);
	}

	public void updateUser(User user) throws UserReposirotyException {
		if(user == null || !(userMap.containsKey(user.getId())))
			throw new UserReposirotyException();
		else
		{
			userMap.put(user.getId(),user);
		}
		
	}

	
}
