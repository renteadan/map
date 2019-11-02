package com.company.validator;

import com.company.entity.Grade;
import com.company.exception.ValidationException;

class GradeValidator {

    static void validate(Grade entity) throws ValidationException {
        if (entity.getGrade() < 1 || entity.getGrade() > 10)
            throw new ValidationException("Incorrect grade!");
        if (entity.getProfessor().equals(""))
            throw new ValidationException("Invalid professor");
        if (entity.getStudentId() == null || entity.getHomeworkId() == null)
            throw new ValidationException("Invalid foreign ID");
    }
}
