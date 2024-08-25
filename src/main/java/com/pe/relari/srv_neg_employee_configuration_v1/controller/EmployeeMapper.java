package com.pe.relari.srv_neg_employee_configuration_v1.controller;

import static java.lang.Boolean.TRUE;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeRequest;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.PersonResponse;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.ContactInfo;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.JobTitleCategory;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.GenderCategory;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.Utility;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeMapper {

  static Employee mapEmployee(EmployeeRequest employeeRequest) {
    return Employee.builder()
            .firstName(employeeRequest.getFirstName())
            .fatherLastName(employeeRequest.getFatherLastName())
            .motherLastName(employeeRequest.getMotherLastName())
            .gender(GenderCategory.valueOf(employeeRequest.getGender()))
            .jobTitle(JobTitleCategory.valueOf(employeeRequest.getJobTitle()))
            .salary(employeeRequest.getSalary())
            .isActive(TRUE)
            .birthdate(Utility.mapLocalDate(employeeRequest.getBirthdate()))
            .contactInfo(new ContactInfo(employeeRequest.getContactInfo()))
            .build();
  }
  static PersonResponse mapPersonResponse(Employee employee) {
    return PersonResponse.builder()
            .firstName(employee.getFirstName())
            .fatherLastName(employee.getFatherLastName())
            .motherLastName(employee.getMotherLastName())
            .gender(employee.getGender().name())
            .birthdate(Utility.formatDate(employee.getBirthdate()))
            .build();
  }

}
