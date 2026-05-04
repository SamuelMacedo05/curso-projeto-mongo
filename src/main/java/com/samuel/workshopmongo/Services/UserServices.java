package com.samuel.workshopmongo.Services;


import com.samuel.workshopmongo.Services.exception.ObjectNotFoundException;
import com.samuel.workshopmongo.UserRepository;
import com.samuel.workshopmongo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User FindById(String id ){
        Optional<User> obj = repo.findById(id);
       return obj.orElseThrow(() -> new  ObjectNotFoundException(" Objeto não encontrado"));
    }


}
