package repository;

import entity.Entity;
import exception.ValidationException;

public interface Repository<ID, E extends Entity<ID>> {

  E findOne(ID id);

  Iterable<E> findAll();

  E save(E entity) throws ValidationException;

  E delete(ID id);

  E update(E entity) throws ValidationException;
}
