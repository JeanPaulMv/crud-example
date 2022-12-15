package com.jp.crudexample.services;

import com.jp.crudexample.models.User;
import com.jp.crudexample.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) {
        User userDb = userRepository.findById(id).orElse(null);
        userDb.setName(user.getName());
        userDb.setDirection(user.getDirection());
        userDb.setEmail(userDb.getEmail());
        return userRepository.save(userDb);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findOneUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
