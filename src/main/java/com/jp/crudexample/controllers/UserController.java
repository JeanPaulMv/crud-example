package com.jp.crudexample.controllers;

import com.jp.crudexample.models.User;
import com.jp.crudexample.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> users = userService.findAllUsers();
        if (users.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(users,HttpStatus.OK);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> findOneUser(@PathVariable("id")Long id){
        User user = userService.findOneUser(id);
        if (user != null){
            return new ResponseEntity<>(user,HttpStatus.FOUND);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        if (user.getEmail().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }else {
            return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        if (user.getEmail().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }else {
            return new ResponseEntity<>(userService.updateUser(id,user),HttpStatus.ACCEPTED);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id){
        User user = userService.findOneUser(id);
        if (user != null){
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
