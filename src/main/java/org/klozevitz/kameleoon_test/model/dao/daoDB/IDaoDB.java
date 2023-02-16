package org.klozevitz.kameleoon_test.model.dao.daoDB;

public interface IDaoDB<E> {
    E findById(Long id);
    E save(E e);
}
