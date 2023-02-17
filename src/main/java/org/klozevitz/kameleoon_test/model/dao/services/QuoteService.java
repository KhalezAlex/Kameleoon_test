package org.klozevitz.kameleoon_test.model.dao.services;

import org.klozevitz.kameleoon_test.model.dao.daoDB.IDaoQuote;
import org.klozevitz.kameleoon_test.model.dao.repositories.IRepoQuote;
import org.klozevitz.kameleoon_test.model.dao.repositories.IRepoUser;
import org.klozevitz.kameleoon_test.model.dao.repositories.IRepoVote;
import org.klozevitz.kameleoon_test.model.entities.Quote;
import org.klozevitz.kameleoon_test.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class QuoteService implements IDaoQuote {
    @Autowired
    IRepoQuote quoteRepo;
    @Autowired
    IRepoUser userRepo;
    @Autowired
    IRepoVote voteRepo;


    @Override
    public List<Quote> findAll() {
        return (List<Quote>) quoteRepo.findAll();
    }

    @Override
    public Quote findById(int id) {
        return quoteRepo.findById((long) id).orElse(new Quote());
    }

    @Override
    public Quote save(Quote quote) {
        Quote saved = quoteRepo.save(quote);
        User user = userRepo.findById(quote.getUser().getId()).orElse(new User());
        user.getQuotes().add(saved);
        return saved;
    }

    @Override
    @Transactional
    public Quote update(Quote quote) {
        Quote updated = quoteRepo.findById(quote.getId()).orElse(new Quote());
        if (updated.getId() == -1) {
            return updated;
        }
        updated.setContent(quote.getContent());
        updated.setUpdated(quote.getUpdated());
        return updated;
    }

    @Override
    public Quote delete(Long id) {
        Quote deleted = quoteRepo.findById(id).orElse(new Quote());
        if (deleted.getId() == -1) {
            return deleted;
        }
        userRepo.findById(deleted.getUser().getId()).orElse(new User()).
                getQuotes().remove(deleted);
        voteRepo.deleteAll(voteRepo.findAllByQuote(deleted));
        quoteRepo.delete(deleted);
        return deleted;
    }

    @Override
    public List<Quote> getTopTen() {
        return null;
    }

    @Override
    public List<Quote> getWorstTen() {
        return null;
    }

    @Override
    public Map<Double, Double> getGraphMap(Quote quote) {
        return null;
    }
}
