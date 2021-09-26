package vector.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * This class represents a User object
 * @author Shivneel Singh
 * @since 26/09/2021
 */
@Entity
@Table(name = "Users")
public class User {
	
	@Id
	@Email
	@NotEmpty
	private String email;
	@NotEmpty
	private String password;
	
	private String firstname;
	private String lastname;
	
	public User() { }
	
	public User(String email, String password, String firstname, String lastname) {
		super();
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
