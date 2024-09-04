package com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.annotation.JobTitle;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * <b>Class:</b> EmployeeRequest.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {

  @NotBlank
  @Pattern(regexp = Constants.REGEXP_ONLY_LETTERS)
  @Size(min = 1, max = 50)
  @Schema(
          description = "Representa el nombre del empleado",
          name = "firstName",
          implementation = String.class,
          example = "Daniel",
          required = true)
  private String firstName;

  @NotBlank
  @Pattern(regexp = Constants.REGEXP_ONLY_LETTERS)
  @Size(min = 1, max = 50)
  @Schema(
          description = "Representa el apellido paterno del empleado",
          name = "fatherLastName",
          implementation = String.class,
          example = "Gonzales",
          required = true)
  private String fatherLastName;

  @NotBlank
  @Pattern(regexp = Constants.REGEXP_ONLY_LETTERS)
  @Size(min = 1, max = 50)
  @Schema(
          description = "Representa el apellido materno del empleado",
          name = "motherLastName",
          implementation = String.class,
          example = "Perez",
          required = true)
  private String motherLastName;

  @NotBlank
  @Pattern(regexp = Constants.REGEXP_SEX)
  @Schema(
          description = "Representa el género o sexo del empleado.",
          name = "gender",
          implementation = String.class,
          example = "M",
          required = true)
  private String gender;

  @Schema(
          description = "Representa la fecha de nacimiento del empleado",
          name = "birthdate",
          implementation = String.class,
          example = "03-05-1995",
          required = true)
  @NotNull
  @NotBlank
  @Size(min = 10, max = 10)
  @Pattern(regexp = Constants.REGEXP_DATE)
  @JsonProperty("birthdate")
  private String birthdate;

  @Valid
  private ContactRequest contactInfo;

  @Valid
  private CompanyRequest company;

}