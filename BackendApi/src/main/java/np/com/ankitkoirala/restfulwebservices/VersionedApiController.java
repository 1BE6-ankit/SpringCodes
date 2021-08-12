package np.com.ankitkoirala.restfulwebservices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import np.com.ankitkoirala.restfulwebservices.user.User;

@RestController
public class VersionedApiController {

	@GetMapping("/v1/message")
	public String getV1Message() {
		return "Message from v1 api";
	} 
	
	@GetMapping("/v2/message") 
	public String getV2Message() {
		return "Message from v2 api";
	}
	
	@GetMapping(value="/param_message", params="version=1")
	public String getV1ParamMessage() {
		return "Message for v1 api requested";
	}
	
	@GetMapping(value="/param_message", params="version=2")
	public String getV2ParamMessage() {
		return "Message for v2 api requested";
	}
	
	@GetMapping(value="/header_version/message", headers="X-API-VERSION=1")
	public String getV1HeaderMessage() {
		return "Message for v1 api with header versioning requested";
	}
	
	@GetMapping(value="/header_version/message", headers="X-API-Version=2")
	public String getV2HeaderMessage() {
		return "Message for v2 api with header versioning requested";
	}
	
	@GetMapping(value="/accept_header/message", produces="application/api-v1+json")
	public Map<String, String> getAcceptHeaderV1Message() {
		Map<String, String> jsonResult = new HashMap<>();
		jsonResult.put("message", "Message for v1 api with accept header");
		return jsonResult;
	}
	
	@GetMapping(value="/accept_header/message", produces="application/api-v2+json")
	public Map<String, String> getAcceptHeaderV2Message() {
		Map<String, String> jsonResult = new HashMap<>();
		jsonResult.put("message", "Message for v2 api with accept header");
		return jsonResult;
	}
	
}
