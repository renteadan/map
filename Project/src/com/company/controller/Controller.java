package com.company.controller;

import com.company.entity.Grade;
import com.company.entity.Homework;
import com.company.entity.Student;
import com.company.exception.ValidationException;
import com.company.service.GradeService;
import com.company.service.HomeworkService;
import com.company.service.StudentService;

import java.util.Scanner;

@SuppressWarnings("unchecked")
public class Controller<ID> {
  private StudentService<ID> studentService;
  private HomeworkService<ID> homeworkService;
  private GradeService<ID> gradeService;
  private Scanner kb;

  public Controller() {
    studentService = StudentService.getFileInstance("students");
    homeworkService = HomeworkService.getFileInstance("homeworks");
    gradeService = GradeService.getFileInstance("grades");
    kb = new Scanner(System.in);
  }

  private void init() {
    homeworkService.makeEmpty();
    studentService.makeEmpty();
    gradeService.makeEmpty();
  }

  private void printMenu() {
    System.out.println("1.Create student\n2.Find student\n3.Create homework\n4.Find homework\n" +
        "5.Display all students\n6.Display all homeworks\n7.Grade a student\n" +
        "0.Exit\n");
  }

  public void run() {
    while (true) {
      printMenu();
      System.out.println("Insert your command's number: ");
      int command = Integer.parseInt(kb.nextLine());
      try {
        switch (command) {
          case 0:
            return;
          case 1:
            createStudent();
            break;
          case 2:
            findStudent();
            break;
          case 3:
            createHomework();
            break;
          case 4:
            findHomework();
            break;
          case 5:
            findAllStudents();
            break;
          case 6:
            findAllHomeworks();
            break;
          case 7:
            createGrade();
            break;
          case 8:
            findAllGrades();
          default:
        }
      } catch (ValidationException | IllegalArgumentException | NullPointerException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  /**
   * @throws ValidationException create a student from keyboard input
   */
  private void createStudent() throws ValidationException {

    System.out.println("Insert id: ");
    ID id = (ID) kb.nextLine();
    System.out.println("Insert first name: ");
    String firstName = kb.nextLine();
    System.out.println("Insert last name: ");
    String lastName = kb.nextLine();
    System.out.println("Insert group: ");
    String group = kb.nextLine();
    System.out.println("Insert email: ");
    String email = kb.nextLine();
    Student st = studentService.add(new Student<ID>(id, firstName, lastName, group, email));
    if (st != null)
      System.out.println("Student already exists!");
  }

  /**
   * finds a student after keyboard input
   */
  private void findStudent() {
    System.out.println("Insert id: ");
    ID id = (ID) kb.nextLine();
    Student<ID> stu = studentService.find(id);
    if (stu == null)
      throw new NullPointerException("Student doesn't exist");
    System.out.println(stu.info());
  }

  /**
   * @throws ValidationException creates Homework from keyboard input
   */
  private void createHomework() throws ValidationException {
    System.out.println("Insert id: ");
    ID id = (ID) kb.nextLine();
    System.out.println("Insert end week: ");
    int endWeek = Integer.parseInt(kb.nextLine());
    System.out.println("Insert description: ");
    String description = kb.nextLine();
    Homework hm = homeworkService.add(new Homework<ID>(id, endWeek, description));
    if (hm != null)
      System.out.println("Homework already exists!");
  }

  /**
   * finds Homework after keyboard input
   */
  private void findHomework() {
    System.out.println("Insert id: ");
    ID id = (ID) kb.nextLine();
    Homework<ID> hm = homeworkService.find(id);
    if (hm == null)
      throw new NullPointerException("Homework doesn't exist");
    System.out.println(hm.info());
  }

  /**
   * prints all student's info
   */
  private void findAllStudents() {
    boolean empty = true;
    for (Student st : studentService.getAll()) {
      System.out.println(st.info());
      empty = false;
    }
    if (empty)
      throw new NullPointerException("There are no students!");
  }

  private void findAllHomeworks() {
    boolean empty = true;
    for (Homework hm : homeworkService.getAll()) {
      System.out.println(hm.info());
      empty = false;
    }
    if (empty)
      throw new NullPointerException("There are no homeworks!");
  }

  private void createGrade() throws ValidationException {
    System.out.println("Choose a student to assign the grade:");
    findAllStudents();
    ID studentId = (ID) kb.nextLine();
    System.out.println("Choose a homework to assign the grade:");
    findAllHomeworks();
    ID homeworkId = (ID) kb.nextLine();
    Homework<ID> hm = homeworkService.find(homeworkId);
    if (hm == null)
      throw new ValidationException("Invalid homework ID!");
    System.out.println("Max grade for this homework is: " + hm.getMaxGrade());
    Grade<ID> graded = gradeService.isHomeworkGraded(homeworkId);
    if (graded != null) {
      System.out.println("Homework is already graded!\n" + graded.info());
      return;
    }
    System.out.println("Insert id: ");
    ID id = (ID) kb.nextLine();
    System.out.println("Insert professor's name: ");
    String professor = kb.nextLine();
    System.out.println("Insert grade: ");
    int grade = Integer.parseInt(kb.nextLine());
    System.out.println("Insert feedback: ");
    String feedback = kb.nextLine();
    Grade gr = gradeService.add(new Grade<ID>(id, studentId, homeworkId, professor, grade, feedback));
    if (gr != null)
      System.out.println("Grade id already exists!");
  }

  private void findAllGrades() {
    boolean empty = true;
    for (Grade hm : gradeService.getAll()) {
      System.out.println(hm.info());
      empty = false;
    }
    if (empty)
      throw new NullPointerException("There are no grades!");
  }
}
