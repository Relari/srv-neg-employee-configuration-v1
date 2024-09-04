package com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.CompanyRequest;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.JobTitleCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Company {

    private JobTitleCategory jobTitle;
    private Double salary;

    public Company(CompanyRequest companyRequest) {
        this.jobTitle = JobTitleCategory.valueOf(companyRequest.getJobTitle());
        this.salary = companyRequest.getSalary();
    }

}
