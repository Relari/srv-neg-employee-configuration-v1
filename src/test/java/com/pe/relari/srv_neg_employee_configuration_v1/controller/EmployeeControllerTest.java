package com.pe.relari.srv_neg_employee_configuration_v1.controller;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.PersonResponse;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.TestMapper;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.observers.TestObserver;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {

  @Mock
  private EmployeeService employeeService;

  @InjectMocks
  private EmployeeController employeeController;

  @Test
  void whenFindAllThenReturnListEmployees() {

    var employee = TestMapper.employee();

    Mockito.when(employeeService.findAll())
        .thenReturn(Observable.just(employee));

    TestObserver<PersonResponse> testObserver = employeeController.listOfEmployees().test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors()
        .assertValue(personResponse -> personResponse.getFirstName().equals(employee.getFirstName()))
        .assertValue(personResponse -> personResponse.getFatherLastName().equals(employee.getFatherLastName()))
        .assertValue(personResponse -> personResponse.getMotherLastName().equals(employee.getMotherLastName()))
        .assertValue(personResponse -> personResponse.getGender().equals(employee.getGender().name()));

  }

  @Test
  void whenSaveEmployeeThenReturnSuccessful() {
    Mockito.when(employeeService.save(Mockito.any()))
        .thenReturn(Completable.complete());

    TestObserver<Void> testObserver =
        employeeController.save(TestMapper.employeeRequest()).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors();

  }

  @Test
  void whenFindByIdThenReturnEmployee() {

    var employee = TestMapper.employee();

    Mockito.when(employeeService.findById(Mockito.anyInt()))
        .thenReturn(Single.just(TestMapper.employee()));

    TestObserver<PersonResponse> testObserver = employeeController.findEmployeeById(1).test();

    testObserver.awaitTerminalEvent();

    testObserver.assertComplete().assertNoErrors()
        .assertValue(personResponse -> personResponse.getFirstName().equals(employee.getFirstName()))
        .assertValue(personResponse -> personResponse.getFatherLastName().equals(employee.getFatherLastName()))
        .assertValue(personResponse -> personResponse.getMotherLastName().equals(employee.getMotherLastName()));

  }

}
