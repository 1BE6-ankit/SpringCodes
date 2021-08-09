package np.com.ankitkoirala.restfulwebservices;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import np.com.ankitkoirala.restfulwebservices.user.User;
import np.com.ankitkoirala.restfulwebservices.user.UserDaoService;
import np.com.ankitkoirala.restfulwebservices.user.UserNotFoundException;
import np.com.ankitkoirala.restfulwebservices.user.UserPost;
import np.com.ankitkoirala.restfulwebservices.user.UserPostDaoService;
import np.com.ankitkoirala.restfulwebservices.user.UserPostNotFoundException;

@RestController
public class UserResource {
	
	@Autowired UserDaoService userDaoService;
	@Autowired UserPostDaoService userPostDaoService;
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userDaoService.getUsers();
	}
	
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable int id) {
		User user = userDaoService.getUser(id);
		if(user == null) {
			throw new UserNotFoundException(id);
		} 
		
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> addUser(@RequestBody @Valid User user) {
		userDaoService.addUser(user);
		
		UriComponents uriComponents = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/users/")
				.path(user.getId().toString())
				.build();
		
		return ResponseEntity.created(uriComponents.toUri()).build();		
	}
	
	@GetMapping("/users/{id}/posts")
	public List<UserPost> getUserAllPosts(@PathVariable int id) {
		List<UserPost> userPosts = u serPostDaoService.getUserAllPosts(id);
		if(userPosts == null) {
			throw new UserPostNotFoundException(id);
		}
		
		return userPosts;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userDaoService.deleteUser(id);
		if(user == null) {
			throw new UserNotFoundException(id);
		} 
	}

}
