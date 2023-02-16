package org.klozevitz.kameleoon_test.model.dao;

public interface IDaoDB<E> {
    E findById(Integer id);
    E save(E entity);
}
