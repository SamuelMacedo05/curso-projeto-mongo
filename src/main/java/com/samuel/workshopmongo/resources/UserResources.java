package com.samuel.workshopmongo.resources;

import com.samuel.workshopmongo.Services.UserServices;
import com.samuel.workshopmongo.domain.User;
import com.samuel.workshopmongo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
    @RequestMapping (value = "/users")
    public class UserResources {

        @Autowired
        private UserServices service;

        @GetMapping
        public ResponseEntity<List<UserDTO>> findAll() {
            List<User> list = service.findAll();
            List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
            return ResponseEntity.ok().body(listDTO);

        }
    }

