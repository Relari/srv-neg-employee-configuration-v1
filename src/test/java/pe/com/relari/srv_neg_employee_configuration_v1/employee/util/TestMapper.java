package pe.com.relari.srv_neg_employee_configuration_v1.employee.util;

import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.api.EmployeeRequest;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Company;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Contact;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Credential;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.domain.Employee;
import pe.com.relari.srv_neg_employee_configuration_v1.employee.model.entity.EmployeeEntity;

import java.time.LocalDateTime;

public class TestMapper {

  private static final Integer idEmployee = 1;
  private static final String password = "$2a$10$VgrbuoTcdzHz1NgP2/0IheTHbNhGm9dxgGOrLdd4SA1l4UWuh8B6i";
  private static final Boolean isActive = true;
  private static final LocalDateTime dateCreated = LocalDateTime.now();

  private TestMapper() {}
  
  public static EmployeeRequest employeeRequest() {
    return TestJsonConverter.readDataFromFileJson(
            TestConstant.employeeJson, EmployeeRequest.class
    );
  }

  public static Employee employee() {
    var request = employeeRequest();
    return Employee.builder()
        .idEmployee(idEmployee)
        .firstName(request.getFirstName())
        .fatherLastName(request.getFatherLastName())
        .motherLastName(request.getMotherLastName())
        .gender(GenderCategory.valueOf(request.getGender()))
        .birthdate(Utility.mapLocalDate(request.getBirthdate()))
        .documentType(DocumentTypeCategory.valueOf(request.getDocumentType()))
        .documentNumber(request.getDocumentNumber())
        .contact(new Contact(request.getContactInfo()))
        .credential(new Credential(
                Utility.buildUsername(request.getFirstName(), request.getFatherLastName()),
                password
        ))
        .company(new Company(request.getCompany()))
        .isActive(isActive)
        .creationDate(dateCreated)
        .build();
  }

  public static EmployeeEntity employeeEntity() {
    var employee = employee();
    return EmployeeEntity.builder()
        .id(employee.getIdEmployee())
        .firstName(employee.getFirstName())
        .fatherLastName(employee.getFatherLastName())
        .motherLastName(employee.getMotherLastName())
        .gender(employee.getGender())
        .birthdate(employee.getBirthdate())
        .documentType(employee.getDocumentType())
        .documentNumber(employee.getDocumentNumber())

        .email(employee.getContact().getEmail())
        .phoneNumber(employee.getContact().getPhoneNumber())

        .username(Utility.buildUsername(
                employee.getFirstName(), employee.getFatherLastName()
        ))
        .password(password)

        .jobTitle(employee.getCompany().getJobTitle())
        .salary(employee.getCompany().getSalary())

        .creationDate(dateCreated)
        .isActive(employee.getIsActive())
        .build();
  }
}
