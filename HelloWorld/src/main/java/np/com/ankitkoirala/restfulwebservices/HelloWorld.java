package np.com.ankitkoirala.restfulwebservices;

import java.io.Serializable;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
	
	@Autowired
	private MessageSource messageSource;
	
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
	
	@GetMapping("/hello-world-i11y")
	public String HelloWorldI11y() {
		Locale locale= LocaleContextHolder.getLocale();
		return messageSource.getMessage("hello", null, locale);
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
