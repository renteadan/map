package com.company.test;

import com.company.entity.Homework;
import com.company.exception.ValidationException;
import com.company.repository.Repository;
import com.company.validator.HomeworkValidator;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {

  @Test
  void homeworkTest() {
    Homework<String> hm = new Homework<>("1", 1, 2, "test1");
    assertEquals(hm.getId(), "1");
    assertEquals(hm.getEndWeek(), 2);
    assertEquals(hm.getDescription(), "test1");
    assertEquals(hm.getStartWeek(), 1);
    HomeworkValidator valid = new HomeworkValidator();
    Homework<String> finalHm = hm;
    assertDoesNotThrow(() -> {
      valid.validate(finalHm);
    });
    hm = new Homework<>("1", 2,1,"test2");
    Homework<String> finalHm1 = hm;
    assertThrows(ValidationException.class, () -> {
      valid.validate(finalHm1);
    });

    hm = new Homework<>("1", 0,1,"test2");
    Homework<String> finalHm2 = hm;
    assertThrows(ValidationException.class, () -> {
      valid.validate(finalHm2);
    });

    Repository<String, Homework<String>> repo = new Repository<>();

    Homework<String> finalHm3 = hm;
    assertThrows(ValidationException.class, () -> {
      repo.save(finalHm3);
    });

    hm = new Homework<>("1", 2, 3, "ceva");
    Homework<String> finalHm4 = hm;
    assertDoesNotThrow(() -> {
      repo.save(finalHm4);
    });
  }
}
