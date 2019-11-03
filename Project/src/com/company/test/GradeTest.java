package com.company.test;

import com.company.entity.Grade;
import com.company.entity.Homework;
import com.company.entity.Student;
import com.company.exception.ValidationException;
import com.company.repository.AbstractRepository;
import com.company.service.GradeService;
import com.company.service.HomeworkService;
import com.company.service.StudentService;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("unchecked")
class GradeTest {

    @Test
    void gradeTest() throws ValidationException {
        Student<String> st1 = new Student<>("1", "Danu", "Rentea","226","Secret");
        Student<String> st2 = new Student<>("2", "Iulian", "Iancu","226","ceva");
        Student<String> st3 = new Student<>("3", "Bob", "Pop","226","test123");
        Homework<String> hm = new Homework<>("1", 50,"test2");
        StudentService.getInstance().add(st1);
        StudentService.getInstance().add(st2);
        HomeworkService.getInstance().add(hm);
        Grade<String> gr = new Grade<>("1", "1", "1", "Baci", 10, "feedback");
        GradeService<String> service = GradeService.getInstance();
        service.add(gr);
        gr = service.find("1");
        System.out.println(gr.getHomework().info());
        System.out.println(gr.getStudent().info());
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
        GradeService<String> service2 = GradeService.getFileInstance("gradesTest");
        int c = 0;
        for (Grade ignored : service2.getAll())
            c++;
        assertEquals(c, 2);
        Grade<String> aux = service2.find("3");
        assertEquals(aux.getFeedback(), "find null");
        assertNotNull(aux);
        service2.update(aux);
        assertNull(service.isHomeworkGraded("198"));
        assertNotNull(service2.isHomeworkGraded("1"));
        assertNull(service2.isHomeworkGraded("391"));
    }
}
