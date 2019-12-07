package validator;

import entity.Homework;
import exception.ValidationException;


public class HomeworkValidator implements Validator<Homework> {
  static void validate(Homework entity) throws ValidationException {
    if (entity.getStartWeek() > entity.getEndWeek() || entity.getStartWeek() < 1 || entity.getEndWeek() < 1)
      throw new ValidationException("Invalid start week or end week!");
  }
}
