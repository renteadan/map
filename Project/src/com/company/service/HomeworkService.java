package com.company.service;

import com.company.entity.Homework;
import com.company.repository.HomeworkFileRepo;

public class HomeworkService<ID> extends AbstractService<ID, Homework<ID>> {
    private static HomeworkService instance = null;
    private static HomeworkService instanceFile = null;
    private HomeworkFileRepo<ID> repo;
    private HomeworkService() {
        super();
    }

    private HomeworkService(String file) {
        super();
        repo = new HomeworkFileRepo<>(file);
        setRepo(repo);
    }

    public static HomeworkService getInstance() {
        if (instance == null)
            instance = new HomeworkService();
        return instance;
    }

    public static HomeworkService getFileInstance() {
        if (instanceFile == null)
            instanceFile = new HomeworkService("homeworks");
        return instanceFile;
    }
}
