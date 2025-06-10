package com.backend.consentido.repository;

import com.backend.consentido.model.ItemCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemCarritoRepository extends JpaRepository<ItemCarrito, Long> {
    List<ItemCarrito> findByCarritoId(Long carritoId);
    Optional<ItemCarrito> findByCarrito_IdAndProducto_IdProducto(Long carritoId, Integer productoId);

}
