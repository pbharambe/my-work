package com.himwork.controller;

import com.himwork.domain.Customer;
import com.himwork.domain.UserModel;
import com.himwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TutorialController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/registration")
    public ResponseEntity<?> registerUser(@RequestBody UserModel userModel) {
        // get the data passed by user/passed to postman
        Customer user = new Customer(
                userModel.getName(),
                userModel.getAge(),
                userModel.getPhoneNumber()
        );
        //save data passed by user
        Customer userSaved = userRepository.save(user);
        // return the saved data and an Okay.
        return new ResponseEntity(userSaved, HttpStatus.OK);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<?> getUser() {
        List<Customer> getUser = userRepository.findAll();
        return new ResponseEntity(getUser, HttpStatus.OK);
    }
}
