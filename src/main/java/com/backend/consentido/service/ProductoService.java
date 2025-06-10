package com.backend.consentido.service;

import com.backend.consentido.model.Producto;
import com.backend.consentido.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService {

    private final IProductoRepository productoRepository;

    @Autowired
    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerPorId(Long id) {
        if (id == null || id > Integer.MAX_VALUE || id < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("ID fuera del rango válido para Integer");
        }
        return productoRepository.findById(id.intValue()).orElse(null);
    }

    @Override
    public void guardarProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        if (id == null || id > Integer.MAX_VALUE || id < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("ID fuera del rango válido para Integer");
        }
        productoRepository.deleteById(id.intValue());
    }

    @Override
    public void editarProducto(Long id, Producto productoActualizado) {
        if (id == null || id > Integer.MAX_VALUE || id < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("ID fuera del rango válido para Integer");
        }

        Producto productoExistente = productoRepository.findById(id.intValue()).orElse(null);
        if (productoExistente != null) {
            productoExistente.setNombre(productoActualizado.getNombre());
            productoExistente.setDescripcion(productoActualizado.getDescripcion());
            productoExistente.setEstado(productoActualizado.getEstado());
            productoExistente.setImagen(productoActualizado.getImagen());
            productoExistente.setPrecio(productoActualizado.getPrecio());
            productoExistente.setStock(productoActualizado.getStock());
            productoExistente.setCategoria(productoActualizado.getCategoria());
            productoRepository.save(productoExistente);
        } else {
            throw new RuntimeException("Producto no encontrado con el id " + id);
        }
    }
}
