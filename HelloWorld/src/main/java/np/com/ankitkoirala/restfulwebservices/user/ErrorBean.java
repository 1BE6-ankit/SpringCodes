package np.com.ankitkoirala.restfulwebservices.user;

public class ErrorBean {

	private String errorMessage;
	private int errorCode;
	private String description;
	
	public ErrorBean(String errorMessage, int errorCode, String description) {
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.description = description;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}

	public String getDescription() {
		return description;
	}
	
	
}
