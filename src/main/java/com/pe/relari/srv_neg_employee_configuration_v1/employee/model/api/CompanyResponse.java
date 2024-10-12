package com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Company;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CompanyResponse {

    @Schema(
            description = "Representa el cargo o posición del empleado en la empresa",
            name = "jobTitle",
            implementation = String.class,
            example = "Asistente")
    private String jobTitle;

    @Schema(
            description = "Representa el salario o sueldo del empleado",
            name = "salary",
            implementation = Double.class,
            example = "1500")
    private Double salary;

    public CompanyResponse(Company company) {
        this.jobTitle = company.getJobTitle().name();
        this.salary = company.getSalary();
    }

}
