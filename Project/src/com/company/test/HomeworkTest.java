package com.company.test;

import com.company.entity.Homework;
import com.company.exception.ValidationException;
import com.company.repository.Repository;
import com.company.validator.HomeworkValidator;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class HomeworkTest {

  @Test
  void homeworkTest() {
    String str = "2019-09-30 00:00";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
    int c = (int) ChronoUnit.WEEKS.between(dateTime,LocalDateTime.now());
    Homework<String> hm = new Homework<>("1",  c+2, "test1");
    assertEquals(hm.getId(), "1");
    assertEquals(hm.getEndWeek(), c+2);
    assertEquals(hm.getDescription(), "test1");
    assertEquals(hm.getStartWeek(), c);
    HomeworkValidator valid = new HomeworkValidator();
    Homework<String> finalHm = hm;
    assertDoesNotThrow(() -> {
      valid.validate(finalHm);
    });
    hm = new Homework<>("1", 1,"test2");
    Homework<String> finalHm1 = hm;
    assertThrows(ValidationException.class, () -> {
      valid.validate(finalHm1);
    });

    hm = new Homework<>("1", 1,"test2");
    Homework<String> finalHm2 = hm;
    assertThrows(ValidationException.class, () -> {
      valid.validate(finalHm2);
    });

    Repository<String, Homework<String>> repo = new Repository<>();

    Homework<String> finalHm3 = hm;
    assertThrows(ValidationException.class, () -> {
      repo.save(finalHm3);
    });

    hm = new Homework<>("1",  c+1, "ceva");
    Homework<String> finalHm4 = hm;
    assertDoesNotThrow(() -> {
      repo.save(finalHm4);
    });
  }
}
