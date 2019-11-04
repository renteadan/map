package com.company.repository;

import com.company.entity.Grade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GradeFileRepo<ID> extends FileRepository<ID, Grade<ID>> {
  public GradeFileRepo(String filename) {
    super(filename);
    loadFile();
  }

  @Override
  void loadFile() {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = br.readLine()) != null) {
        super.safeSave(new Grade<>(line.split(";")));
      }
    } catch (IOException err) {
      System.out.println(err.getMessage());
    }
  }
}
