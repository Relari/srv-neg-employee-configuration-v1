package com.pe.relari.srv_neg_employee_configuration_v1.employee.service;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * <b>Interface:</b> EmployeeService.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

public interface EmployeeService {

  Observable<Employee> findAll();

  Completable save(Employee employee);

  Single<Employee> findById(Integer id);

  Single<Employee> findByUsername(String username);
}
