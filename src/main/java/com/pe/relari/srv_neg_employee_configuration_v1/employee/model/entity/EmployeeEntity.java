package com.pe.relari.srv_neg_employee_configuration_v1.employee.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.JobTitleCategory;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.GenderCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <b>Class:</b> EmployeeEntity.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Entity
@Table(name = "EMPLOYEE")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "fatherLastName", length = 50, nullable = false)
  private String fatherLastName;

  @Column(name = "motherLastName", length = 50, nullable = false)
  private String motherLastName;

  @Column(name = "firstName", length = 50, nullable = false)
  private String firstName;

  @Enumerated(EnumType.STRING)
  @Column(name = "jobTitle", length = 50, nullable = false)
  private JobTitleCategory jobTitle;

  @Enumerated(EnumType.STRING)
  @Column(name = "gender", length = 1, nullable = false)
  private GenderCategory gender;

  @Column(name = "salary", nullable = false)
  private Double salary;

  @Column(name = "isActive", nullable = false)
  private Boolean isActive;

  @Column(name = "birthdate", nullable = false, columnDefinition = "DATE")
  private LocalDate birthdate;

  @Column(name = "creationDate", nullable = false, columnDefinition = "TIMESTAMP")
  private LocalDateTime creationDate;

  @Column(name = "email", length = 50, nullable = false)
  private String email;

  @Column(name = "phoneNumber", length = 9, nullable = false)
  private String phoneNumber;

}
