package org.klozevitz.kameleoon_test.model.dao.user;

import org.klozevitz.kameleoon_test.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService implements IDaoUser {
    @Autowired
    private IRepoUser userRepo;

    @Autowired
    private BCryptPasswordEncoder encoder;


//needed for tests
    @Override
    public User findById(int id) {
        return userRepo.findById((long) id).orElse(new User());
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepo.findAll();
    }

//would not save duplicate usernames. returns nullObject instead
    @Override
    public User save(User user) {
        if (userRepo.findByName(user.getName()).isPresent()) {
            return new User();
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
