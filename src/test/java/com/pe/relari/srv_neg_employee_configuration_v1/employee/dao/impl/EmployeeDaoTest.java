package com.pe.relari.srv_neg_employee_configuration_v1.employee.dao.impl;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.dao.repository.EmployeeRepository;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.TestMapper;
import io.reactivex.observers.TestObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

class EmployeeDaoTest {

  @Mock
  private EmployeeRepository employeeRepository;

  @InjectMocks
  private EmployeeDaoImpl employeeDao;

  @BeforeEach
  void init() throws Exception {
    MockitoAnnotations.openMocks(this).close();
  }

  @Test
  void whenFindAllThenReturnListEmployees() {

    Mockito.when(employeeRepository.findAll())
        .thenReturn(Collections.singletonList(TestMapper.employeeEntity()));

    TestObserver<Employee> testObserver = employeeDao.findAll().test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

  @Test
  void whenFindByIdThenReturnEmployee() {

    Mockito.when(employeeRepository.findById(Mockito.anyInt()))
        .thenReturn(Optional.of(TestMapper.employeeEntity()));

    TestObserver<Employee> testObserver = employeeDao.findById(1).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

  @Test
  void whenSaveEmployeeThenReturnEmployee() {

    Mockito.when(employeeRepository.save(Mockito.any()))
        .thenReturn(TestMapper.employeeEntity());

    TestObserver<Void> testObserver = employeeDao.save(TestMapper.employee()).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

  @Test
  void whenFindByIdThenReturnEmpty() {

    Mockito.when(employeeRepository.findById(Mockito.anyInt()))
            .thenReturn(Optional.empty());

    TestObserver<Employee> testObserver = employeeDao.findById(1).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertNotComplete().assertNoValues();

  }

  @Test
  void whenSaveEmployeeThenReturnError() {

//    Mockito.when(errorFactory.buildException(Mockito.any(), Mockito.any()))
//            .thenReturn(new RuntimeException());

    Mockito.when(employeeRepository.save(Mockito.any()))
            .thenReturn(new Throwable());

    TestObserver<Void> testObserver = employeeDao.save(TestMapper.employee()).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertNotComplete().assertNoValues();

  }

//  private RuntimeException employeeException() {
//    return errorFactory.buildException(ErrorCategory.EMPLOYEE_NOT_SAVE, null);
//  }

}
