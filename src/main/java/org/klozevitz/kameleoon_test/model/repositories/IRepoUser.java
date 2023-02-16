package org.klozevitz.kameleoon_test.model.repositories;

import org.klozevitz.kameleoon_test.model.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface IRepoUser extends CrudRepository<User, Long> {
}
