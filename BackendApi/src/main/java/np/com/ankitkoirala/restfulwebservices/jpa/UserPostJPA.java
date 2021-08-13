package np.com.ankitkoirala.restfulwebservices.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="user_post")
public class UserPostJPA extends RepresentationModel<UserPostJPA> {
	
	@Id
	@GeneratedValue( strategy=GenerationType.AUTO )
	private Integer id;
	
	@Column(name="post_content")
	private String postContent;
	
	private Date date;
	
	@ManyToOne(fetch=FetchType.LAZY, optional=false)
//	@JoinColumn(name="user_id")
	@JsonIgnore
	private UserJPA user;
	
	public UserPostJPA() {}

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserJPA getUser() {
		return user;
	}

	public void setUser(UserJPA user) {
		this.user = user;
	}
	
	
	
}
