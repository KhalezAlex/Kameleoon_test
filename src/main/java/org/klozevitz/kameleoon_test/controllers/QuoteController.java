package org.klozevitz.kameleoon_test.controllers;

import org.klozevitz.kameleoon_test.model.dao.daoDB.IDaoQuote;
import org.klozevitz.kameleoon_test.model.dao.daoDB.IDaoUser;
import org.klozevitz.kameleoon_test.model.entities.Quote;
import org.klozevitz.kameleoon_test.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public void save(@RequestParam String content, @RequestParam int userId) {
        User user = userDao.findById(userId);
        if (user.getId() != -1L) {
            quoteDao.save(new Quote(content, user));
        }
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
    List<Quote> topTen() {
        return null;
    }

    @GetMapping("/worst_ten")
    List<Quote> worstTen() {
        return null;
    }

    @GetMapping("/graph_map")
    Map<Integer, Integer> graphMap() {
        return null;
    }
}
