package com.company.validator;

import com.company.entity.Student;
import com.company.exception.ValidationException;

class StudentValidator implements Validator<Student> {

  static void validate(Student entity) throws ValidationException {
    if (entity.getFirstName().equals("") || entity.getLastName().equals(""))
      throw new ValidationException("Invalid student!");
  }
}
