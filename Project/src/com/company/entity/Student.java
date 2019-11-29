package com.company.entity;

import java.util.HashSet;
import java.util.Objects;

public class Student<ID> extends Entity<ID> {
  private String firstName, lastName, group, email;
  private HashSet<Integer> motivari = new HashSet<>();

  public Student() {
  }

  public Student(String firstName, String lastName, String group, String email) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.group = group;
    this.email = email;
  }

  public Student(ID id,String firstName, String lastName, String group, String email) {
    super(id);
    this.firstName = firstName;
    this.lastName = lastName;
    this.group = group;
    this.email = email;
  }

  @SuppressWarnings("unchecked")
  public Student(String[] args) {
    super((ID) args[0]);
    this.firstName = args[1];
    this.lastName = args[2];
    this.group = args[3];
    this.email = args[4];

  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getGroup() {
    return group;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student<?> student = (Student<?>) o;
    return Objects.equals(this.getId(), student.getId());
  }

  public String info() {
    return String.format("ID=%s.My name is %s %s. I'm from group %s and my email is %s", id, firstName, lastName, group, email);
  }

  @Override
  public String toFile() {
    return String.format("%s;%s;%s;%s;%s", id, firstName, lastName, group, email);
  }

  public void motivateWeek(int week) {
    motivari.add(week);
  }

  public HashSet<Integer> getMotivari() {
    return motivari;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setMotivari(HashSet<Integer> motivari) {
    this.motivari = motivari;
  }

  public String toString() {
    return firstName + " " + lastName;
  }
}
