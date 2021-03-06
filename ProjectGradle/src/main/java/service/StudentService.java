package service;

import entity.Student;
import entity.StudyYear;
import exception.ValidationException;
import repository.StudentFileRepo;
import repository.XmlRepo;

import java.util.Vector;

public class StudentService<ID> extends AbstractService<ID, Student<ID>> {
  private static StudentService instance = null;
  private static StudentService instanceFile = null;

  private StudentService() {
    super();
  }

  private StudentService(String file) {
    super();
    XmlRepo<ID, Student<ID>> repo = new XmlRepo<>(file);
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
    if (week > StudyYear.getCurrentWeek())
      throw new IllegalArgumentException("Cannot motivate a week in a future!");
    student.motivateWeek(week);
    update(student);
  }

  public Vector<Student> findStudentsByName(String name) {
    Vector<Student> vec = new Vector<>();
    for(Student x: getAll()) {
      if (x.getFirstName().toLowerCase().contains(name) || x.getLastName().toLowerCase().contains(name))
        vec.add(x);
    }
    return vec;
  }

  public Vector<Student> getStudentsFromGroup(String group) {
    Vector<Student> vec = new Vector<>();
    for(Student x:getAll()) {
      if (x.getGroup().equals(group))
        vec.add(x);
    }
    return vec;
  }
}
