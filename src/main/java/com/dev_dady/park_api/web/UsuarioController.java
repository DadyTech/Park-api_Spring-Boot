package com.dev_dady.park_api.web;

import com.dev_dady.park_api.model.entity.Usuario;
import com.dev_dady.park_api.service.UsuarioService;
import com.dev_dady.park_api.web.dto.UsuarioCreateDto;
import com.dev_dady.park_api.web.dto.UsuarioEditarSenha;
import com.dev_dady.park_api.web.dto.UsuarioResponseDto;
import com.dev_dady.park_api.web.dto.mapper.UsuarioMapper;
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
    public ResponseEntity<UsuarioResponseDto> createUser(@RequestBody UsuarioCreateDto usuarioCreateDto){
        Usuario user = usuarioService.createUser(UsuarioMapper.toUsuario(usuarioCreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> buscarPorId(@PathVariable Long id){
       Usuario user = usuarioService.findById(id);
       return ResponseEntity.ok(UsuarioMapper.toDto(user));

    }
    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> editarSenha(@PathVariable Long id,@RequestBody UsuarioEditarSenha dto){
        Usuario user = usuarioService.editarSenha(id, dto.getSenhaAtual(),dto.getNovaSenha(),dto.getConfirmaSenha());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping
    public ResponseEntity<List<Usuario>> findAll(){
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }
}
