package org.klozevitz.kameleoon_test.model.dao.services;

import org.klozevitz.kameleoon_test.model.dao.daoDB.IDaoQuote;
import org.klozevitz.kameleoon_test.model.dao.repositories.IRepoQuote;
import org.klozevitz.kameleoon_test.model.dao.repositories.IRepoUser;
import org.klozevitz.kameleoon_test.model.dao.repositories.IRepoVote;
import org.klozevitz.kameleoon_test.model.dao.services.utilities.QuoteRateComparator;
import org.klozevitz.kameleoon_test.model.dao.services.utilities.VoteIdComparator;
import org.klozevitz.kameleoon_test.model.entities.Quote;
import org.klozevitz.kameleoon_test.model.entities.User;
import org.klozevitz.kameleoon_test.model.entities.Vote;
import org.klozevitz.kameleoon_test.model.entities.dto.QuoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;

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
    public Quote random() {
        List<Quote> list = (List<Quote>)quoteRepo.findAll();
        return list.get((int) (Math.random() * list.size()));
    }

    @Override
    public LinkedList<QuoteDTO> getTopTen() {
        ArrayList<Quote> sorted = allSortedByRate();
        LinkedList<QuoteDTO> topTen = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Quote quote = sorted.remove(sorted.size() - 1);
            ArrayList<Vote> votes = getVotesSortedByDate(quote);
            topTen.add(new QuoteDTO(quote, quote.rate(), votes.get(0).getDate(), getGraphMap(quote)));
        }
        return topTen;
    }

    @Override
    public LinkedList<QuoteDTO> getWorstTen() {
        ArrayList<Quote> sorted = allSortedByRate();
        LinkedList<QuoteDTO> worstTen = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Quote quote = sorted.remove(0);
            ArrayList<Vote> votes = getVotesSortedByDate(quote);
            worstTen.add(new QuoteDTO(quote, quote.rate(), votes.get(0).getDate(), getGraphMap(quote)));
        }
        return worstTen;
    }

// Gert sorted by rate quote arraylist
    private ArrayList<Quote> allSortedByRate() {
        ArrayList<Quote> list = ((ArrayList<Quote>) quoteRepo.findAll());
        list.sort(new QuoteRateComparator());
        return list;
    }

    private LinkedList<Integer> getGraphMap(Quote quote) {
        LinkedList<Integer> cordsList = new LinkedList<>();
        int rate = 0;
        ArrayList<Vote> votes = getVotesSortedByDate(quote);
        if (votes.size() == 0)
            return cordsList;
        Vote vote = votes.remove(0);
        LocalDate date = vote.getDate();
        rate += vote.getVote() ? 1 : -1;
        cordsList.add(rate);
        for (Vote v: votes) {
            while(date.isBefore(v.getDate())) {
                date = date.plusDays(1);
                cordsList.add(rate);
            }
            rate += v.getVote() ? 1 : -1;
//            cordsList.add(new HashMap<>());
            cordsList.pollLast();
            cordsList.add(rate);
        }
        return cordsList;
    }

    private ArrayList<Vote> getVotesSortedByDate(Quote quote) {
        ArrayList<Vote> votes = new ArrayList<>(quote.getVotes());
        votes.sort(new VoteIdComparator());
        return votes;
    }
}
