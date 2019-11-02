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

    @SuppressWarnings("unchecked")
    public Student(String[] args) {
        super((ID)args[0]);
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
        return String.format("%s.My name is %s %s. I'm from group %s and my email is %s",id,firstName,lastName, group, email);
    }

    @Override
    public String toFile() {
        return String.format("%s;%s;%s;%s;%s", id, firstName,lastName,group,email);
    }
}
