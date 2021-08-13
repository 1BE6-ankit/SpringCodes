package np.com.ankitkoirala.restfulwebservices.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControllerJPA {

	@Autowired
	private UserRepository repository;
	
	@GetMapping("/jpa/users")
	public Iterable<UserJPA> getUsers() {
		return repository.findAll();
	}
	
	
}
