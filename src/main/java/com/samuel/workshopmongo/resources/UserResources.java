package com.samuel.workshopmongo.resources;

import com.samuel.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    @RestController
    @RequestMapping (value = "/users")
    public class UserResources {

        @GetMapping
        public ResponseEntity<List<User>> findAll() {
            User maria = new User("maria", "1" , "maria@gmail.com");
            User alex = new User("alex", "2" , "alex@gmail.com");
            List<User> list = new ArrayList<>(Arrays.asList(maria, alex));
            return ResponseEntity.ok().body(list);

        }
    }

