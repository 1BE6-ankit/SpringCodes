package np.com.ankitkoirala.restfulwebservices.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

@Entity
@Table(name="users")
public class UserJPA {

	@Id
    @GeneratedValue
	private Integer id;
	
	@NotBlank(message = "Name is mandatory")
	@Column(name="name")
	private String name;
	
	@Past
	@Column(name="dob")
	private Date dob;
	
	@OneToMany(mappedBy = "user", fetch=FetchType.LAZY, cascade= {CascadeType.ALL})
	private List<UserPostJPA> userPosts;
	
	public UserJPA() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDob() {
		return this.dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserPostJPA> getUserPosts() {
		return userPosts;
	}

	public void setUserPosts(List<UserPostJPA> userPosts) {
		this.userPosts = userPosts;
	}
	
	
}
