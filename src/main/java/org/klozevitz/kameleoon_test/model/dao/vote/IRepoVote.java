package org.klozevitz.kameleoon_test.model.dao.vote;

import org.klozevitz.kameleoon_test.model.entities.Quote;
import org.klozevitz.kameleoon_test.model.entities.Vote;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IRepoVote extends CrudRepository<Vote, Long> {
    List<Vote> findAllByQuote(Quote quote);
}
