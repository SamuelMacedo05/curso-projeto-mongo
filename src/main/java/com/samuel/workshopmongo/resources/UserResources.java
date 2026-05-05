package com.samuel.workshopmongo.resources;

import com.samuel.workshopmongo.Services.UserServices;
import com.samuel.workshopmongo.domain.User;
import com.samuel.workshopmongo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

      @GetMapping
      @RequestMapping(value = "/{id}")
       public ResponseEntity<UserDTO> findById(@PathVariable String id) {
            User obj = service.FindById(id);
            return ResponseEntity.ok().body(new UserDTO(obj));

    }

    @PostMapping
      public ResponseEntity<Void> insert( @RequestBody UserDTO objDto) {
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
         service.delete(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * PROCESSO DE ATUALIZAÇÃO DE USUÁRIO:
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {

        // 2. Converte os dados brutos (DTO) para um objeto do tipo Usuário.
        User obj = service.fromDTO(objDto);

        // 3. Garante que o objeto tenha o ID correto da URL.
        obj.setId(id);

        // 4. Envia para o serviço gravar as mudanças no banco de dados.
        obj = service.update(obj);

        // 5. Retorna o status 204 (No Content) indicando sucesso sem corpo na resposta.
        return ResponseEntity.noContent().build();
    }

    }

