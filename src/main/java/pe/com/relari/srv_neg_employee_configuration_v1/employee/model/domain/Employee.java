package pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.ToString;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.util.DocumentTypeCategory;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.util.GenderCategory;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <b>Class:</b> EmployeeDto.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Employee {

  private Integer idEmployee;
  private String fatherLastName;
  private String motherLastName;
  private String firstName;
  private GenderCategory gender;
  private LocalDate birthdate;

  private DocumentTypeCategory documentType;
  private String documentNumber;

  private Contact contact;

  private Credential credential;

  private Company company;

  private LocalDateTime creationDate;
  private Boolean isActive;

}
