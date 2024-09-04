package com.pe.relari.srv_neg_employee_configuration_v1.employee.model.entity;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.JobTitleCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "COMPANY")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "empresaId",referencedColumnName = "id")
//    private EmployeeEntity employee;

    @Enumerated(EnumType.STRING)
    @Column(name = "jobTitle", length = 50, nullable = false)
    private JobTitleCategory jobTitle;

    @Column(name = "salary", nullable = false)
    private Double salary;

}
