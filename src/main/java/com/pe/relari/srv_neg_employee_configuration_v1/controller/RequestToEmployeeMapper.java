package com.pe.relari.srv_neg_employee_configuration_v1.controller;

import static java.lang.Boolean.TRUE;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.CompanyResponse;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.ContactResponse;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeRequest;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeResponse;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Company;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Contact;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.DocumentTypeCategory;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.GenderCategory;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.Utility;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestToEmployeeMapper {

  static Employee mapEmployee(EmployeeRequest employeeRequest) {
    return Employee.builder()
            .firstName(employeeRequest.getFirstName())
            .fatherLastName(employeeRequest.getFatherLastName())
            .motherLastName(employeeRequest.getMotherLastName())
            .gender(GenderCategory.valueOf(employeeRequest.getGender()))
            .birthdate(Utility.mapLocalDate(employeeRequest.getBirthdate()))
            .documentType(DocumentTypeCategory.valueOf(employeeRequest.getDocumentType()))
            .documentNumber(employeeRequest.getDocumentNumber())
            .contact(new Contact(employeeRequest.getContactInfo()))
            .company(new Company(employeeRequest.getCompany()))
            .isActive(TRUE)
            .build();
  }
  static EmployeeResponse mapPersonResponse(Employee employee) {
    return EmployeeResponse.builder()
            .firstName(employee.getFirstName())
            .fatherLastName(employee.getFatherLastName())
            .motherLastName(employee.getMotherLastName())
            .gender(employee.getGender().name())
            .birthdate(Utility.formatDate(employee.getBirthdate()))
            .documentType(employee.getDocumentType().name())
            .documentNumber(employee.getDocumentNumber())
            .contact(new ContactResponse(employee.getContact()))
            .company(new CompanyResponse(employee.getCompany()))
            .build();
  }

}
