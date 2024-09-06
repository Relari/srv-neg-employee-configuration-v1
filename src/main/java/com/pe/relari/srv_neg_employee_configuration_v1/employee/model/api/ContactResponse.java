package com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.model.domain.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContactResponse {

    private String email;
    private String phoneNumber;

    public ContactResponse(Contact contact) {
        this.email = contact.getEmail();
        this.phoneNumber = contact.getPhoneNumber();
    }

}
