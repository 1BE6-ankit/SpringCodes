package np.com.ankitkoirala.restfulwebservices;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import ch.qos.logback.classic.pattern.MethodOfCallerConverter;
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
	
	
	@GetMapping(value = "/users/{id}")
	public EntityModel<User> getUser(@PathVariable int id) {
		User user = (userDaoService.getUser(id));
		if(user == null) {
			throw new UserNotFoundException(id);
		}
		
		EntityModel<User> userModel = EntityModel.of(user);
		Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserResource.class).getUser(user.getId()))
				.withSelfRel();
		Link allUsersLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserResource.class).getUsers()).withRel("allUsers");
		
		userModel.add(selfLink);
		userModel.add(allUsersLink);
		
		return userModel;
	}
	
	@PostMapping(value = "/users")
	public ResponseEntity<Object> addUser(@RequestBody @Valid User user) {
		userDaoService.addUser(user);
		
		UriComponents uriComponents = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/users/")
				.path(user.getId().toString())
				.build();
		
		return ResponseEntity.created(uriComponents.toUri()).build();		
	}
	
	@GetMapping(value = "/users/{id}/posts")
	public CollectionModel<EntityModel<UserPost>> getUserAllPosts(@PathVariable int id) {
		List<UserPost> userPostsInitial = userPostDaoService.getUserAllPosts(id);
		if(userPostsInitial == null) {
			throw new UserPostNotFoundException(id);
		}
		
		List<EntityModel<UserPost>> userPosts = new ArrayList<>();
		for(UserPost userPost : userPostsInitial) {
			EntityModel<UserPost> userPostModel = EntityModel.of(userPost);
			Link eachPostSelf = WebMvcLinkBuilder.
					linkTo(
							WebMvcLinkBuilder.methodOn(UserResource.class).getPostDetails(id, userPost.getPostId())
					).withSelfRel();
			Link allUserPosts = WebMvcLinkBuilder.
					linkTo(
							WebMvcLinkBuilder.methodOn(UserResource.class).getUserAllPosts(id)
					).withRel("allUserPosts");
			userPostModel.add(eachPostSelf);
			userPostModel.add(allUserPosts);
			userPosts.add(userPostModel);
		}
		
		Link collectionLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder.methodOn(UserResource.class).getUserAllPosts(id))
				.withSelfRel();
		CollectionModel<EntityModel<UserPost>> userPostsCollection = CollectionModel.of(userPosts);
		userPostsCollection.add(collectionLink);
		
		return userPostsCollection;
	}
	
	@GetMapping("/users/{id}/posts/{postId}")
	public List<UserPost> getPostDetails(@PathVariable int id, @PathVariable int postId) {
		return null;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = userDaoService.deleteUser(id);
		if(user == null) {
			throw new UserNotFoundException(id);
		} 
	}

}
