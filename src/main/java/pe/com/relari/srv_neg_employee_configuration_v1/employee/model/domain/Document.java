package pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.DocumentRequest;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.util.DocumentTypeCategory;

@Getter
@AllArgsConstructor
public class Document {
    
    private DocumentTypeCategory type;
    private String number;

    public Document(DocumentRequest request) {
        this.type = DocumentTypeCategory.valueOf(request.getType());
        this.number = request.getNumber();
    }
}
