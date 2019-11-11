package com.company.entity;
import java.util.Objects;

public class Homework<ID> extends Entity<ID> {
  private int startWeek, endWeek;
  private String description;

  public Homework(ID id, int endWeek, String description) {
    super(id);
    this.startWeek = StudyYear.getCurrentWeek();
    this.endWeek = endWeek;
    this.description = description;
  }

  @SuppressWarnings("unchecked")
  public Homework(String[] args) {
    super((ID) args[0]);
    this.startWeek = Integer.parseInt(args[1]);
    this.endWeek = Integer.parseInt(args[2]);
    this.description = args[3];
  }

  public Homework() {
  }

  public int getMaxGrade(int motivate) {
    int x = StudyYear.getCurrentWeek();
    int delay = x - endWeek - motivate;
    if (delay > 2)
      return 1;
    if (delay <= 0)
      return 10;
    return 10 - delay;
  }

  public int getMaxGrade() {
    int x = StudyYear.getCurrentWeek();
    int delay = x - endWeek;
    if (delay > 2)
      return 1;
    if (delay <= 0)
      return 10;
    return 10 - delay;
  }

  public int getStartWeek() {
    return startWeek;
  }

  public int getEndWeek() {
    return endWeek;
  }

  public String getDescription() {
    return description;
  }

  public String info() {
    return String.format("ID=%s.Start week is %d, end week is %d and description is %s", id, startWeek, endWeek, description);
  }

  @Override
  public String toFile() {
    return String.format("%s;%d;%d;%s", id, startWeek, endWeek, description);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Homework<?> homework = (Homework<?>) o;
    return Objects.equals(this.getId(), homework.getId());
  }

  public void setStartWeek(int startWeek) {
    this.startWeek = startWeek;
  }

  public void setEndWeek(int endWeek) {
    this.endWeek = endWeek;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
