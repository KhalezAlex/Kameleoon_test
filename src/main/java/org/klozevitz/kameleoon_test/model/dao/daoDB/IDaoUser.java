package org.klozevitz.kameleoon_test.model.dao.daoDB;

import org.klozevitz.kameleoon_test.model.dao.daoDB.IDaoDB;
import org.klozevitz.kameleoon_test.model.entities.User;

import java.util.List;

public interface IDaoUser extends IDaoDB<User> {
    List<User> findAll();
}
