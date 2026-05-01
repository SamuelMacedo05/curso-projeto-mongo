package com.samuel.workshopmongo.resources;

import com.samuel.workshopmongo.Services.UserServices;
import com.samuel.workshopmongo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
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

        @Autowired
        private UserServices service;

        @GetMapping
        public ResponseEntity<List<User>> findAll() {
            List<User> list = service.findAll();
            return ResponseEntity.ok().body(list);

        }
    }

