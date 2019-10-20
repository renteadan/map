package com.company.entity;

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
}
