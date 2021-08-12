package np.com.ankitkoirala.restfulwebservices.user;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		ErrorBean errorBean = new ErrorBean(ex.getMessage(), 404, request.getDescription(false));
		return new ResponseEntity<Object>(errorBean, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({UserNotFoundException.class})
	public ResponseEntity<Object> handleAll(UserNotFoundException ex, WebRequest request) {
		ErrorBean errorBean = new ErrorBean(ex.getMessage(), 404, request.getDescription(false));
		return new ResponseEntity<Object>(errorBean, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		ErrorBean errorBean = new ErrorBean("Validation failed", 400, ex.getBindingResult().toString());
		return new ResponseEntity<Object>(errorBean, HttpStatus.BAD_REQUEST);
	}
	
}
