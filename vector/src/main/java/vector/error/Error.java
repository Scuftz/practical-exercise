package vector.error;

/**
 * This class represents an Error object
 * @author Shivneel Singh
 * @since 26/09/2021
 */
public class Error {

	private String code;
	private String message;
	
	public Error(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
