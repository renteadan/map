package com.company.validator;

import com.company.entity.Student;
import com.company.exception.ValidationException;

public class StudentValidator implements Validator<Student> {
  @Override
  public void validate(Student entity) throws ValidationException {
    if (entity.getFirstName().equals("") || entity.getLastName().equals(""))
      throw new ValidationException("Invalid student!");
  }
}
