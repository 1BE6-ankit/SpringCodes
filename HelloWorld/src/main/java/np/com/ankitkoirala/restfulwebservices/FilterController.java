package np.com.ankitkoirala.restfulwebservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.BeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import np.com.ankitkoirala.restfulwebservices.user.User;
import np.com.ankitkoirala.restfulwebservices.user.UserDaoService;

@RestController
public class FilterController {

	public static final String USER_FILTER = "UserFilter";
	
	@Autowired
	UserDaoService UserDaoService;
	
	@GetMapping("/filter/somelist")
	public MappingJacksonValue filteredUser(@RequestParam(value="values", required=false) String[] values) {
		List<SimpleClass> someList= getSomeList();
		
		MappingJacksonValue mapping = new MappingJacksonValue(someList);
		SimpleBeanPropertyFilter filter;
		if(values!=null) {
			filter = SimpleBeanPropertyFilter.filterOutAllExcept(values);	
		} else {
			filter = SimpleBeanPropertyFilter.serializeAllExcept(new HashSet<String>());
		}
		
		FilterProvider filters = new SimpleFilterProvider().addFilter(USER_FILTER, filter);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	private List<SimpleClass> getSomeList() {
		List<SimpleClass> someList = 
				Arrays.asList(
						new SimpleClass(1, "Eddard", "Winterfell", "Warden of the North"),
						new SimpleClass(2, "Victarion", "Iron Islands", "Captain of Iron Fleet"),
						new SimpleClass(3, "Arianne", "Dorne", "Wild Beast"));
		
		return someList;
	}
	
	
}
