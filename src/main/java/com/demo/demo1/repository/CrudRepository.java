package com.demo.demo1.repository;

import java.util.List;
import java.util.UUID;

public interface CrudRepository<T> {

    T findOne(UUID id);

    List<T> findAll();

    T save(T entity);

    void delete(T entity);

    boolean exists(UUID id);

}

