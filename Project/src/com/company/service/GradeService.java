package com.company.service;

import com.company.entity.Grade;
import com.company.entity.Homework;
import com.company.entity.Student;
import com.company.entity.StudyYear;
import com.company.exception.ValidationException;
import com.company.repository.GradeFileRepo;
import com.github.cliftonlabs.json_simple.JsonObject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Vector;

@SuppressWarnings("unchecked")
public class GradeService<ID> extends AbstractService<ID, Grade<ID>> {
  private static GradeService instance = null;
  private static GradeService instanceFile = null;
  private StudentService<ID> sService;
  private HomeworkService<ID> hService;

  private GradeService() {
    super();
    sService = StudentService.getInstance();
    hService = HomeworkService.getInstance();
  }

  public static GradeService getInstance() {
    if (instance == null)
      instance = new GradeService();
    return instance;
  }

  private GradeService(String file) {
    super();
    GradeFileRepo<ID> repo = new GradeFileRepo<>(file);
    setRepo(repo);
    sService = StudentService.getFileInstance("students");
    hService = HomeworkService.getFileInstance("homeworks");
  }

  public static GradeService getFileInstance(String filename) {
    if (instanceFile == null)
      instanceFile = new GradeService(filename);
    return instanceFile;
  }

  @Override
  public Grade<ID> add(Grade<ID> entity) throws ValidationException {
    Student<ID> st = sService.find(entity.getStudentId());
    Homework<ID> hm = hService.find(entity.getHomeworkId());
    if (st == null || hm == null)
      throw new ValidationException("Invalid foreign key");
    entity.setStudent(st);
    entity.setHomework(hm);
    HashSet<Integer> vec = st.getMotivari();
    int motivari = StudyYear.getMotivariBetween(hm.getEndWeek(), StudyYear.getCurrentWeek(), st.getMotivari());
    if (hm.getMaxGrade(motivari) == 1)
      entity.setGrade(1);
    else
      entity.setGrade(entity.getGrade() + motivari);
    Grade<ID> aux = super.add(entity);
    if (aux != null)
      return aux;
    JsonObject grade = entity.toEmail();
    writeJson(grade, st.getFirstName() + "_" + st.getLastName());
    return null;
  }

  private void writeJson(JsonObject grade, String full_name) {
    try (BufferedWriter pw = new BufferedWriter(new FileWriter(full_name, true))) {
      pw.append(grade.toString()).append("\n");
    } catch (IOException err) {
      System.out.println(err.getMessage());
    }
  }

  @Override
  public Grade<ID> find(ID id) {
    Grade<ID> grade = super.find(id);
    if (grade == null)
      return null;
    if (grade.getStudent() == null)
      grade.setStudent(sService.find(grade.getStudentId()));
    if (grade.getHomework() == null)
      grade.setHomework(hService.find(grade.getHomeworkId()));
    return grade;
  }

  public boolean isHomeworkGraded(ID studentId, ID homeworkId) {
    for (Grade x : getAll()) {
      if (x.getHomeworkId().equals(homeworkId) && x.getStudentId().equals(studentId))
        return true;
    }
    return false;
  }

  public Vector<Student> getStudentsByHomework(ID homeworkId) {
    Vector<Student> vec = new Vector<>();
    for(Grade x:getAll()) {
      if (x.getHomeworkId().equals(homeworkId))
        vec.add(find((ID) x.getId()).getStudent());
    }
    return vec;
  }

  public Vector<Student> getStudentsByHomeworkAndProfessor(ID homeworkId, String professor) {
    Vector<Student> vec = new Vector<>();
    for(Grade x:getAll()) {
      if (x.getHomeworkId().equals(homeworkId) && x.getProfessor().equals(professor))
        vec.add(find((ID) x.getId()).getStudent());
    }
    return vec;
  }

  public Vector<Grade> getGradesByHomeworkAndWeek(ID homeworkId, int week) {
    Vector<Grade> vec = new Vector<>();
    for(Grade x:getAll()) {
      if (x.getHomeworkId().equals(homeworkId) && StudyYear.getWeekOf(x.getDate()) == week)
        vec.add(find((ID) x.getId()));
    }
    return vec;
  }
}
