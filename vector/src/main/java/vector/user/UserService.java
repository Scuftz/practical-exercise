package vector.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class is a service which means it is a Singleton that is created upon starting the server
 * @author Shivneel Singh
 * @since 26/09/2021
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Calls upon the UserRepository to add a new user
	 * @param user The user object to be added into the database
	 */
	public void addUser(User user) {
		if(getUser(user.getEmail()) == null) {
			userRepository.save(user);			
		}
	}
	
	/**
	 * Calls upon the UserRepository to get a user
	 * @param email The email of the account to retrieve
	 * @return The user account linked to the email parameter
	 */
	public User getUser(String email) {
		return userRepository.findById(email).orElse(null);
	}
	
	/**
	 * Calls upon the UserRepository to update a user
	 * @param user The user object to be updated
	 */
	public void updateUser(User user) {
		userRepository.save(user);
	}
	
	/**
	 * Calls upon the UserRepository to delete a user
	 * @param email The email of account to be deleted
	 */
	public void deleteUser(String email) {
		userRepository.deleteById(email);
	}	
}
