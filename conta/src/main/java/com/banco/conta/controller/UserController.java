package com.banco.conta.controller;

import com.banco.conta.model.User;
import com.banco.conta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<User>> buscarUsuarios(){
        return ResponseEntity.ok().body(service.buscarUsuarios());
    }

    @PostMapping
    public ResponseEntity<Void> criarUsuario(@RequestBody User user){
        service.criarUsuario(user);
        return ResponseEntity.ok().build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarUsuario(@PathVariable Long id, @RequestBody User user){
        service.atualizarUsuario(id, user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id){
        service.deletarUsuario(id);
        return ResponseEntity.ok().build();
    }

}
