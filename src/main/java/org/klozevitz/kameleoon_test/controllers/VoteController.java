package org.klozevitz.kameleoon_test.controllers;

import org.klozevitz.kameleoon_test.model.dao.quote.IDaoQuote;
import org.klozevitz.kameleoon_test.model.dao.vote.IDaoVote;
import org.klozevitz.kameleoon_test.model.entities.Quote;
import org.klozevitz.kameleoon_test.model.entities.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/vote")
public class VoteController {
    @Autowired
    IDaoVote voteDao;
    @Autowired
    IDaoQuote quoteDao;

    @GetMapping("/all")
    public List<Vote> all() {
        return voteDao.findAll();
    }

    @GetMapping("/findById")
    public Vote findById(int id) {
        return voteDao.findById(id);
    }

//saves new vote to "vote_t" table (returns nullObject if quote does not exist)
    @PostMapping("/vote")
    public Vote vote(@RequestParam boolean vote, @RequestParam int quoteId) {
        Quote quote = quoteDao.findById(quoteId);
        if (quote.getId() != -1) {
            return voteDao.save(new Vote(vote, quote));
        }
        return new Vote();
    }
}