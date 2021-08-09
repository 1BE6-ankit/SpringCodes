package np.com.ankitkoirala.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserPostNotFoundException extends RuntimeException {

	public UserPostNotFoundException(int userId) {
		super(String.format("Posts for user = %d not found", userId));
	}
	
	public UserPostNotFoundException(int userId, int postId) {
		super(String.format("Posts for user = %d, for post = %d not found", userId, postId));
	}
	
}
