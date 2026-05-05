package com.samuel.workshopmongo.Services;


import com.samuel.workshopmongo.Services.exception.ObjectNotFoundException;
import com.samuel.workshopmongo.UserRepository;
import com.samuel.workshopmongo.domain.User;
import com.samuel.workshopmongo.dto.UserDTO;
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

    public User insert(User obj) {
        return repo.insert(obj);
    }

    public void delete(String id) {
        FindById(id);
        repo.deleteById(id);
    }
    public User update(User obj) {
        User newObj = FindById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }


}
