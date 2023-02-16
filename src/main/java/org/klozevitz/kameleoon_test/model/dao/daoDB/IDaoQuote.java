package org.klozevitz.kameleoon_test.model.dao.daoDB;

import org.klozevitz.kameleoon_test.model.entities.Quote;

import java.util.List;
import java.util.Map;

public interface IDaoQuote extends IDaoDB<Quote> {
    List<Quote> findAll();
    Quote update(Quote quote);
    Quote delete(Long id);

    List<Quote> getTopTen();
    List<Quote> getWorstTen();
    Map<Double, Double> getGraphMap(Quote quote);
}
