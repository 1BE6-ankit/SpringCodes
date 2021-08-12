package np.com.ankitkoirala.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserPostDaoService {

	private static List<List<UserPost>> userPosts = new ArrayList<>();
	private int nUsers = 3;
	
	static {
		List<UserPost> user0Posts = new ArrayList<UserPost>();
		user0Posts.add(new UserPost(0, 0, "User 0, post 0", new Date()));
		user0Posts.add(new UserPost(0, 1, "User 0, post 1", new Date()));
		user0Posts.add(new UserPost(0, 2, "User 0, post 2", new Date()));
		
		
		List<UserPost> user1Posts = new ArrayList<UserPost>();
		user1Posts.add(new UserPost(1, 0, "User 1, post 0", new Date()));
		user1Posts.add(new UserPost(1, 1, "User 1, post 1", new Date()));
		user1Posts.add(new UserPost(1, 2, "User 1, post 2", new Date()));
		
		List<UserPost> user2Posts = new ArrayList<UserPost>();
		user2Posts.add(new UserPost(1, 0, "User 2, post 0", new Date()));
		user2Posts.add(new UserPost(1, 1, "User 2, post 1", new Date()));
		user2Posts.add(new UserPost(1, 2, "User 2, post 2", new Date()));
		
		userPosts.add(user0Posts);
		userPosts.add(user1Posts);
		userPosts.add(user2Posts);
	}
	
	public List<UserPost> getUserAllPosts(int userId) {
		if(userId >= userPosts.size()) {
			return null;
		}
		
		return userPosts.get(userId);
	}
	
	public UserPost getUserPost(int userId, int postId) {
		if(userId >= userPosts.size()) {
			return null;
		}
		
		List<UserPost> posts = userPosts.get(userId);
		if(postId >= posts.size()) {
			return null;
		}
		
		return posts.get(postId);
	}
	
}
