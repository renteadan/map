package com.company.entity;

public abstract class Entity<ID> {
  protected ID id;

  Entity(ID id) {
    this.id = id;
  }

  public ID getId() {
    return id;
  }

  public void setId(ID id) {
    this.id = id;
  }

  public abstract String toFile();

  public abstract String info();
}
