package com.company.entity;

import com.github.cliftonlabs.json_simple.JsonObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Grade<ID> extends Entity<ID> {
  private Student<ID> student;

  public Grade() {
  }

  private Homework<ID> homework;
  private ID studentId, homeworkId;
  private String professor, feedback;
  private LocalDateTime date;
  private int grade;
  private static final String pattern = "yyyy-MM-dd HH:mm";
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

  public void setStudentId(ID studentId) {
    this.studentId = studentId;
  }

  public void setHomeworkId(ID homeworkId) {
    this.homeworkId = homeworkId;
  }

  public void setProfessor(String professor) {
    this.professor = professor;
  }

  public void setFeedback(String feedback) {
    this.feedback = feedback;
  }

  public Grade(ID id, ID studentId, ID homeworkId, String professor, int grade, String feedback) {
    super(id);
    this.studentId = studentId;
    this.homeworkId = homeworkId;
    this.professor = professor;
    this.grade = grade;
    this.feedback = feedback;
    date = LocalDateTime.now();
  }

  @SuppressWarnings("unchecked")
  public Grade(String[] args) {
    super((ID) args[0]);
    this.studentId = (ID) args[1];
    this.homeworkId = (ID) args[2];
    this.professor = args[3];
    this.date = LocalDateTime.parse(args[4], formatter);
    this.grade = Integer.parseInt(args[5]);
    this.feedback = args[6];
  }

  @Override
  public String toFile() {
    return String.format("%s;%s;%s;%s;%s;%d;%s", id, studentId, homeworkId, professor, date.format(formatter), grade, feedback);
  }

  public JsonObject toEmail() {
    JsonObject aux = new JsonObject();
    aux.put("tema", homeworkId);
    aux.put("nota", grade);
    aux.put("predata", StudyYear.getWeekOf(date));
    aux.put("deadline", homework.getEndWeek());
    aux.put("feedback", feedback);
    return aux;
  }

  @Override
  public String info() {
    return String.format("ID=%s.The grade is %d, for student %s from professor %s." +
        "It was given on %s, for homework %s. Feedback is: %s", id, grade, studentId, professor, date, homeworkId, feedback);
  }

  public ID getStudentId() {
    return studentId;
  }

  public ID getHomeworkId() {
    return homeworkId;
  }

  public String getProfessor() {
    return professor;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public int getGrade() {
    return grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public Student<ID> getStudent() {
    return student;
  }

  public void setStudent(Student<ID> student) {
    this.student = student;
  }

  public Homework<ID> getHomework() {
    return homework;
  }

  public void setHomework(Homework<ID> homework) {
    this.homework = homework;
  }

  public String getFeedback() {
    return feedback;
  }
}
