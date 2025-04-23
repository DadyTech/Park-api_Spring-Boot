package com.dev_dady.park_api.web.dto.mapper;

import com.dev_dady.park_api.model.entity.Usuario;
import com.dev_dady.park_api.web.dto.UsuarioCreateDto;
import com.dev_dady.park_api.web.dto.UsuarioResponseDto;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

public class UsuarioMapper {

    public static Usuario toUsuario(UsuarioCreateDto usuarioCreateDto){
        return  new ModelMapper().map(usuarioCreateDto,Usuario.class);
    }

    public  static UsuarioResponseDto toDto(Usuario usuario){
        String role = usuario.getRole().name().substring("ROLE_".length());
        ModelMapper modelMapper = new ModelMapper();
        TypeMap<Usuario,UsuarioResponseDto> propertyManpper = modelMapper.createTypeMap(Usuario.class,UsuarioResponseDto.class);
        propertyManpper.addMappings(mapper -> mapper.map(src->role,UsuarioResponseDto::setRole));
        return modelMapper.map(usuario,UsuarioResponseDto.class);
    }
}
