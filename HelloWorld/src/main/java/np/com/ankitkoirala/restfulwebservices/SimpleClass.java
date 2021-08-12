package np.com.ankitkoirala.restfulwebservices;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter(FilterController.USER_FILTER)
public class SimpleClass {

	private Integer id;
	private String name;
	private String address;
	private String title;
	
	public SimpleClass(Integer id, String name, String address, String title) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.title = title;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
}
