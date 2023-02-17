package org.klozevitz.kameleoon_test.model.dao.services.utilities;

import org.klozevitz.kameleoon_test.model.entities.Quote;

import java.util.Comparator;

/**
Quote comparator by rate
*/
public class QuoteRateComparator implements Comparator<Quote> {
    @Override
    public int compare(Quote q1, Quote q2) {
        return Integer.compare(q1.rate(), q2.rate());
    }
}
