package com.company.test;

import com.company.entity.Homework;
import com.company.entity.Student;
import com.company.entity.StudyYear;
import com.company.exception.ValidationException;
import com.company.service.HomeworkService;
import com.company.service.StudentService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServiceTest {

  @Test
  @SuppressWarnings("unchecked")
  void serviceTest() throws ValidationException {
    HomeworkService<String> hm = HomeworkService.getInstance();
    StudentService<String> serv = StudentService.getInstance();
    serv.makeEmpty();
    Student<String> st = new Student<>("1", "Dan", "Rentea", "226", "secret@mail.com");
    serv.add(st);
    assertEquals(serv.find("1").getFirstName(), "Dan");
    Student<String> st2 = serv.delete("1");
    assertEquals(st, st2);
    hm.add(new Homework<>("1", 15, "ceva"));
    serv.add(st2);
    Student<String> st3 = new Student<>("1", "Test", "Name", "200", "ceva@mail.com");
    serv.update(st3);
    assertEquals(serv.find("1").getFirstName(), "Test");
    int c = 0;
    for (Object x : serv.getAll()) {
      c++;
    }
    assertEquals(c, 1);
    serv = StudentService.getFileInstance("studentTest");
    hm = HomeworkService.getFileInstance("hmTest");
  }

  @SuppressWarnings("unchecked")
  @Test
  void studentServiceTest() throws ValidationException {
    int c = StudyYear.getCurrentWeek();
    StudentService<String> serv = StudentService.getInstance();
    serv.makeEmpty();
    Student<String> st = new Student<>("1", "Dan", "Rentea", "226", "secret@mail.com");
    serv.add(st);
    serv.motivateWeek(c-1, "1");
    assertThrows(IllegalArgumentException.class, () -> {
      serv.motivateWeek(c+1, "1");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      serv.motivateWeek(c-1, null);
    });
    assertEquals(serv.getStudentsFromGroup("226").size(), 1);
  }
}
