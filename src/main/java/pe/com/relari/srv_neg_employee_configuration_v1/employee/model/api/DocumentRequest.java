package pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.util.Constants;

@Getter
@Setter
public class DocumentRequest {
    
    @Schema(
          description = "Representa el tipo de documento del empleado",
          name = "documentType",
          implementation = String.class,
          pattern = Constants.REGEXP_TIPO_DOCUMENTO,
          example = "DNI",
          required = true)
  @NotNull
  @NotBlank
  @Pattern(regexp = Constants.REGEXP_TIPO_DOCUMENTO)
  @JsonProperty("type")
  private String type;

  @Schema(
          description = "Representa el numero de documento del empleado",
          name = "number",
          implementation = String.class,
          example = "12345678",
          required = true)
  @NotNull
  @NotBlank
  @JsonProperty("documentNumber")
  private String number;

}
