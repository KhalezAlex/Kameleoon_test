package org.klozevitz.kameleoon_test.model.dao.daoDB;

import org.klozevitz.kameleoon_test.model.entities.Quote;
import org.klozevitz.kameleoon_test.model.entities.dto.QuoteDTO;

import java.util.LinkedList;
import java.util.List;

public interface IDaoQuote extends IDaoDB<Quote> {
    List<Quote> findAll();
    Quote update(Quote quote);
    Quote delete(Long id);
    Quote random();
    LinkedList<QuoteDTO> getTopTen();
    LinkedList<QuoteDTO> getWorstTen();
}
