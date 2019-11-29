package com.company.Observer;

public interface Observer {
  public void addObservable(Observable observable);
  public void notifyObservables();
}
