package com.pe.relari.srv_neg_employee_configuration_v1.employee.util;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeRequest;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Company;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Contact;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Credential;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.entity.EmployeeEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.StringJoiner;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TestMapper {

  private static final Integer idEmployee = 1;
  private static final String password = "$2a$10$VgrbuoTcdzHz1NgP2/0IheTHbNhGm9dxgGOrLdd4SA1l4UWuh8B6i";
  private static final Boolean isActive = true;
  private static final LocalDateTime dateCreated = LocalDateTime.now();

  public static EmployeeRequest employeeRequest() {
    return TestJsonConverter.readDataFromFileJson(
            TestConstant.employeeJson, EmployeeRequest.class
    );
  }

  public static Employee employee() {
    var request = employeeRequest();
    return Employee.builder()
        .idEmployee(idEmployee)
        .firstName(request.getFirstName())
        .fatherLastName(request.getFatherLastName())
        .motherLastName(request.getMotherLastName())
        .gender(GenderCategory.valueOf(request.getGender()))
        .birthdate(Utility.mapLocalDate(request.getBirthdate()))
        .contact(new Contact(request.getContactInfo()))
        .credential(new Credential(buildUsername(request), password))
        .company(new Company(
                JobTitleCategory.valueOf(request.getCompany().getJobTitle()),
                request.getCompany().getSalary()
        ))
        .isActive(isActive)
        .creationDate(dateCreated)
        .build();
  }

  public static String buildUsername(EmployeeRequest request) {
    return new StringJoiner(Constants.POINT)
            .add(request.getFirstName())
            .add(request.getFatherLastName())
            .toString()
            .toLowerCase();
  }

  public static EmployeeEntity employeeEntity() {
    var employee = employee();
    return EmployeeEntity.builder()
        .id(idEmployee)
        .firstName(employee.getFirstName())
        .fatherLastName(employee.getFatherLastName())
        .motherLastName(employee.getMotherLastName())
        .gender(employee.getGender())
        .birthdate(employee.getBirthdate())
//        .email(employee.getContact().getEmail())
//        .phoneNumber(employee.getContact().getPhoneNumber())
//        .username(Utility.buildUsername(employee.getFirstName(), employee.getFatherLastName()))
//        .password(password)
//        .jobTitle(employee.getCompany().getJobTitle())
//        .salary(employee.getCompany().getSalary())
        .creationDate(dateCreated)
        .isActive(employee.getIsActive())
        .build();
  }
}
