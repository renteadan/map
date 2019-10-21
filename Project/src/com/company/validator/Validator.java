package com.company.validator;

import com.company.entity.Entity;
import com.company.exception.ValidationException;

public interface Validator<E extends Entity> {
    void validate(E entity) throws ValidationException;
}
