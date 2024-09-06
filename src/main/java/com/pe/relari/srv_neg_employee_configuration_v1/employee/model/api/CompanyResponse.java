package com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CompanyResponse {

    private String jobTitle;
    private Double salary;

    public CompanyResponse(Company company) {
        this.jobTitle = company.getJobTitle().name();
        this.salary = company.getSalary();
    }

}
