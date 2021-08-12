package np.com.ankitkoirala.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
 
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@Component
public class UserDaoService {

	static List<User> users = new ArrayList<>();
	static int count = 3;
	
	static {
		users.add(0, new User(0, "First", new Date()));
		users.add(1, new User(1, "Second", new Date()));
		users.add(2, new User(2, "Third", new Date()));
	}	
	
	public List<User> getUsers() {
		return users;
	}
	
	public User getUser(int id) {
		for(User user : users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public void addUser(User user) {
		System.out.println(String.format("addUser, id=", user.getId()));
		if(user.getId() == null ) user.setId(count++);
		users.add(user);
	}
	
	public User deleteUser(int id) {
		Iterator<User> it = users.iterator();
		while(it.hasNext()) {
			User user = it.next();
			if(user.getId() == id) {
				System.out.println("User was found");
				it.remove();
				return user;
			}
		}
		System.out.println("User was not found");
		return null;
	}
	
}
