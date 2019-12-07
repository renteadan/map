package validator;

import entity.*;
import exception.ValidationException;


public interface Validator<E extends Entity> {
  static void validate(Object entity) throws ValidationException {
    switch (entity.getClass().getSimpleName()) {
      case "Student":
        assert entity instanceof Student;
        StudentValidator.validate((Student) entity);
        break;
      case "Homework":
        assert entity instanceof Homework;
        HomeworkValidator.validate((Homework) entity);
        break;
      case "Grade":
        assert entity instanceof Grade;
        GradeValidator.validate((Grade) entity);
        break;
      default:
        throw new ValidationException("Class doesn't have validator");
    }
  }
}
