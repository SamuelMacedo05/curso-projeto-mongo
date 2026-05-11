package com.samuel.workshopmongo.resources;

import com.samuel.workshopmongo.Services.PostServices;
import com.samuel.workshopmongo.Services.UserServices;
import com.samuel.workshopmongo.domain.Post;
import com.samuel.workshopmongo.domain.User;
import com.samuel.workshopmongo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
    @RequestMapping (value = "/posts")
    public class PostResources {

        @Autowired
        private PostServices service;


      @GetMapping
      @RequestMapping(value = "/{id}")
       public ResponseEntity<Post> findById(@PathVariable String id) {
            Post obj = service.FindById(id);
            return ResponseEntity.ok().body(obj);

    }

}
