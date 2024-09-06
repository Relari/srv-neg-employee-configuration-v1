//package com.pe.relari.srv_neg_employee_configuration_v1.controller;
//
//import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeResponse;
//import com.pe.relari.srv_neg_employee_configuration_v1.employee.service.EmployeeService;
//import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.TestMapper;
//import io.reactivex.Completable;
//import io.reactivex.Observable;
//import io.reactivex.Single;
//import io.reactivex.observers.TestObserver;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//
//import org.mockito.MockitoAnnotations;
//
//class GetEmployeesControllerTest {
//
//  @Mock
//  private EmployeeService employeeService;
//
//  @InjectMocks
//  private GetEmployeesController getEmployeesController;
//
//  @BeforeEach
//  void init() throws Exception {
//    MockitoAnnotations.openMocks(this).close();
//  }
//
//  @Test
//  void whenFindAllThenReturnListEmployees() {
//
//    var employee = TestMapper.employee();
//
//    Mockito.when(employeeService.findAll())
//        .thenReturn(Observable.just(employee));
//
//    TestObserver<EmployeeResponse> testObserver = getEmployeesController.listOfEmployees().test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors()
//        .assertValue(personInformationResponse -> personInformationResponse.getFirstName().equals(employee.getFirstName()))
//        .assertValue(personInformationResponse -> personInformationResponse.getFatherLastName().equals(employee.getFatherLastName()))
//        .assertValue(personInformationResponse -> personInformationResponse.getMotherLastName().equals(employee.getMotherLastName()))
//        .assertValue(personInformationResponse -> personInformationResponse.getGender().equals(employee.getGender().name()));
//
//  }
//
//  @Test
//  void whenSaveEmployeeThenReturnSuccessful() {
//    Mockito.when(employeeService.save(Mockito.any()))
//        .thenReturn(Completable.complete());
//
//    TestObserver<Void> testObserver =
//        getEmployeesController.save(TestMapper.employeeRequest()).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors();
//
//  }
//
//  @Test
//  void whenFindByIdThenReturnEmployee() {
//
//    var employee = TestMapper.employee();
//
//    Mockito.when(employeeService.findById(Mockito.anyInt()))
//        .thenReturn(Single.just(TestMapper.employee()));
//
//    TestObserver<EmployeeResponse> testObserver = getEmployeesController.findEmployeeById(1).test();
//
//    testObserver.awaitTerminalEvent();
//
//    testObserver.assertComplete().assertNoErrors()
//        .assertValue(personInformationResponse -> personInformationResponse.getFirstName().equals(employee.getFirstName()))
//        .assertValue(personInformationResponse -> personInformationResponse.getFatherLastName().equals(employee.getFatherLastName()))
//        .assertValue(personInformationResponse -> personInformationResponse.getMotherLastName().equals(employee.getMotherLastName()));
//
//  }
//
//}
