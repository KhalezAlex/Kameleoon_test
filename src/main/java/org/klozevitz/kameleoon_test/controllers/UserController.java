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

    @PostMapping("/save")
    public User save(@RequestParam String name, @RequestParam String password,
                     @RequestParam(required = false) String email) {
        if (email == null) {
            return userDao.save(new User(name, password));
        }
        return userDao.save(new User(name, email, password));
    }
}
