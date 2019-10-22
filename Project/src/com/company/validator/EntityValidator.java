package com.company.validator;

import com.company.entity.Entity;
import com.company.entity.Homework;
import com.company.entity.Student;
import com.company.exception.ValidationException;

public class EntityValidator<E extends Entity> implements Validator<E> {
  @Override
  public void validate(E entity) throws ValidationException {
    switch (entity.getClass().getSimpleName()) {
      case "Student":
        assert entity instanceof Student;
        new StudentValidator().validate((Student) entity);
        break;
      case "Homework":
        assert entity instanceof Homework;
        new HomeworkValidator().validate((Homework) entity);
        break;
      default:
        throw new ValidationException("Class doesn't have validator");
    }
  }
}
