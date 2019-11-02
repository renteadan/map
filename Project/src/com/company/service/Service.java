package com.company.service;

import com.company.entity.Entity;
import com.company.exception.ValidationException;

public interface Service<ID, E extends Entity<ID>> {
    E find(ID id);
    Iterable<E> getAll();
    E delete(ID id);

    E update(E entity) throws ValidationException;

    E add(E entity) throws ValidationException;
}
