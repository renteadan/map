package service;

import entity.Homework;
import repository.HomeworkFileRepo;
import repository.XmlRepo;


public class HomeworkService<ID> extends AbstractService<ID, Homework<ID>> {
  private static HomeworkService instance = null;
  private static HomeworkService instanceFile = null;

  private HomeworkService() {
    super();
  }

  private HomeworkService(String file) {
    super();
    XmlRepo<ID, Homework<ID>> repo = new XmlRepo<>(file);
    setRepo(repo);
  }

  public static HomeworkService getInstance() {
    if (instance == null)
      instance = new HomeworkService();
    return instance;
  }

  public static HomeworkService getFileInstance(String filename) {
    if (instanceFile == null)
      instanceFile = new HomeworkService(filename);
    return instanceFile;
  }
}
