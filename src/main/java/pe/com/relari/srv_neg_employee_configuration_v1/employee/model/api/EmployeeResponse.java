package pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <b>Class:</b> EmployeeResponse.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@ToString
public class EmployeeResponse {

  @Schema(
          description = "Representa el nombre del empleado.",
          name = "firstName",
          example = "Ricardo",
          implementation = String.class)
  private String firstName;

  @Schema(
          description = "Representa el apellido paterno del empleado.",
          name = "fatherLastName",
          example = "Lozano",
          implementation = String.class)
  private String fatherLastName;

  @Schema(
          description = "Representa el apellido materno del empleado.",
          name = "motherLastName",
          example = "Lozano",
          implementation = String.class)
  private String motherLastName;

  @Schema(
          description = "Representa el género o sexo del empleado.",
          name = "gender",
          example = "M",
          implementation = String.class)
  private String gender;

  @Schema(
          description = "Representa la fecha de nacimiento del empleado.",
          name = "birthdate",
          example = "03-05-1995",
          implementation = String.class)
  private String birthdate;

  @Schema(
          description = "Representa el tipo de documento del empleado",
          name = "documentType",
          implementation = String.class,
          example = "DNI")
  @JsonProperty("documentType")
  private String documentType;

  @Schema(
          description = "Representa el numero de documento del empleado",
          name = "documentNumber",
          implementation = String.class,
          example = "12345678")
  @JsonProperty("documentNumber")
  private String documentNumber;

  private ContactResponse contact;

  private CompanyResponse company;

}
