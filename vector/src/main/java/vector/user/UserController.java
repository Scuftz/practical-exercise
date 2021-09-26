package vector.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is responsible for performing REST operations
 * @author Shivneel Singh
 * @since 26/09/2021
 */
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * POST request to create a new user
	 * @param user The User object stored in request body
	 */
	@RequestMapping(method = RequestMethod.POST, value="/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	/**
	 * GET request to get a specific user
	 * @param email The user's email is used to get specific account
	 * @return The user object
	 */
	@RequestMapping("/users/{email}")
	public User getUser(@PathVariable String email) {
		return userService.getUser(email);
	}
	
	/**
	 * PUT request to update a user
	 * @param user The user object in the request body to be updated
	 */
	@RequestMapping(method = RequestMethod.PUT, value="/users/{email}")
	public void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}
	
	/**
	 * DELETE request to delete a user
	 * @param email The user's email is used to delete that specific account
	 */
	@RequestMapping(method = RequestMethod.DELETE, value="/users/{email}")
	public void deleteUser(@PathVariable String email) {
		userService.deleteUser(email);
	}
}
