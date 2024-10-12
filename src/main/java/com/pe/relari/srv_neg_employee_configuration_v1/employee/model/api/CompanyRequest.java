package com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.Constants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CompanyRequest {

    @NotNull
    @NotBlank
    @Pattern(regexp = Constants.REGEXP_JOBS_TITLES)
    @Size(min = 1, max = 50)
    @Schema(
            description = "Representa el cargo o posición del empleado en la empresa",
            name = "jobTitle",
            implementation = String.class,
            pattern = Constants.REGEXP_JOBS_TITLES,
            example = "Asistente",
            required = true)
    private String jobTitle;

    @NotNull
    @Schema(
            description = "Representa el salario o sueldo del empleado",
            name = "salary",
            implementation = Double.class,
            example = "1500",
            required = true)
    private Double salary;

}
