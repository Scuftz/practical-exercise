package vector.user;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import vector.error.Error;

/**
 * This class is a service which means it is a Singleton that is created upon starting the server
 * It handles all the backend operations in this application
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
	public Object addUser(User user) {
		//check user doesn't already exist
		if(findUser(user.getEmail()) == null) {
			try {
				userRepository.save(user);				
			} catch (Exception ex) {
				//transaction rollback, user's email was not a proper email address
				return new Error("400", "Invalid Email Address");
			}
			//successful new user
			return new ResponseEntity<>("The user was successfully created", HttpStatus.CREATED);
		}
		//email already exists
		return new Error("400", "Email already exists");
	}
	
	/**
	 * Calls upon the UserRepository to get a user
	 * @param email The email of the user to retrieve
	 * @return The user account linked to the email parameter
	 */
	public Object getUser(String email) {
		//check if email is valid
		boolean valid = EmailValidator.getInstance().isValid(email);
		if(valid) {
			User user = findUser(email);
			if(user != null) {
				return user;
			}
			return new Error("404", "No user found with given email");
		} else {
			return new Error("400", "Email Syntax is Invalid");
		}
	}
	
	/**
	 * This method is used by other methods to only check if a user already exists
	 * The getUser method is used to respond to the HTTP requests
	 * @param email The email of the user to retrieve
	 * @return User if found else null
	 */
	public User findUser(String email) {
		return userRepository.findById(email).orElse(null);	
	}
	
	/**
	 * Calls upon the UserRepository to update a user
	 * @param user The user object to be updated
	 */
	public Object updateUser(User user, String email) {
		//check if user exists
		if(findUser(email) != null) {
			//check if email is valid
			boolean valid = EmailValidator.getInstance().isValid(email);
			if(valid) {
				userRepository.save(user);	

				//if user updated their email, a new account is created as "email" is a Primary Key and therefore cannot be changed
				//so we must check if email is different, if different, delete old account as there is a new account with the new email
				if(!user.getEmail().equals(email)) {
					deleteUser(email);
				}
				return new ResponseEntity<>("The user was updated successfully", HttpStatus.NO_CONTENT);
			} else {
				return new Error("400", "Email Syntax is Invalid");
			}			
		}
		return new Error("404", "User does not exist");
	}
	
	/**
	 * Calls upon the UserRepository to delete a user
	 * @param email The email of account to be deleted
	 */
	public Object deleteUser(String email) {
		//check if user exists
		if(findUser(email) != null) {
			userRepository.deleteById(email);
			return new ResponseEntity<>("The user was successfully deleted", HttpStatus.NO_CONTENT);
		}
		//no user was found with provided email
		return new Error("400","Failed to delete user");
	}	
}
