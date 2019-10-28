package com.company.test;

import com.company.entity.Student;
import com.company.exception.ValidationException;
import com.company.repository.Repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
  Repository<String, Student<String>> repo;

  @BeforeEach
  void populate() {
   repo = new Repository<>();
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
}
