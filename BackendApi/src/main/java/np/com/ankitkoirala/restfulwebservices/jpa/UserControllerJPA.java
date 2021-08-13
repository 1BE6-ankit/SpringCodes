package np.com.ankitkoirala.restfulwebservices.jpa;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import np.com.ankitkoirala.restfulwebservices.user.UserNotFoundException;

@RestController
public class UserControllerJPA {

	@Autowired private UserRepository repository;
	@Autowired private UserPostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public Iterable<UserJPA> getUsers() {
		return repository.findAll();
	}
	
	@GetMapping("/jpa/user/{id}")
	public UserJPA getUsers(@PathVariable Integer id) {
		return repository.findById(id).get();
	}
	
	@PostMapping(value="/jpa/user", consumes="application/json")
	public Integer addUser(@RequestBody @Valid UserJPA user) {
		return repository.save(user).getId();
	}
	
	@GetMapping("/jpa/user/{id}/posts")
	public List<UserPostJPA> getUserPosts(@PathVariable Integer id) {
		UserJPA user = repository.getById(id);
		if(user == null) {
			throw new UserNotFoundException(id);
		}
		
		return user.getUserPosts();
	}
	
	@PostMapping("/jpa/user/{id}/posts")
	public void addUserPost(@PathVariable Integer id, @RequestBody UserPostJPA userPost) {
		UserJPA user = repository.getById(id);
		if(user == null) {
			throw new UserNotFoundException(id);
		}
		
		userPost.setUser(user);
		postRepository.save(userPost);
	}
	
}
