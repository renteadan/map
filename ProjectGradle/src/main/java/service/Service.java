package service;

import entity.Entity;
import exception.ValidationException;


public interface Service<ID, E extends Entity<ID>> {
  E find(ID id);

  Iterable<E> getAll();

  E delete(ID id);

  E update(E entity) throws ValidationException, ValidationException;

  E add(E entity) throws ValidationException;
}
