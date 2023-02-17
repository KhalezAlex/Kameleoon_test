package org.klozevitz.kameleoon_test.model.dao.quote;

import org.klozevitz.kameleoon_test.model.entities.Quote;
import org.springframework.data.repository.CrudRepository;

public interface IRepoQuote extends CrudRepository<Quote, Long> {
}
