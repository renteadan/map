package com.company.controller;

import com.company.entity.Homework;
import com.company.entity.Student;
import com.company.exception.ValidationException;
import com.company.service.HomeworkService;
import com.company.service.StudentService;

import java.util.Scanner;

@SuppressWarnings("unchecked")
public class Controller<ID> {
    private StudentService<ID> studentService;
    private HomeworkService<ID> homeworkService;
    private Scanner kb;

    public Controller() {
        studentService = new StudentService<>();
        homeworkService = new HomeworkService<>();
        kb = new Scanner(System.in);
    }

    private void printMenu() {
        System.out.println("1.Create student\n2.Find student\n3.Create homework\n4.Find homework\n" +
            "5.Display all students\n" +
            "0.Exit\n");
    }

    public void run() {
        while(true) {
            printMenu();
            System.out.println("Insert your command's number: ");
            int command = kb.nextInt();
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
                    default:
                }
            } catch (ValidationException|IllegalArgumentException|NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void createStudent() throws ValidationException {

        System.out.println("Insert id: ");
        ID id = (ID) kb.next();
        System.out.println("Insert first name: ");
        String firstName = kb.next();
        System.out.println("Insert last name: ");
        String lastName = kb.next();
        System.out.println("Insert group: ");
        String group = kb.next();
        System.out.println("Insert email: ");
        String email = kb.next();
        Student st = studentService.add(new Student<ID>(id, firstName, lastName, group, email));
        if (st != null)
            System.out.println("Student already exists!");
    }

    private void findStudent() {
        System.out.println("Insert id: ");
        ID id = (ID) kb.next();
        Student<ID> stu = studentService.find(id);
        if (stu == null)
            throw new NullPointerException("Student doesn't exist");
        System.out.println(stu.info());
    }

    private void createHomework() throws ValidationException {
        System.out.println("Insert id: ");
        ID id = (ID) kb.next();
        System.out.println("Insert end week: ");
        int endWeek = kb.nextInt();
        System.out.println("Insert description: ");
        String description = kb.next();
        Homework hm = homeworkService.add(new Homework<ID>(id, endWeek, description));
        if (hm != null)
            System.out.println("Homework already exists!");
    }

    private void findHomework() {
        System.out.println("Insert id: ");
        ID id = (ID) kb.next();
        Homework<ID> hm = homeworkService.find(id);
        if (hm == null)
            throw new NullPointerException("Homework doesn't exist");
        System.out.println(hm.info());
    }

    private void findAllStudents() {
        for (Student st : studentService.getAll())
            System.out.println(st.info());
    }
}
