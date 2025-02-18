package pe.com.relari.srv_neg_employee_configuration_v1.employee.exception;

import lombok.extern.slf4j.Slf4j;
import pe.com.relari.srv_neg_employee_configuration_v1.config.ErrorProperties;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.exception.model.ErrorResponse;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.util.DefaultResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * <b>Class:</b> ErrorFactory.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Slf4j
@ControllerAdvice
public class ErrorFactory {

  @Value("${spring.application.name}")
  private String applicationName;

  @Autowired
  private ErrorProperties errorProperties;

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ErrorResponse> apiException(
            ApiException apiException) {

        var errorDetail = errorProperties.getErrors().getValue(apiException.getCatalog());

        return ResponseEntity.status(errorDetail.getStatus().getStatusCode())
                .body(new ErrorResponse(
                        errorDetail.getStatus(), errorDetail.mutate().component(applicationName).build()
                ));
    }
    
//    @ExceptionHandler(BindException.class)
//	public ResponseEntity<ErrorResponse> BindException(
//			BindException exception){
//		exception.getFieldErrors().forEach(error ->{
//			log.error("[BindException] Parametro: %s, %s", error.getField(), error.getDefaultMessage());
//		});
//		return DefaultResponse.badRequestResponse();
//	}
//
//	@ExceptionHandler(HttpMessageNotReadableException.class)
//	public ResponseEntity<ErrorResponse> HttpMessageNotReadableException(
//			HttpMessageNotReadableException exception){
//		log.error("[HttpMessageNotReadableException] Parametro %s es requerido.", exception.getMessage());
//		return DefaultResponse.badRequestResponse();
//	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<ErrorResponse> MethodArgumentNotValidException(
//			MethodArgumentNotValidException exception){
//		log.error("[MethodArgumentNotValidException] Parametro: {} es requerido.", exception.getParameter().getParameterName());
//		return DefaultResponse.badRequestResponse();
//	}
//
//	@ExceptionHandler(ConstraintViolationException.class)
//	public ResponseEntity<ErrorResponse> constraintViolationException(
//			ConstraintViolationException exception){
//
//		exception.getConstraintViolations().forEach(constraintViolation -> {
//			String path = constraintViolation.getPropertyPath().toString();
//			String parameter = path.substring(path.indexOf("."));
//
//			log.error("[ConstraintViolationException] Parametro {} es requerido.", parameter);
//		});
//
//		return DefaultResponse.badRequestResponse();
//	}
//
//	@ExceptionHandler(MissingServletRequestParameterException.class)
//	public ResponseEntity<ErrorResponse> missingServletRequestParameterException(
//			MissingServletRequestParameterException exception){
//		log.error("[MissingServletRequestParameterException] Parametro %s es requerido.", exception.getParameterName());
//		return DefaultResponse.badRequestResponse();
//	} // 400 Exception end


//	@ExceptionHandler(NoHandlerFoundException.class)
//	public ResponseEntity<ErrorResponse> NotFoundException(
//			NoHandlerFoundException exception){
//
//		int positionV1 = exception.getRequestURL().indexOf("v1/");
//		String endpoint = exception.getRequestURL().substring(positionV1 + 3);
//
//		log.error("[NoHandlerFoundException] NotFound: [endpoint = %s , message = %s]", endpoint, exception.getMessage());
//		return DefaultResponse.resourceNotFoundResponse();
//	}
//
//	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//	public ResponseEntity<ErrorResponse> httpRequestMethodNotSupportedException(
//			HttpRequestMethodNotSupportedException exception){
//		log.error("[HttpRequestMethodNotSupportedException] Error Not Found: %s", exception.getMessage());
//		return DefaultResponse.notAllowedResponse();
//	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorResponse> runTimeException(
			RuntimeException exception){
		
		log.error("[RuntimeException] Runtime: {}", exception.getMessage());
		return DefaultResponse.internalErrorResponse();
	}

}
