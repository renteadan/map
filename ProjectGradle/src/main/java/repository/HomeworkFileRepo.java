package repository;

import entity.Homework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HomeworkFileRepo<ID> extends FileRepository<ID, Homework<ID>> {

  public HomeworkFileRepo(String filename) {
    super(filename);
    loadFile();
  }

  @Override
  void loadFile() {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = br.readLine()) != null) {
        super.safeSave(new Homework<>(line.split(";")));
      }
    } catch (IOException err) {
      System.out.println(err.getMessage());
    }
  }
}
