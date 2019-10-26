package com.company.service;

import com.company.entity.Entity;
import com.company.exception.ValidationException;
import com.company.repository.Repository;

public class AbstractService<ID, E extends Entity<ID>> {

  private Repository<ID,E> repo;
  public AbstractService() {
    repo = new Repository<>();
  }

  public E find(ID id) {
    return repo.findOne(id);
  }

  public Iterable<E> getAll() {
    return repo.findAll();
  }

  public E delete(ID id) {
    return repo.delete(id);
  }

  public E update(E entity) throws ValidationException {
    return repo.update(entity);
  }

  public E add(E entity) throws ValidationException {
    return repo.save(entity);
  }
}
