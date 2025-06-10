package com.backend.consentido.service;

import com.backend.consentido.model.Producto;
import com.backend.consentido.model.Usuario;
import com.backend.consentido.model.Carrito;
import com.backend.consentido.model.ItemCarrito;
import com.backend.consentido.repository.CarritoRepository;
import com.backend.consentido.repository.IProductoRepository;
import com.backend.consentido.repository.ItemCarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarritoService implements ICarritoService {

    private final CarritoRepository carritoRepository;
    private final ItemCarritoRepository itemCarritoRepository;
    private final IProductoRepository productoRepository;

    @Autowired
    public CarritoService(CarritoRepository carritoRepository,
                          ItemCarritoRepository itemCarritoRepository,
                          IProductoRepository productoRepository) {
        this.carritoRepository = carritoRepository;
        this.itemCarritoRepository = itemCarritoRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public Optional<Carrito> obtenerOCrearCarrito(Long idUsuario) {
        Optional<Carrito> carritoExistente = carritoRepository.findByUsuario_IdUsuario(idUsuario);
        if (carritoExistente.isPresent()) {
            return carritoExistente;
        }

        Carrito nuevoCarrito = new Carrito();
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario); // solo necesitas el ID
        nuevoCarrito.setUsuario(usuario);

        return Optional.of(carritoRepository.save(nuevoCarrito));
    }

    @Override
    public void agregarItem(Long idUsuario, Integer idProducto, int cantidad) {
        Carrito carrito = obtenerOCrearCarrito(idUsuario)
                .orElseThrow(() -> new RuntimeException("No se pudo obtener o crear el carrito"));

        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // ✅ FIX aquí
        Optional<ItemCarrito> itemExistente = itemCarritoRepository
                .findByCarrito_IdAndProducto_IdProducto(carrito.getId(), producto.getIdProducto());

        if (itemExistente.isPresent()) {
            ItemCarrito item = itemExistente.get();
            item.setCantidad(item.getCantidad() + cantidad);
            itemCarritoRepository.save(item);
        } else {
            ItemCarrito nuevoItem = new ItemCarrito();
            nuevoItem.setCarrito(carrito);
            nuevoItem.setProducto(producto);
            nuevoItem.setCantidad(cantidad);
            itemCarritoRepository.save(nuevoItem);
        }
    }
}
