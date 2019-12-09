package entity;


import com.sun.tools.javac.util.Pair;

import java.util.Vector;

public class Report<ID> extends Entity<ID> {
  private float average = 0;
  private Vector<Pair<Integer, Integer>> homeworkGrades;

  public float getAverage() {
    return average;
  }

  public void setAverage(float average) {
    this.average = average;
  }

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  private Student student;

  public Report() {
    super();
    homeworkGrades = new Vector<>();
  }

  @Override
  public String toFile() {
    return student.toFile()+";"+String.valueOf(average);
  }

  @Override
  public String info() {
    return String.format("Student %s has an average of %f",student.getFirstName(), average);
  }

  public void addGrade(int grade, int weight) {
    homeworkGrades.add(new Pair<>(grade, weight));
  }

  public void calculateAverage() {
    int grades=0,weights=0;
    for (Pair<Integer, Integer> x: homeworkGrades) {
      grades+=x.fst * x.snd;
      weights+=x.snd;
    }

    average = (float) grades / weights;
  }
}
