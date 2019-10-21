package com.company.repository;

import com.company.entity.Entity;
import com.company.exception.ValidationException;
import com.company.validator.EntityValidator;

import java.util.Map;

public class Repository<ID, E extends Entity<ID>> implements CrudRepository<ID, E> {
  private Map<ID, E> storage;

  /**
   *
   * @param id -the id of the entity to be returned
   * id must not be null
   * @return the entity with the specified id
   * or null - if there is no entity with the given id
   * @throws IllegalArgumentException
   * if id is null.
   */

  @Override
  public E findOne(ID id) {
    if(id==null)
      throw new IllegalArgumentException();
    return storage.get(id);
  }

  /**
   *
   * @return all entities
   */

  @Override
  public Iterable<E> findAll() {
    return storage.values();
  }

  /**
   *
   * @param entity
   * entity must be not null
   * @return null- if the given entity is saved
   * otherwise returns the entity (id already exists)
   * @throws ValidationException
   * if the entity is not valid
   * @throws IllegalArgumentException
   * if the given entity is null. *
   */

  @Override
  public E save(E entity) throws ValidationException {
    EntityValidator<E> v = new EntityValidator<E>();
    v.validate(entity);
    if(storage.get(entity.getId()) != null)
      return entity;
    storage.put(entity.getId(), entity);
    return null;
  }

  /**
   * removes the entity with the specified id
   * @param id
   * id must be not null
   * @return the removed entity or null if there is no entity with the
  given id
   * @throws IllegalArgumentException
   * if the given id is null.
   */

  @Override
  public E delete(ID id) {
    if (id == null)
      throw new IllegalArgumentException();
    return storage.remove(id);
  }

  /**
   *
   * @param entity
   * entity must not be null
   * @return null - if the entity is updated,
   * otherwise returns the entity - (e.g id does not
  exist).
   * @throws IllegalArgumentException
   * if the given entity is null.
   * @throws ValidationException
   * if the entity is not valid.
   */
  @Override
  public E update(E entity) throws ValidationException {
    if (entity == null)
      throw new IllegalArgumentException();
    EntityValidator<E> v = new EntityValidator<E>();
    v.validate(entity);
    if(storage.replace(entity.getId(), entity) != null)
      return null;
    return entity;
  }
}
