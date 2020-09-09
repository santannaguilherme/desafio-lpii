package com.storageClothes.service;

import java.util.List;

public interface Crud<T> {

    // Abstração usada para adicionar em uma nova entidade
    public void add(T model) throws Exception;

    // Abstração usada para remover um objeto de uma entidade
    public void remove(int id) throws Exception;

    // Abstração usada para atualizar um objeto de uma dada entidade
    public void update(T model) throws Exception;

    // Abstração usada para recuperar objetos de uma entidade
    public List<T> getAll() throws Exception;

    // Abstração usada para recuperar um objeto especifico de um conjunto de objetos de uma entidade
    public T getById(int id) throws Exception;
}
