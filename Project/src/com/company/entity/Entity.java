package com.company.entity;

public class Entity<ID> {
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
}
