package com.pe.relari.srv_neg_employee_configuration_v1.employee.util;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.ContactInfoRequest;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeRequest;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.ContactInfo;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.entity.EmployeeEntity;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.GenderCategory;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.JobTitleCategory;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestMapper {

  private static final Integer idEmployee = 1;
  private static final String firstName = "Renzo";
  private static final String fatherLastName = "Lavado";
  private static final String motherLastName = "Rivas";
  private static final GenderCategory gender = GenderCategory.M;
  private static final JobTitleCategory jobTitle = JobTitleCategory.DEVELOPER;
  private static final Double salary = 2000.00;
  private static final Boolean isActive = true;
  private static final String email = "renzo@email.com";
  private static final String phoneNumber = "900000001";

  public static EmployeeRequest employeeRequest() {
    return EmployeeRequest.builder()
            .firstName(firstName)
            .fatherLastName(fatherLastName)
            .motherLastName(motherLastName)
            .gender(gender.name())
            .jobTitle(jobTitle.name())
            .salary(salary)
            .birthdate("03-05-1995")
            .contactInfo(new ContactInfoRequest(email, phoneNumber))
            .build();
  }

  public static Employee employee() {
    return Employee.builder()
        .idEmployee(idEmployee)
        .firstName(firstName)
        .fatherLastName(fatherLastName)
        .motherLastName(motherLastName)
        .gender(gender)
        .jobTitle(jobTitle)
        .salary(salary)
        .isActive(isActive)
        .contactInfo(new ContactInfo(email, phoneNumber))
        .birthdate(LocalDate.now())
        .build();
  }

  public static EmployeeEntity employeeEntity() {
    return EmployeeEntity.builder()
        .id(idEmployee)
        .firstName(firstName)
        .fatherLastName(fatherLastName)
        .motherLastName(motherLastName)
        .gender(gender)
        .jobTitle(jobTitle)
        .salary(salary)
        .isActive(isActive)
        .email(email)
        .phoneNumber(phoneNumber)
        .birthdate(LocalDate.now())
        .build();
  }
}
