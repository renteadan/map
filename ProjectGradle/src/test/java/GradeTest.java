import entity.*;
import exception.ValidationException;
import org.junit.jupiter.api.Test;
import repository.AbstractRepository;
import service.GradeService;
import service.HomeworkService;
import service.ReportService;
import service.StudentService;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unchecked")
class GradeTest {

  @Test
  void gradeTest() throws ValidationException {
    Student<String> st1 = new Student<>("1", "Danu", "Rentea", "226", "Secret@mail.com");
    Student<String> st2 = new Student<>("2", "Iulian", "Iancu", "226", "ceva@mail.com");
    Student<String> st3 = new Student<>("3", "Bob", "Pop", "226", "test123@mail.com");
    Homework<String> hm = new Homework<>("1", 50, "test2");
    Homework<String> hm2 = new Homework<>("2", 50, "test2");
    StudentService.getInstance().add(st1);
    StudentService.getInstance().add(st2);
    HomeworkService.getInstance().add(hm);
    HomeworkService.getInstance().add(hm2);
    Grade<String> gr = new Grade<>("1", "1", "1", "Baci", 10, "feedback");
    Grade<String> gr2 = new Grade<>("2", "2", "1", "Daci", 10, "feedback");
    GradeService<String> service = GradeService.getInstance();
    service.add(gr);
    gr = service.find("1");
    assertNull(service.find("56"));
    gr.setGrade(5);
    assertEquals(gr.getGrade(), 5);
    assertTrue(gr.getDate().isBefore(LocalDateTime.now()));
    assertThrows(ValidationException.class, () -> {
      service.add(new Grade<>("1", "1", "1", "lele", -3, "feedback"));
    });
    assertThrows(ValidationException.class, () -> {
      service.add(new Grade<>("1", "7", "1", "lele", 7, "feedback"));
    });
    assertThrows(ValidationException.class, () -> {
      service.add(new Grade<>("1", "1", "1", "", 7, "feedback"));
    });
    AbstractRepository<String, Grade<String>> r = new AbstractRepository<>();
    service.setRepo(r);
    GradeService<String> service2 = GradeService.getFileInstance("gradeTest");
    int c = 0;
    for (Grade ignored : service2.getAll())
      c++;
    assertEquals(c, 1);
    service2.add(gr2);
    Grade<String> aux = service2.find("3");
    assertNull(aux);
    assertFalse(service.isHomeworkGraded("1","198"));
    assertTrue(service2.isHomeworkGraded("1","1"));
    assertFalse(service2.isHomeworkGraded("3","391"));
    int m = StudyYear.getCurrentWeek();
    service.add(gr);
    service.add(gr2);
    service2.delete(gr2.getId());
    assertEquals(service.getGradesByHomeworkAndWeek("1", m).size(), 2);
    assertEquals(service.getStudentsByHomework("1").size(), 2);
    assertEquals(service.getStudentsByHomeworkAndProfessor("1", "Baci").size(), 1);
    assertEquals(service.getStudentsByHomeworkAndProfessor("1", "Random").size(), 0);
  }

  @Test
  void motivateTest() {
    int c = StudyYear.getCurrentWeek();
    Student<String> st3 = new Student<>("3", "Bob", "Pop", "226", "test123");
    Homework<String> hm = new Homework<>("1", c-1, "test2");
    st3.motivateWeek(c-1);
    assertEquals(hm.getMaxGrade(), 9);
    int m = StudyYear.getMotivariBetween(hm.getEndWeek(), StudyYear.getCurrentWeek(), st3.getMotivari());
    assertEquals(m, 1);
    assertEquals(hm.getMaxGrade(m), 10);
    hm = new Homework<>("1", c-3, "test2");
    assertEquals(hm.getMaxGrade(), 1);
    assertEquals(hm.getMaxGrade(m), 8);
    hm = new Homework<>("1", c-4, "test2");
    assertEquals(hm.getMaxGrade(m), 1);
    hm = new Homework<>("1", c-2, "test2");
    assertEquals(hm.getMaxGrade(), 8);
    hm = new Homework<>("1", c, "test2");
    assertEquals(hm.getMaxGrade(), 10);
  }

  @Test
  void reportTest() throws ValidationException {
    GradeService<String> gr = GradeService.getFileInstance("gradeTest");
    Grade<String> gr2 = new Grade<>("2", "2", "1", "Daci", 10, "feedback");
    Grade<String> gr3 = new Grade<>("3", "2", "2", "Daci", 6, "feedback");
    gr.add(gr2);
    gr.add(gr3);
    ReportService<String> service = new ReportService<>(gr);
    service.calculateAll();
    Report r = service.find("2");
    assertEquals(r.getAverage(), 9.0f);
    gr.delete("2");
    gr.delete("3");
  }
}
