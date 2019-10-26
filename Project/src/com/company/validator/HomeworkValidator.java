package com.company.validator;

import com.company.entity.Homework;
import com.company.exception.ValidationException;

public class HomeworkValidator implements Validator<Homework> {
  @Override
  public void validate(Homework entity) throws ValidationException {
    if(entity.getStartWeek() > entity.getEndWeek() || entity.getStartWeek() < 1 || entity.getEndWeek() < 1)
      throw new ValidationException("Invalid homework!");
  }
}
