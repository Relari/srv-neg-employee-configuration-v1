package com.pe.relari.srv_neg_employee_configuration_v1.employee.annotation.impl;

import com.pe.relari.srv_neg_employee_configuration_v1.employee.annotation.JobTitle;
import com.pe.relari.srv_neg_employee_configuration_v1.employee.util.JobTitleCategory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JobTitleImpl implements ConstraintValidator<JobTitle, String> {

  List<Integer> values;

  @Override
  public void initialize(JobTitle constraintAnnotation) {
    values = Arrays.stream(constraintAnnotation.values()).boxed().collect(Collectors.toList());
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
//    return values.contains(value);
    return JobTitleCategory.getJobTitles().contains(value);
  }
}
