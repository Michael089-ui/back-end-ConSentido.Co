package com.backend.consentido.service;

import com.backend.consentido.model.ItemCarrito;

import java.util.List;
import java.util.Optional;

public interface IItemCarritoService {

    List<ItemCarrito> findAll();

    Optional<ItemCarrito> findById(Long id);

    ItemCarrito save(ItemCarrito itemCarrito);

    void deleteById(Long id);

    void eliminarItemPorId(Long idItem);

    List<ItemCarrito> obtenerItemsPorCarrito(Long idCarrito);
}
