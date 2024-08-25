package com.pe.relari.srv_neg_employee_configuration_v1.employee.dao.impl;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.ContactInfo;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.entity.EmployeeEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeMapper {

  static Employee mapEmployee(EmployeeEntity employeeEntity) {
    return Employee.builder()
            .idEmployee(employeeEntity.getId())
            .firstName(employeeEntity.getFirstName())
            .fatherLastName(employeeEntity.getFatherLastName())
            .motherLastName(employeeEntity.getMotherLastName())
            .gender(employeeEntity.getGender())
            .jobTitle(employeeEntity.getJobTitle())
            .salary(employeeEntity.getSalary())
            .isActive(employeeEntity.getIsActive())
            .birthdate(employeeEntity.getBirthdate())
            .contactInfo(
                    new ContactInfo(
                            employeeEntity.getEmail(), employeeEntity.getPhoneNumber()
                    )
            )
            .build();
  }

  static EmployeeEntity mapEmployeeEntity(Employee employee) {
    return EmployeeEntity.builder()
            .firstName(employee.getFirstName())
            .fatherLastName(employee.getFatherLastName())
            .motherLastName(employee.getMotherLastName())
            .gender(employee.getGender())
            .jobTitle(employee.getJobTitle())
            .salary(employee.getSalary())
            .isActive(employee.getIsActive())
            .birthdate(employee.getBirthdate())
            .creationDate(LocalDateTime.now())
            .email(employee.getContactInfo().getEmail())
            .phoneNumber(employee.getContactInfo().getPhoneNumber())
            .build();
  }

}
