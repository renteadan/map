package com.company.controller;

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

    public void run() {
        while(true) {
            System.out.println("Insert your command: ");
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
                    default:
                }
            } catch (ValidationException|IllegalArgumentException e) {
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
        System.out.println(stu.info());
    }
}
