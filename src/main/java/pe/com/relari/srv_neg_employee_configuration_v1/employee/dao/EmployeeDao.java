package pe.com.relari.srv_neg_employee_configuration_v1.employee.dao;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;

/**
 * <b>Interface:</b> EmployeeDao.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

public interface EmployeeDao {

  Observable<Employee> findAll();

  Completable save(Employee employee);

  Single<Employee> findById(Integer id);

  Single<Employee> findByUsername(String username);

  Completable deleteById(Integer id);

}
