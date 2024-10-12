package com.pe.relari.srv_neg_employee_configuration_v1;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <b>Class:</b> EmployeeApplication.<br/>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@OpenAPIDefinition(
        info = @Info(
                title = "${spring.application.name}",
                version = "${application.info.version}",
                description = "${application.info.description}")
)
@SpringBootApplication
public class EmployeeApplication {

  public static void main(String[] args) {
    SpringApplication.run(EmployeeApplication.class);
  }

}
