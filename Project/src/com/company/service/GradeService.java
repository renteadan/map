package com.company.service;

import com.company.entity.Grade;
import com.company.repository.GradeFileRepo;

@SuppressWarnings("unchecked")
public class GradeService<ID> extends AbstractService<ID, Grade<ID>> {
    private static GradeService instance = null;
    private static GradeService instanceFile = null;
    private StudentService<ID> sService;
    private HomeworkService<ID> hService;
    private GradeFileRepo<ID> repo;
    private GradeService() {
        super();
        sService = StudentService.getInstance();
        hService = HomeworkService.getInstance();
        repo = new GradeFileRepo<>("grades");
    }
    public static GradeService getInstance() {
        if (instance == null)
            instance = new GradeService();
        return instance;
    }

    private GradeService(String file) {
        super();
        repo = new GradeFileRepo<>(file);
        setRepo(repo);
    }

    public static GradeService getFileInstance() {
        if (instanceFile == null)
            instanceFile = new GradeService("grades");
        return instanceFile;
    }

    @Override
    public Grade<ID> find(ID id) {
        Grade<ID> grade = super.find(id);
        if (grade == null)
            return null;
        grade.setStudent(sService.find(grade.getStudentId()));
        grade.setHomework(hService.find(grade.getHomeworkId()));
        return grade;
    }
}
