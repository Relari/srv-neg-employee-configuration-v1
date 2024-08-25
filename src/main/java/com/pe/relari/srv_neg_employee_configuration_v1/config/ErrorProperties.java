package com.pe.relari.srv_neg_employee_configuration_v1.config;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.exception.ErrorCategory;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.exception.model.ErrorDetail;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.GenericMap;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * <b>Class:</b> ErrorProperties.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Data
@Lazy
@Configuration
@ConfigurationProperties(prefix = "application.backend")
public class ErrorProperties {

  private GenericMap<ErrorCategory, ErrorDetail> errors;

}
