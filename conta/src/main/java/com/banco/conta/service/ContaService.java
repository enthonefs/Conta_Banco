package com.banco.conta.service;

import com.banco.conta.model.Conta;
import com.banco.conta.model.User;
import com.banco.conta.repository.ContaRepository;
import com.banco.conta.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContaService {

    private final ContaRepository repository;
    private final UserRepository userRepository;

    public void adicionarConta(Long id, Conta conta){
        User userEncontrado = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Id de Usuário não encontrado."));

        conta.setUser(userEncontrado);
        repository.saveAndFlush(conta);
    }


    public void atualizarConta(Long id, Conta conta){
        Conta contaEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Id indisponível"));
        Conta contaNova = Conta.builder()
                .saldo(conta.getSaldo() != 0 ? conta.getSaldo() : contaEntity.getSaldo())
                .user(contaEntity.getUser())
                .numero(contaEntity.getNumero())
                .id(contaEntity.getId())
                .build();

        repository.saveAndFlush(contaNova);

    }

    public List<Conta> buscarTodos(){
        return repository.findAll();

    }

    public void deletarConta(Long id){
        repository.deleteById(id);

    }

    public Conta buscarPorId(Long id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Id indisponível")
        );

    }
}
