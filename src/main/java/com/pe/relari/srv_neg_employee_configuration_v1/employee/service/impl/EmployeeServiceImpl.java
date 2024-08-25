package com.pe.relari.srv_neg_employee_configuration_v1.employee.service.impl;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.dao.EmployeeDao;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.service.EmployeeService;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.topic.SampleProducer;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import reactor.adapter.rxjava.RxJava2Adapter;

/**
 * <b>Class:</b> EmployeeServiceImpl.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Service
@AllArgsConstructor
class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeDao employeeDao;
  private final SampleProducer sampleProducer;

  @Override
  public Observable<Employee> findAll() {
    return employeeDao.findAll();
  }

  @Override
  public Completable save(Employee employee) {
    return employeeDao.save(employee)
            .andThen(RxJava2Adapter.monoToCompletable(
                    sampleProducer.sendMessages(employee)
            ));
  }

  @Override
  public Single<Employee> findById(Integer id) {
    return employeeDao.findById(id);
  }
  
}
