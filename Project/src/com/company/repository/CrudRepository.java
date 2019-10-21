package com.company.repository;

import com.company.entity.Entity;
import com.company.exception.ValidationException;

public interface CrudRepository<ID, E extends Entity<ID>> {

    E findOne(ID id);
    Iterable<E> findAll();
    E save(E entity) throws ValidationException;
    E delete (ID id);
    E update(E entity) throws ValidationException;
}
