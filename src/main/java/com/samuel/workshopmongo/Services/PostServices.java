package com.samuel.workshopmongo.Services;


import com.samuel.workshopmongo.Repository.PostRepository;
import com.samuel.workshopmongo.Repository.UserRepository;
import com.samuel.workshopmongo.Services.exception.ObjectNotFoundException;
import com.samuel.workshopmongo.domain.Post;
import com.samuel.workshopmongo.domain.User;
import com.samuel.workshopmongo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServices {

    @Autowired
    private PostRepository repo;

    public Post FindById(String id ){
        Optional<Post> obj = repo.findById(id);
       return obj.orElseThrow(() -> new  ObjectNotFoundException(" Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }



}


