package com.pe.relari.srv_neg_employee_configuration_v1.employee.service.impl;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.dao.EmployeeDao;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.service.EmployeeService;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * <b>Class:</b> EmployeeServiceImpl.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Service
@AllArgsConstructor
class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeDao employeeDao;

  @Override
  public Observable<Employee> findAll() {
    return employeeDao.findAll();
  }

  @Override
  public Completable save(Employee employee) {
    return employeeDao.save(employee);
  }

  @Override
  public Single<Employee> findById(Integer id) {
    return employeeDao.findById(id);
  }

  @Override
  public Single<Employee> findByUsername(String username) {
    return employeeDao.findByUsername(username);
  }

  @Override
  public Completable deleteByUsername(String username) {
    return employeeDao.findByUsername(username)
            .flatMapCompletable(employee ->
                    employeeDao.deleteById(employee.getIdEmployee())
            );
  }

}
