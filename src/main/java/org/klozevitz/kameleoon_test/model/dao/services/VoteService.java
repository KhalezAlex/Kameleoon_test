package org.klozevitz.kameleoon_test.model.dao.services;

import org.klozevitz.kameleoon_test.model.dao.daoDB.IDaoVote;
import org.klozevitz.kameleoon_test.model.dao.repositories.IRepoQuote;
import org.klozevitz.kameleoon_test.model.dao.repositories.IRepoVote;
import org.klozevitz.kameleoon_test.model.entities.Quote;
import org.klozevitz.kameleoon_test.model.entities.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteService implements IDaoVote {
    @Autowired
    IRepoVote voteRepo;
    @Autowired
    IRepoQuote quoteRepo;

    @Override
    public Vote findById(int id) {
        return voteRepo.findById((long) id).orElse(new Vote());
    }

    @Override
    public Vote save(Vote vote) {
        Quote quote = quoteRepo.findById(vote.getQuote().getId()).orElse(new Quote());
        if (quote.getId() == -1L) {
            return new Vote();
        }
        Vote saved = voteRepo.save(vote);
        quote.getVotes().add(saved);
        return saved;
    }

    @Override
    public List<Vote> findAll() {
        return (List<Vote>) voteRepo.findAll();
    }

    @Override
    public List<Vote> findAllByQuote(Quote quote) {
        return voteRepo.findAllByQuote(quote);
    }

    @Override
    public Vote delete(Long id) {
        Vote deleted = voteRepo.findById(id).orElse(new Vote());
        if (deleted.getId() == -1L)
            return new Vote();
        deleted.getQuote().getVotes().remove(deleted);
        voteRepo.delete(deleted);
        return deleted;
    }
}
