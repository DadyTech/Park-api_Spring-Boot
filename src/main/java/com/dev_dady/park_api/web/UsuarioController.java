package com.dev_dady.park_api.web;

import com.dev_dady.park_api.model.entity.Usuario;
import com.dev_dady.park_api.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<Usuario> createUser(Usuario usuario){
        Usuario user = usuarioService.createUser(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
