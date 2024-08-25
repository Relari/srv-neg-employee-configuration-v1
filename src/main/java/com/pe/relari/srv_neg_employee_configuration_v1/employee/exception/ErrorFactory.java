package com.pe.relari.srv_neg_employee_configuration_v1.employee.exception;

import com.pe.relari.srv_neg_employee_configuration_v1.config.ErrorProperties;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.exception.model.ErrorResponse;
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

}
