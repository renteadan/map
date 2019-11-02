package com.company.test;

import com.company.entity.Grade;
import com.company.entity.Homework;
import com.company.entity.Student;
import com.company.exception.ValidationException;
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
        Student<String> st1 = new Student<>("1", "Dan", "Rentea","226","Secret");
        Student<String> st2 = new Student<>("2", "Iulian", "Iancu","226","ceva");
        Student<String> st3 = new Student<>("3", "Bob", "Pop","226","test123");
        Homework<String> hm = new Homework<>("1", 50,"test2");
        StudentService.getInstance().add(st1);
        StudentService.getInstance().add(st2);
        HomeworkService.getInstance().add(hm);
        Grade<String> gr = new Grade<>("1", "1", "1", "Baci", 10);
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
            service.add(new Grade<>("1", "1", "1", "lele", -3));
        });
        assertThrows(ValidationException.class, () -> {
            service.add(new Grade<>("1", null, "1", "lele", 7));
        });
        assertThrows(ValidationException.class, () -> {
            service.add(new Grade<>("1", "1", "1", "", 7));
        });
    }
}
