package com.storageClothes.service;

import java.util.List;

public interface Crud<T> {

    public void add(T model);

    public void remove(int id);

    public void update(T model);

    public List<T> getAll();

    public T getById(int id);
}
