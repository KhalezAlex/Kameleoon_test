package org.klozevitz.kameleoon_test.model.repositories;

import org.klozevitz.kameleoon_test.model.entities.Stats;
import org.springframework.data.repository.CrudRepository;

public interface IRepoLike extends CrudRepository<Stats, Long> {
}
