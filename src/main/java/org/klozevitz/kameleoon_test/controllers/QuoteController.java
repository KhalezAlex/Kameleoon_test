package org.klozevitz.kameleoon_test.controllers;

import org.klozevitz.kameleoon_test.model.dao.daoDB.IDaoQuote;
import org.klozevitz.kameleoon_test.model.dao.daoDB.IDaoUser;
import org.klozevitz.kameleoon_test.model.entities.Quote;
import org.klozevitz.kameleoon_test.model.entities.User;
import org.klozevitz.kameleoon_test.model.entities.dto.QuoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(path = "/quote")
public class QuoteController {
    @Autowired
    IDaoQuote quoteDao;
    @Autowired
    IDaoUser userDao;


    @GetMapping("/all")
    List<Quote> all() {
        return quoteDao.findAll();
    }

    @GetMapping("/findById")
    Quote findById(@RequestParam int id) {
        return quoteDao.findById(id);
    }

    @PostMapping("/save")
    @Transactional
    public Quote save(@RequestParam String content, @RequestParam int userId) {
        User user = userDao.findById(userId);
        if (user.getId() != -1L) {
            return quoteDao.save(new Quote(content, user));
        }
        return new Quote();
    }

    @PostMapping("/update")
    Quote update(@RequestParam Long quoteId, String content) {
        return quoteDao.update(new Quote(quoteId, content));
    }

    @GetMapping("/delete")
    Quote delete(@RequestParam int id) {
        return quoteDao.delete((long)   id);
    }

    @GetMapping("/top_ten")
    LinkedList<QuoteDTO> topTen() {
        return quoteDao.getTopTen();
    }

    @GetMapping("/worst_ten")
    LinkedList<QuoteDTO> worstTen() {
        return quoteDao.getWorstTen();
    }

    @GetMapping("/random")
    Quote random() {
        return quoteDao.random();
    }
}
