package com.company.entity;

import java.util.Objects;

public class Student<ID> extends Entity<ID> {
    private String firstName, lastName, group, email;

    public Student(ID id, String firstName, String lastName, String group, String email) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.email = email;
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
        return String.format("%s.My name is %s %s. I'm from group %s and my email is %s",id,firstName,lastName, group, email);
    }
}
