package pe.com.relari.srv_neg_employee_configuration_v1.employee.util;

import org.springframework.http.ResponseEntity;

import pe.com.relari.srv_neg_employee_configuration_v1.employee.exception.StatusCategory;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.exception.model.ErrorDetail;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.exception.model.ErrorResponse;

public class DefaultResponse {
	
	private DefaultResponse() {}

	public static ResponseEntity<ErrorResponse> internalErrorResponse() {
		return ResponseEntity.internalServerError().build();
	}
	
	public static ResponseEntity<ErrorResponse> badRequestResponse() {
		return ResponseEntity.badRequest()
				.body(new ErrorResponse(
						StatusCategory.INTERNAL_ERROR,
						ErrorDetail.builder()
						.component("")
						.description("")
						.status(StatusCategory.INTERNAL_ERROR)
						.build()
						));
	}
	
}
