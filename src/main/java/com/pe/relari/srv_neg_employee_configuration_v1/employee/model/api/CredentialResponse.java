package com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Credential;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.JobTitleCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CredentialResponse {

    private String username;
    private String password;
    private String role;

    public CredentialResponse(Credential credential, JobTitleCategory jobTitle) {
        this.username = credential.getUsername();
        this.password = credential.getPassword();
        this.role = jobTitle.name();
    }

}
