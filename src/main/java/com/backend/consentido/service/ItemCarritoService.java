package com.backend.consentido.service;

import com.backend.consentido.model.ItemCarrito;
import com.backend.consentido.repository.ItemCarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemCarritoService implements IItemCarritoService {

    private final ItemCarritoRepository itemCarritoRepository;

    @Autowired
    public ItemCarritoService(ItemCarritoRepository itemCarritoRepository) {
        this.itemCarritoRepository = itemCarritoRepository;
    }

    @Override
    public List<ItemCarrito> findAll() {
        return itemCarritoRepository.findAll();
    }

    @Override
    public Optional<ItemCarrito> findById(Long id) {
        return itemCarritoRepository.findById(id);
    }

    @Override
    public ItemCarrito save(ItemCarrito itemCarrito) {
        return itemCarritoRepository.save(itemCarrito);
    }

    @Override
    public void deleteById(Long id) {
        itemCarritoRepository.deleteById(id);
    }

    @Override
    public void eliminarItemPorId(Long idItem) {
        itemCarritoRepository.deleteById(idItem);
    }

    @Override
    public List<ItemCarrito> obtenerItemsPorCarrito(Long idCarrito) {
        return itemCarritoRepository.findByCarritoId(idCarrito);
    }
}
