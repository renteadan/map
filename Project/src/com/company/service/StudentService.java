package com.company.service;

import com.company.entity.Grade;
import com.company.entity.Homework;
import com.company.entity.Student;
import com.company.exception.ValidationException;
import com.company.repository.StudentFileRepo;

public class StudentService<ID> extends AbstractService<ID, Student<ID>> {
  private static StudentService instance = null;
  private static StudentService instanceFile = null;

  private StudentService() {
    super();
  }

  private StudentService(String file) {
    super();
    StudentFileRepo<ID> repo = new StudentFileRepo<>(file);
    setRepo(repo);
  }

  public static StudentService getInstance() {
    if (instance == null)
      instance = new StudentService();
    return instance;
  }

  public static StudentService getFileInstance(String filename) {
    if (instanceFile == null)
      instanceFile = new StudentService(filename);
    return instanceFile;
  }

  public void motivateWeek(int week, ID id) throws ValidationException {
    Student<ID> student = find(id);
    if (student == null)
      throw new IllegalArgumentException("Student doesn't exist!");
    if (week > Homework.getCurrentWeek())
      throw new IllegalArgumentException("Cannot motivate a week in a future!");
    student.motivateWeek(week);
    update(student);
  }
}
