package com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api.ContactRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Contact {

    private String email;
    private String phoneNumber;

    public Contact(ContactRequest request) {
        this.email = request.getEmail();
        this.phoneNumber = request.getPhoneNumber();
    }
}
