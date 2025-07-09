package com.uca.parcialfinalncapas.dto.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String nombre;
    private String correo;
    private String password;
    private String nombreRol;
}
