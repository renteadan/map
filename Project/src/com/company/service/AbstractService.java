package com.company.service;

import com.company.entity.Entity;
import com.company.exception.ValidationException;
import com.company.repository.AbstractRepository;

import java.util.stream.StreamSupport;

public class AbstractService<ID, E extends Entity<ID>> implements Service<ID, E> {

  private AbstractRepository<ID, E> repo;

  AbstractService() {
    repo = new AbstractRepository<>();
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

  public void setRepo(AbstractRepository<ID, E> abs) {
    repo = abs;
  }

  public void makeEmpty() {
    repo.makeEmpty();
  }
}
