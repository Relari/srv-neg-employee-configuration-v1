package pe.com.relari.srv_neg_employee_configuration_v1.employee.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;

import pe.com.relari.srv_neg_employee_configuration_v1.employee.annotation.impl.JobTitleImpl;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = JobTitleImpl.class)
public @interface JobTitle {

  String message() default "";

  Class<?>[] groups() default { };

  Class<? extends Payload>[] payload() default { };

  int[] values() default {};
}
