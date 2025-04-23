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
    public Usuario editarSenha(Long id, String password) {
        Usuario user = findById(id);
        user.setPassword(password);
        return user;
    }
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }
}
