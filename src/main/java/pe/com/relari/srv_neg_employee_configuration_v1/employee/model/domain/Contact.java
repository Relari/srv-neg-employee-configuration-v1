package pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.ContactRequest;

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
