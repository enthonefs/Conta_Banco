package com.banco.conta.service;


import com.banco.conta.model.Conta;
import com.banco.conta.model.User;
import com.banco.conta.repository.ContaRepository;
import com.banco.conta.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public List<User> buscarUsuarios(){
        return userRepository.findAll();
    }

    public void criarUsuario(User user){
        userRepository.save(user);
    }

    public void atualizarUsuario(Long id, User user){
        User usuarioEncontrado = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Id de Usuário indiponível."));

        User usuarioAtualizado = User.builder()
                .nome(user.getNome() != null ? user.getNome() : usuarioEncontrado.getNome())
                .login(user.getLogin() != null ? user.getLogin() : usuarioEncontrado.getNome())
                .senha(user.getSenha() != null ? user.getSenha() : usuarioEncontrado.getSenha())
                .id(usuarioEncontrado.getId())
                .build();

        userRepository.saveAndFlush(usuarioAtualizado);

    }

    public void deletarUsuario(Long id){
        userRepository.deleteById(id);

    }

}
