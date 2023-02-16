package org.klozevitz.kameleoon_test.model.dao.repositories;

import org.klozevitz.kameleoon_test.model.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IRepoUser extends CrudRepository<User, Long> {
    Optional<User> findByName(String name);
}
