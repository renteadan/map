package com.company.repository;

import com.company.entity.Entity;
import com.company.exception.ValidationException;
import com.company.validator.Validator;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.stream.StreamSupport;

public class AbstractRepository<ID, E extends Entity<ID>> implements Repository<ID, E> {
  HashMap<ID, E> getStorage() {
    return storage;
  }

  void setStorage(HashMap<ID, E> storage) {
    this.storage = storage;
  }

  private HashMap<ID, E> storage;

  public AbstractRepository() {
    storage = new HashMap<>();
  }

  /**
   * @param id -the id of the entity to be returned
   *           id must not be null
   * @return the entity with the specified id
   * or null - if there is no entity with the given id
   * @throws IllegalArgumentException if id is null.
   */

  @Override
  public E findOne(@Nullable ID id) {
    if (id == null)
      throw new IllegalArgumentException("Invalid id!");
    return storage.get(id);
  }

  /**
   * @return all entities
   */

  @Override
  public Iterable<E> findAll() {
    return storage.values();
  }

  /**
   * @param entity entity must be not null
   * @return null- if the given entity is saved
   * otherwise returns the entity (id already exists)
   * @throws ValidationException      if the entity is not valid
   * @throws IllegalArgumentException if the given entity is null. *
   */

  @Override
  @SuppressWarnings("unchecked")
  public E save(@Nullable E entity) throws ValidationException {
    if (entity == null)
      throw new IllegalArgumentException();
    int cate = (int) StreamSupport.stream(findAll().spliterator(), false).count();
    cate++;
    if (entity.getId() == null)
      entity.setId((ID) String.valueOf(cate));
    Validator.validate(entity);
    if (storage.get(entity.getId()) != null)
      return entity;
    storage.put(entity.getId(), entity);
    return null;
  }

  /**
   * removes the entity with the specified id
   *
   * @param id id must be not null
   * @return the removed entity or null if there is no entity with the
   * given id
   * @throws IllegalArgumentException if the given id is null.
   */

  @Override
  public E delete(@Nullable ID id) {
    if (id == null)
      throw new IllegalArgumentException("Invalid id!");
    return storage.remove(id);
  }

  /**
   * @param entity entity must not be null
   * @return null - if the entity is updated,
   * otherwise returns the entity - (e.g id does not
   * exist).
   * @throws IllegalArgumentException if the given entity is null.
   * @throws ValidationException      if the entity is not valid.
   */
  @Override
  public E update(@Nullable E entity) throws ValidationException {
    if (entity == null)
      throw new IllegalArgumentException();
    Validator.validate(entity);
    if (storage.replace(entity.getId(), entity) != null)
      return null;
    return entity;
  }

  public void makeEmpty() {
    this.storage.clear();
  }

  void safeSave(E entity) {
    storage.put(entity.getId(), entity);
  }
}
