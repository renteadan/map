package com.company.repository;

import com.company.entity.Student;
import com.company.exception.ValidationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StudentFileRepo<ID> extends FileRepository<ID, Student<ID>> {
    public StudentFileRepo(String filename) {
        super(filename);
        loadFile();
    }

    @Override
    void loadFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = br.readLine()) != null) {
                super.safeSave(new Student<>(line.split(";")));
            }
        } catch (IOException err) {
            System.out.println(err.getMessage());
        }
    }
}
