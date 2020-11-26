package com.wipro.assignment.services;

import java.util.Optional;

import com.wipro.assignment.entities.User;
import com.wipro.assignment.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<User> findByID(Long id){
        Optional<User> user = userRepository.findByID(id);
        if(user.isPresent()){
            return new ResponseEntity<User>(user.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND); //could use 204?
        }
    }

    public ResponseEntity<String> addUser(User user){
        userRepository.save(user);
        return new ResponseEntity<String>(user.toString(), HttpStatus.CREATED);
    }
}
