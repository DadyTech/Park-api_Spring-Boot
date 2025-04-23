package com.dev_dady.park_api.web;

import com.dev_dady.park_api.model.entity.Usuario;
import com.dev_dady.park_api.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario){
        Usuario user = usuarioService.createUser(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
       Usuario user = usuarioService.findById(id);
       return ResponseEntity.ok(user);

    }
    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> editarSenha(@PathVariable Long id,@RequestBody Usuario usuario){
        Usuario user = usuarioService.editarSenha(id,usuario.getPassword());
        return ResponseEntity.ok(user);
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }
}
