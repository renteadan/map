package com.company.validator;

import com.company.entity.Entity;
import com.company.entity.Homework;
import com.company.exception.ValidationException;

public class HomeworkValidator<E extends Entity> implements Validator<E> {
  static void validate(Homework entity) throws ValidationException {
    if (entity.getStartWeek() > entity.getEndWeek() || entity.getStartWeek() < 1 || entity.getEndWeek() < 1)
      throw new ValidationException("Invalid homework!");
  }
}
