package com.banco.conta.controller;

import com.banco.conta.model.Conta;
import com.banco.conta.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {

    @Autowired
    private final ContaService service;

    public ContaController(ContaService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Conta>> buscarConta(){
        return ResponseEntity.ok(service.buscarConta());
    }

    @PostMapping
    public ResponseEntity<Void> adicionarConta(@RequestBody Conta conta){
        service.adicionarConta(conta);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarConta(@RequestParam Long id,
                                               @RequestBody Conta conta){
        service.atualizarConta(id, conta);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarConta(@RequestParam Long id){
        service.deletarConta(id);
        return ResponseEntity.ok().build();
    }
}
