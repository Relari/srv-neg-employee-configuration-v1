package com.pe.relari.srv_neg_employee_configuration_v1.employee.dao.impl;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.exception.ApiException;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.exception.ErrorCategory;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.entity.EmployeeEntity;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.dao.repository.EmployeeRepository;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.dao.EmployeeDao;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * <b>Class:</b> EmployeeDaoImpl.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Slf4j
@Component
@AllArgsConstructor
class EmployeeDaoImpl implements EmployeeDao {

  private final EmployeeRepository employeeRepository;
  private final EmployeeToEntityMapper employeeToEntityMapper;

  @Override
  public Observable<Employee> findAll() {
    return Observable.fromCallable(employeeRepository::findAll)
        .subscribeOn(Schedulers.io())
        .flatMapIterable(employeeEntities -> employeeEntities)
        .map(employeeToEntityMapper::mapEmployee)
        .doOnNext(employee -> log.trace(employee.toString()))
        .doOnSubscribe(disposable -> log.debug("Starting to list the employees."))
        .doOnComplete(() -> log.info("The list of employees is completely ready."));
  }

  @Override
  public Completable save(Employee employee) {
    return Single.fromCallable(() -> employeeToEntityMapper.mapEmployeeEntity(employee))
        .map(employeeRepository::save)
        .subscribeOn(Schedulers.io())
        .onErrorResumeNext(throwable ->
                Single.error(
                        ApiException.of(ErrorCategory.EMPLOYEE_NOT_SAVE, throwable)
                )
        )
        .doOnSubscribe(disposable ->
                log.debug("Starting to save the employee."))
        .doOnError(throwable ->
                log.error("An error occurred while saving the employee.", throwable))
        .ignoreElement()
        .doOnComplete(() ->
                log.info("The employee was successfully saved."));
  }

  @Override
  public Single<Employee> findById(Integer id) {

    return Single.fromCallable(() -> findBy(id))
        .subscribeOn(Schedulers.io())
        .map(employeeToEntityMapper::mapEmployee)
        .doOnSubscribe(disposable ->
                log.debug("Consulting the employee with [id={}]", id))
        .doOnError(throwable ->
                log.error("Employee not found - [id={}]", id, throwable))
        .doOnSuccess(employee ->
                log.info("The employee was found with the [id={}]", id));
  }

  private EmployeeEntity findBy(Integer id) {
    return employeeRepository.findById(id)
            .orElseThrow(() ->
                    ApiException.of(ErrorCategory.EMPLOYEE_NOT_FOUND)
            );
  }

}
