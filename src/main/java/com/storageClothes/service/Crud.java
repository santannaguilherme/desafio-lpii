package com.storageClothes.service;

import java.util.List;

public interface Crud<T> {

    public void add(T model) throws Exception;

    public void remove(int id) throws Exception;

    public void update(T model) throws Exception;

    public List<T> getAll() throws Exception;

    public T getById(int id) throws Exception;
}
