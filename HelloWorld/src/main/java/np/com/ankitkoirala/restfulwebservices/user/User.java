package np.com.ankitkoirala.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.hateoas.RepresentationModel;

public class User extends RepresentationModel<User> {

	private Integer id;
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	private Date dob;
	
	public User(Integer id, String name, Date dob) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
	}
	
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
	
	
	
	
}
