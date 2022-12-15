package com.jp.crudexample.services;

import com.jp.crudexample.models.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> findAllUsers();
    User updateUser(Long id,User user);
    void deleteUser(Long id);

    User findOneUser(Long id);

}
