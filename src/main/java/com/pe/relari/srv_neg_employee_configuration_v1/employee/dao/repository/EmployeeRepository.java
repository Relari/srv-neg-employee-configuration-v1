package com.pe.relari.srv_neg_employee_configuration_v1.employee.dao.repository;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.entity.EmployeeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * <b>Interface:</b> EmployeeRepository.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    Optional<EmployeeEntity> findByUsername(String username);

}
