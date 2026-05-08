package com.samuel.workshopmongo.dto;

import com.samuel.workshopmongo.domain.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class AuthorDTO implements Serializable {

    private static final long serialVersionUID = 1L;



    @Id
    private String id;
    private String name;

    public AuthorDTO(){

    }
    public AuthorDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
