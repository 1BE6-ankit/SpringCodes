package np.com.ankitkoirala.restfulwebservices.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFilter;

@Entity
@Table(name="user_post")
public class UserPostJPA extends RepresentationModel<UserPostJPA> {
	
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private Integer postId;
	
	private String postContent;
	private Date date;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="user_id")
	private UserJPA user;
	
	public UserPostJPA(int postId, String postContent, Date date, UserJPA user) {
		super();
		this.user = user;
		this.postId = postId;
		this.postContent = postContent;
		this.date = date;
	}


	public UserJPA getUser() {
		return user;
	}

	public void setUser(UserJPA user) {
		this.user = user;
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
