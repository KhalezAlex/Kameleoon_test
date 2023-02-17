package org.klozevitz.kameleoon_test.model.dao.user;

import org.klozevitz.kameleoon_test.model.dao.IDaoDB;
import org.klozevitz.kameleoon_test.model.entities.User;

import java.util.List;

public interface IDaoUser extends IDaoDB<User> {
    List<User> findAll();
}
