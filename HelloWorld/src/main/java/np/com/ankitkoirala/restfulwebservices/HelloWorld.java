package np.com.ankitkoirala.restfulwebservices;

import java.io.Serializable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World bean");
	}
	
	@GetMapping("/hello-world/path/{name}")
	public String HelloWorldPath(@PathVariable String name) {
		return String.format("Hello %s", name);
	}
	
}

class HelloWorldBean implements Serializable {

	private String message;

	public HelloWorldBean(String message) {
		this.message = message;
	}	
	
	public String getMessage() {
		return this.message;
	}
	
}
