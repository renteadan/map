package com.company.service;

import com.company.entity.Student;

public class StudentService<ID> extends AbstractService<ID, Student<ID>> {
    public StudentService() {
        super();
    }
}
