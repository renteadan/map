package com.company.validator;

import com.company.exception.ValidationException;

public interface Validator<E> {
    void validate(E entity) throws ValidationException;
}
