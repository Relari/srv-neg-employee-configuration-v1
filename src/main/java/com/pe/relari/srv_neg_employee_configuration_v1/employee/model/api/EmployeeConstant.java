package com.pe.relari.srv_neg_employee_configuration_v1.employee.model.api;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class EmployeeConstant {

  static final String REGEXP_ONLY_LETTERS = "[a-zA-Z]*";
  static final String REGEXP_SEX = "M|F";
  static final String REGEXP_LETTERS_AND_NUMBERS = "[a-zA-Z0-9]";

}
