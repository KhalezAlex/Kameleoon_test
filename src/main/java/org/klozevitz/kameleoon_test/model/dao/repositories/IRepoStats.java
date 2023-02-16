package org.klozevitz.kameleoon_test.model.dao.repositories;

import org.klozevitz.kameleoon_test.model.entities.Stats;
import org.springframework.data.repository.CrudRepository;

public interface IRepoStats extends CrudRepository<Stats, Long> {
}
