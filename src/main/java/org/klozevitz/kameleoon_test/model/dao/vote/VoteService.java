package org.klozevitz.kameleoon_test.model.dao.vote;

import org.klozevitz.kameleoon_test.model.dao.quote.IRepoQuote;
import org.klozevitz.kameleoon_test.model.entities.Quote;
import org.klozevitz.kameleoon_test.model.entities.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VoteService implements IDaoVote {
    @Autowired
    private IRepoVote voteRepo;
    @Autowired
    private IRepoQuote quoteRepo;

    @Override
    public Vote findById(int id) {
        return voteRepo.findById((long) id).orElse(new Vote());
    }

//saves Vote object to "vote_t" table. returns nullObject if quote does not exist
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

//returns list of Votes selected byy specified quote
    @Override
    public List<Vote> findAllByQuote(Quote quote) {
        return voteRepo.findAllByQuote(quote);
    }

//deletes vote (returns nullObject if vote does not exist) and its references
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
