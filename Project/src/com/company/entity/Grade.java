package com.company.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Grade<ID> extends Entity<ID> {
    private Student<ID> student;
    private Homework<ID> homework;
    private ID studentId,homeworkId;
    private String professor;
    private LocalDateTime date;
    private int grade;
    private String pattern = "yyyy-MM-dd HH:mm";
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

    public Grade(ID id, ID studentId, ID homeworkId, String professor, int grade) {
        super(id);
        this.studentId = studentId;
        this.homeworkId = homeworkId;
        this.professor = professor;
        this.grade = grade;
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
    }

    @Override
    public String toFile() {
        return String.format("%s;%s;%s;%s;%s;%d",id,studentId,homeworkId,professor,date.format(formatter),grade);
    }

    @Override
    public String info() {
        return String.format("%s.The grade is %d, for student %s from professor %s.It was given on %s, for homework %s", id, grade, studentId, professor, date, homeworkId);
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
}
