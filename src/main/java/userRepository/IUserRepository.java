package userRepository;

import bankUser.User;
import exceptions.UserReposirotyException;

/** 
 * 
 * @author Fatima-Zahra Mounaji
 *
 */
public interface IUserRepository {
	public void deleteUser(Integer id) throws UserReposirotyException; 
	public void addUser(User user) throws UserReposirotyException; 
	public User readuser(Integer id) throws UserReposirotyException;
	public void updateUser(User user) throws UserReposirotyException;
}
