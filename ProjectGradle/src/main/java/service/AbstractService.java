package service;

import Observer.*;
import entity.Entity;
import exception.ValidationException;
import repository.AbstractRepository;

import java.util.Vector;


public class AbstractService<ID, E extends Entity<ID>> implements Service<ID, E>, Observer {

  private AbstractRepository<ID, E> repo;
  private Vector<Observable> observableList = new Vector<>();
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
    notifyObservables();
    return repo.delete(id);
  }

  public E update(E entity) throws ValidationException {
    notifyObservables();
    return repo.update(entity);
  }

  public E add(E entity) throws ValidationException {
    notifyObservables();
    return repo.save(entity);
  }

  public void setRepo(AbstractRepository<ID, E> abs) {
    repo = abs;
  }

  public void makeEmpty() {
    repo.makeEmpty();
  }


  @Override
  public void addObservable(Observable observable) {
    observableList.add(observable);
  }

  @Override
  public void notifyObservables() {
    for(Observable x:observableList)
      x.getNotified();
  }

  public AbstractRepository<ID, E> getRepo() {
    return repo;
  }
}
