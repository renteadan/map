package com.company.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;

public class StudyYear {
  private static String str = "2019-09-30 00:00";
  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
  private static LocalDateTime dateTime = LocalDateTime.parse(str, formatter);

  public static int getCurrentWeek() {
    return (int) ChronoUnit.WEEKS.between(dateTime, LocalDateTime.now()) + 1;
  }

  public static int getMotivariBetween(int start, int end, HashSet<Integer> vec) {
    int c=0;
    for(int x: vec) {
      if (x >= start && x<=end)
        c++;
    }
    return c;
  }

  public static int getWeekOf(LocalDateTime date) {
    return (int) ChronoUnit.WEEKS.between(dateTime, date) + 1;
  }
}
