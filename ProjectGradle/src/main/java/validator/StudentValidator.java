package validator;

import entity.Student;
import exception.ValidationException;
import org.apache.commons.validator.routines.EmailValidator;

class StudentValidator implements Validator<Student> {

  static void validate(Student entity) throws ValidationException {
    EmailValidator mail = EmailValidator.getInstance();
    if (entity.getFirstName().equals("") || entity.getLastName().equals(""))
      throw new ValidationException("Invalid student!");
    if(!mail.isValid(entity.getEmail()))
      throw new ValidationException("Email is invalid!");
  }
}
