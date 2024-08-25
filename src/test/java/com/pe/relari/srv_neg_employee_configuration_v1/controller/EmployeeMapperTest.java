package com.pe.relari.srv_neg_employee_configuration_v1.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeRequest;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.PersonResponse;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.TestMapper;

import org.junit.jupiter.api.Test;

class EmployeeMapperTest {

  @Test
  void mapEmployee() {

    EmployeeRequest employeeRequest = TestMapper.employeeRequest();

    Employee employee = EmployeeMapper.mapEmployee(employeeRequest);

    assertEquals(employeeRequest.getFirstName(), employee.getFirstName());

  }

  @Test
  void mapPersonResponse() {

    Employee employee = TestMapper.employee();
    PersonResponse personResponse = EmployeeMapper.mapPersonResponse(employee);

    assertEquals(employee.getFirstName(), personResponse.getFirstName());
  }

}
