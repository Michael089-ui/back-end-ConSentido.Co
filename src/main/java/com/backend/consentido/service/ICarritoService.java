package com.backend.consentido.service;

import com.backend.consentido.model.Carrito;

import java.util.Optional;

public interface ICarritoService {
    Optional<Carrito> obtenerOCrearCarrito(Long idUsuario);
    void agregarItem(Long idUsuario, Integer idProducto, int cantidad);
}
