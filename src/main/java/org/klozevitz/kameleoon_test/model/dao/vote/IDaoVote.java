package org.klozevitz.kameleoon_test.model.dao.vote;

import org.klozevitz.kameleoon_test.model.dao.IDaoDB;
import org.klozevitz.kameleoon_test.model.entities.Quote;
import org.klozevitz.kameleoon_test.model.entities.Vote;

import java.util.List;

public interface IDaoVote extends IDaoDB<Vote> {
    List<Vote> findAll();
    List<Vote> findAllByQuote(Quote quote);
    Vote delete(Long id);
}
