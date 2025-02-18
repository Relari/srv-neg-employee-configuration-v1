package pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.impl;

import io.reactivex.Completable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.ContactDao;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository.ContactRepository;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Contact;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;

import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ContactDaoImpl implements ContactDao {

    ContactRepository contactRepository;
    EmployeeToEntityMapper mapper;

    @Override
    public Completable save(Employee employee, Contact contact) {
        return Single.fromCallable(() -> mapper.mapContactEntity(employee, contact))
                .map(contactRepository::save)
                .ignoreElement();
    }
}
