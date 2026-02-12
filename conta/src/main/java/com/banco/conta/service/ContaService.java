package com.banco.conta.service;

import com.banco.conta.model.Conta;
import com.banco.conta.repository.ContaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    private final ContaRepository repository;

    public ContaService(ContaRepository repository) {
        this.repository = repository;
    }

    public void adicionarConta(Conta conta){
        repository.saveAndFlush(conta);
    }


    public void atualizarConta(Long id, Conta conta){
        Conta contaEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Id indisponível"));
        Conta contaNova = Conta.builder()
                .username(conta.getUsername() != null ? conta.getUsername() : contaEntity.getUsername())
                .password(conta.getPassword() != null ? conta.getPassword() : contaEntity.getUsername())
                .saldo(conta.getSaldo() != 0 ? conta.getSaldo() : contaEntity.getSaldo())
                .id(contaEntity.getId())
                .build();

        repository.saveAndFlush(contaNova);

    }

    public List<Conta> buscarConta(){
        return repository.findAll();

    }

    public void deletarConta(Long id){
        repository.deleteById(id);

    }
}
