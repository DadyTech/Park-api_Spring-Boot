package com.dev_dady.park_api.web.dto;

public class UsuarioResponseDto {

    private Long id;
    private  String username;
    private String role;

    public UsuarioResponseDto(Long id, String username, String role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public UsuarioResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
