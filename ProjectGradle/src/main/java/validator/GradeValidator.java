package validator;

import entity.Grade;
import exception.ValidationException;


class GradeValidator implements Validator<Grade> {

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
