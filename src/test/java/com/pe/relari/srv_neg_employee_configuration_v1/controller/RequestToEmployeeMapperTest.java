package com.pe.relari.srv_neg_employee_configuration_v1.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeRequest;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeResponse;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.TestMapper;

import org.junit.jupiter.api.Test;

class RequestToEmployeeMapperTest {

  @Test
  void mapEmployee() {

    EmployeeRequest employeeRequest = TestMapper.employeeRequest();

    Employee employee = RequestToEmployeeMapper.mapEmployee(employeeRequest);

    assertEquals(employeeRequest.getFirstName(), employee.getFirstName());

  }

  @Test
  void mapPersonResponse() {

    Employee employee = TestMapper.employee();
    EmployeeResponse employeeResponse = RequestToEmployeeMapper.mapPersonResponse(employee);

    assertEquals(employee.getFirstName(), employeeResponse.getFirstName());
  }

}
