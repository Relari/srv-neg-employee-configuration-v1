package com.pe.relari.srv_neg_employee_configuration_v1.employee.dao.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.entity.EmployeeEntity;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.TestMapper;
import org.junit.jupiter.api.Test;

class EmployeeMapperTest {

  @Test
  void mapEmployee() {

    EmployeeEntity employeeEntity = TestMapper.employeeEntity();

    Employee employee = EmployeeMapper.mapEmployee(employeeEntity);

    assertEquals(employeeEntity.getFirstName(), employee.getFirstName());

  }

  @Test
  void mapPersonResponse() {

    Employee employee = TestMapper.employee();
    EmployeeEntity employeeEntity = EmployeeMapper.mapEmployeeEntity(employee);

    assertEquals(employee.getFirstName(), employeeEntity.getFirstName());
  }

}
