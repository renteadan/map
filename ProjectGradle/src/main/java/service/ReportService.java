package service;

import com.sun.tools.javac.util.Pair;
import entity.Grade;
import entity.Homework;
import entity.Report;
import entity.Student;
import exception.ValidationException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

public class ReportService<ID> extends AbstractService<ID, Report<ID>> {
  private GradeService<ID> gradeService;

  @SuppressWarnings("unchecked")
  public ReportService() {
    super();
    gradeService = GradeService.getInstance();
  }

  @SuppressWarnings("unchecked")
  public ReportService(GradeService gr) {
    super();
    gradeService = gr;
  }

  private Vector<Report> groupGrades() {
    HashMap<String ,Report> grades = new HashMap<>();
    for(Grade x: gradeService.getAll()) {
      if(grades.containsKey(x.getName())) {
        Report r = grades.get(x.getName());
        r.addGrade(x.getGrade(), x.getHomework().getWeight());
        grades.replace(x.getName(), r);
      } else {
        Report r = new Report();
        r.setStudent(x.getStudent());
        r.addGrade(x.getGrade(), x.getHomework().getWeight());
        grades.put(x.getName(), r);
      }
    }
    return new Vector<>(grades.values());
  }
  public void calculateAll() {
    Vector<Report> reps = groupGrades();
    for(Report r: reps) {
      r.calculateAverage();
      try {
        this.add(r);
      } catch (ValidationException ignored) {
      }
    }
  }

  public Iterable<Report> getOnTimeStudents() {
    HashSet<Student> set = gradeService.getOnTimeStudents();
    Vector<Report> aux = new Vector<>();
    for(Report x: getAll()) {
      if(set.contains(x.getStudent()))
        aux.add(x);
    }
    return aux;
  }

  public Pair<Homework, Float> hardestHomework() {
    return gradeService.hardestHomework();
  }

  public Iterable<Report> getExamStudents() {
    Vector<Report> aux = new Vector<>();
    for(Report x: getAll()) {
      if (x.getAverage() > 4.0f)
        aux.add(x);
    }
    return aux;
  }

  @Override
  public Report<ID> add(Report<ID> entity) throws ValidationException {
    return super.getRepo().save(entity);
  }
}
