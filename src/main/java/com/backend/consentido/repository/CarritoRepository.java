package com.backend.consentido.repository;

import com.backend.consentido.model.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    Optional<Carrito> findByUsuario_IdUsuario(Long idUsuario);


}
