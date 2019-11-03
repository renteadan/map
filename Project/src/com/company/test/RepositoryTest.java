package com.company.test;

import com.company.entity.Grade;
import com.company.entity.Homework;
import com.company.entity.Student;
import com.company.exception.ValidationException;
import com.company.repository.GradeFileRepo;
import com.company.repository.HomeworkFileRepo;
import com.company.repository.AbstractRepository;
import com.company.repository.StudentFileRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
  private AbstractRepository<String, Student<String>> repo;

  @BeforeEach
  void populate() {
   repo = new AbstractRepository<>();
   Student<String> st1 = new Student<>("1", "Dan", "Rentea","226","Secret");
   Student<String> st2 = new Student<>("2", "Iulian", "Iancu","226","ceva");
   Student<String> st3 = new Student<>("3", "Bob", "Pop","226","test123");
   try {
     repo.save(st1);
     repo.save(st2);
     repo.save(st3);
   } catch(ValidationException e) {
     System.out.println(e.getMessage());
   }
  }

  @Test
  void addFindTest() throws ValidationException {
    Student<String> st1 = new Student<>("4", "Dan", "Rentea","226","Secret");
    Student<String> ret;
    ret = repo.save(st1);
    assertNull(ret);
    st1 = new Student<>("5", "", "Rentea","226","Secret");
    Student<String> finalSt = st1;
    assertThrows(ValidationException.class, () -> {
      repo.save(finalSt);
    });
    st1 = new Student<>("1", "Dan", "Rentea","226","Secret");
    ret = repo.save(st1);
    assertEquals(ret, st1);
    ret = repo.findOne("1");
    assertEquals(ret, st1);
    assertThrows(IllegalArgumentException.class, () -> {
      repo.findOne(null);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      repo.save(null);
    });
    ret = repo.findOne("6");
    assertNull(ret);
  }

  @Test
  void deleteTest() {
    Student<String> st1;
    st1 = repo.delete("1");
    assertEquals(st1.getFirstName(), "Dan");
    st1 = repo.delete("14");
    assertNull(st1);
    assertThrows(IllegalArgumentException.class, () -> {
      repo.delete(null);
    });
  }

  @Test
  void updateTest() throws ValidationException {
    Student<String> st1 = new Student<>("1", "George", "Richi", "223", "tradator@mail.com");
    Student<String> ret;
    ret = repo.update(st1);
    assertEquals(1, 1);
    assertNull(ret);
    ret = repo.findOne("1");
    assertEquals("George", ret.getFirstName());
    st1 = new Student<>("1", "", "Richi", "223", "tradator@mail.com");
    assertThrows(ValidationException.class, () -> {
      repo.update(new Student<>("1", "", "Richi", "223", "tradator@mail.com"));
    });
    assertThrows(IllegalArgumentException.class, () -> {
      repo.update(null);
    });
    st1 = new Student<>("51", "Dan1", "Test1", "226", "ceva");
    assertEquals(st1, repo.update(st1));
    st1.setId("1");
    assertEquals("226", st1.getGroup());
    assertEquals("ceva", st1.getEmail());
  }

  @Test
  void findAllTest() {
    for(Student x : repo.findAll()) {
      assertNotNull(x);
    }
  }

  @Test
  void studentFileRepoTest() throws ValidationException {
    StudentFileRepo<String> fr = new StudentFileRepo<>("test1");
    Student<String> st1 = new Student<>("1", "George", "Richi", "223", "tradator@mail.com");
    fr.save(st1);
    st1 = new Student<>("51", "Dan1", "Test1", "226", "ceva");
    fr.save(st1);
    StudentFileRepo<String> fr2 = new StudentFileRepo<>("test1");
    for(Student st: fr2.findAll()) {
      assertEquals(st, fr.findOne((String) st.getId()));
    }
    Student<String> st3 = fr.delete("1");
    assertEquals(st3.getFirstName(), "George");
    st1 = new Student<>("1", "Traian", "Basescu", "299","ceva");
    fr2.update(st1);
    assertEquals(fr2.findOne("1").getFirstName(),"Traian");
    st1 = new Student<>("1", "George", "Richi", "223", "tradator@mail.com");
    fr.update(st1);
  }

  @Test
  void homeworkFileRepoTest() throws ValidationException {
    HomeworkFileRepo<String> hr = new HomeworkFileRepo<>("test2");
    Homework<String> hm = new Homework<>("1",  50, "test1");
    hr.save(hm);
    HomeworkFileRepo<String> hr2 = new HomeworkFileRepo<>("test2");
    assertEquals(hr2.findOne("1"), hr.findOne("1"));
  }

  @Test
  void gradeFileRepoTest() throws ValidationException {
    GradeFileRepo<String> gr = new GradeFileRepo<>("gradesTest");
    gr.save(new Grade<>("1","1", "1", "gigi", 9, "feedback"));
    GradeFileRepo<String> gr2 = new GradeFileRepo<>("gradesTest");
    System.out.println(gr2.findOne("1").info());
    assertEquals(gr2.findOne("1").getHomeworkId(), "1");
    assertThrows(ValidationException.class, () -> {
      gr.save(new Grade<>("1", null, "2", "gigi", 4, "ceva"));
    });
  }
}
