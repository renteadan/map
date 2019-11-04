package com.company.validator;

import com.company.entity.Entity;
import com.company.entity.Grade;
import com.company.exception.ValidationException;

class GradeValidator<E extends Entity> implements Validator<E> {

  static void validate(Grade entity) throws ValidationException {
    if (entity.getGrade() < 1 || entity.getGrade() > 10)
      throw new ValidationException("Incorrect grade!");
    if (entity.getProfessor().equals(""))
      throw new ValidationException("Invalid professor");
    if (entity.getStudentId() == null)
      throw new ValidationException("Student ID couldn't be found!");
    if(entity.getHomeworkId() == null)
      throw new ValidationException("Homework ID couldn't be found!");
  }
}
