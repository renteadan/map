package validator;

import entity.Report;
import exception.ValidationException;

public class ReportValidator implements Validator<Report> {
  static void validate(Report r) throws ValidationException {
    if (r.getAverage() < 1.f)
      throw new ValidationException("Average must be above 1!");
    if (r.getStudent() == null)
      throw new ValidationException("No student is set for the report!");
  }
}
