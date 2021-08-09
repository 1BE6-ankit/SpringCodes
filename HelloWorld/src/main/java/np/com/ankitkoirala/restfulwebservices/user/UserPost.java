package np.com.ankitkoirala.restfulwebservices.user;

import java.util.Date;

public class UserPost {

	private Integer userId;
	private Integer postId;
	private String postContent;
	private Date date;
	public UserPost(Integer userId, int postId, String postContent, Date date) {
		super();
		this.userId = userId;
		this.postId = postId;
		this.postContent = postContent;
		this.date = date;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
}
