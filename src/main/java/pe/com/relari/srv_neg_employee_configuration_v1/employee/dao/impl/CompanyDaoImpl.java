package pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.impl;

import io.reactivex.Completable;
import io.reactivex.Single;
import lombok.AllArgsConstructor;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.CompanyDao;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.dao.repository.CompanyRepository;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Company;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;

import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CompanyDaoImpl implements CompanyDao {

    CompanyRepository contactRepository;
    EmployeeToEntityMapper mapper;

    @Override
    public Completable save(Employee employee, Company company) {
        return Single.fromCallable(() -> mapper.mapCompanyEntity(employee, company))
                .map(contactRepository::save)
                .ignoreElement();
    }
}
