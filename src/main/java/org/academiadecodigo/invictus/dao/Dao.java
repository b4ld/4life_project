package org.academiadecodigo.invictus.dao;

import org.academiadecodigo.invictus.model.Model;

import java.util.List;

public interface Dao<T extends Model> {

    List<T> findAll();

    T findById(Integer id);

    T createOrUpdate(T model);

    void delete(Integer id);
}
