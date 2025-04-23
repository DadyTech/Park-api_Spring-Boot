package com.dev_dady.park_api.service;

import com.dev_dady.park_api.model.entity.Usuario;
import com.dev_dady.park_api.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario createUser(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
   @Transactional(readOnly = true)
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("usuario nao encontrado"));
    }
    @Transactional
    public Usuario editarSenha(Long id, String senhaAtual, String novaSenha, String confirmaSenha) {
        if (!novaSenha.equals(confirmaSenha)){
            throw  new RuntimeException("Nova senha nao confere com confirmacao de senha. ");
        }

        Usuario user = findById(id);
        if (!user.getPassword().equals(senhaAtual)){
            throw new RuntimeException("Sua senha nao confere. ");
        }
        user.setPassword(novaSenha);
        return user;
    }
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}
