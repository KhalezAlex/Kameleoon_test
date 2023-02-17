package org.klozevitz.kameleoon_test.controllers;

import org.klozevitz.kameleoon_test.model.dao.daoDB.IDaoUser;
import org.klozevitz.kameleoon_test.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    IDaoUser userDao;

    @GetMapping("/findById")
    public User find(@RequestParam int id) {
        return userDao.findById(id);
    }

    @PostMapping("/save")
    public void save(@RequestParam String name, @RequestParam String password,
                     @RequestParam(required = false) String email) {
        if (email == null) {
            userDao.save(new User(name, password));
        }
        userDao.save(new User(name, email, password));
    }
}
