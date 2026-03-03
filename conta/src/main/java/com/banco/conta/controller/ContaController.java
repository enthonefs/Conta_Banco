package com.banco.conta.controller;

import com.banco.conta.model.Conta;
import com.banco.conta.service.ContaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
@RequiredArgsConstructor
public class ContaController {

    @Autowired
    private final ContaService service;

    @GetMapping
    public ResponseEntity<List<Conta>> buscarTodos(){
        return ResponseEntity.ok(service.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> adicionarConta(@PathVariable Long id, @RequestBody Conta conta){
        service.adicionarConta(id, conta);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarConta(@PathVariable Long id,
                                               @RequestBody Conta conta){
        service.atualizarConta(id, conta);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConta(@PathVariable Long id){
        service.deletarConta(id);
        return ResponseEntity.ok().build();
    }
}
