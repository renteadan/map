package com.company.controller;

import com.company.entity.Homework;
import com.company.entity.Student;
import com.company.exception.ValidationException;
import com.company.service.HomeworkService;
import com.company.service.StudentService;

import java.util.Scanner;

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
        System.out.println("1.Create student\n2.Find student\n3.Create homework\n4.Find homework\n0.Exit\n");
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
                    default:
                }
            } catch (ValidationException|IllegalArgumentException|NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
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
        studentService.add(new Student<ID>(id, firstName, lastName, group, email));
    }

    @SuppressWarnings("unchecked")
    private void findStudent() {
        System.out.println("Insert id: ");
        ID id = (ID) kb.next();
        Student<ID> stu = studentService.find(id);
        if (stu == null)
            throw new NullPointerException("Student doesn't exist");
        System.out.println(stu.info());
    }

    @SuppressWarnings("unchecked")
    private void createHomework() throws ValidationException {
        System.out.println("Insert id: ");
        ID id = (ID) kb.next();
        System.out.println("Insert end week: ");
        int endWeek = kb.nextInt();
        System.out.println("Insert description: ");
        String description = kb.next();
        homeworkService.add(new Homework<ID>(id, endWeek, description));
    }

    @SuppressWarnings("unchecked")
    private void findHomework() {
        System.out.println("Insert id: ");
        ID id = (ID) kb.next();
        Homework<ID> hm = homeworkService.find(id);
        if (hm == null)
            throw new NullPointerException("Homework doesn't exist");
        System.out.println(hm.info());
    }
}
