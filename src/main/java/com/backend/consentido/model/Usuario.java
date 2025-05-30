package com.backend.consentido.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_usuario;
    private String contrasena;
    private String nombre;

}

//-- Tabla Usuario
//CREATE TABLE Usuario (
//        id_usuario INT PRIMARY KEY AUTO_INCREMENT,
//        contrasena VARCHAR(100),
//nombre VARCHAR(100),
//rol ENUM('Administrador', 'Usuario') NOT NULL
//)ENGINE=InnoDB;
