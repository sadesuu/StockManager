package com.example.stockmanager.service;

import com.example.stockmanager.entity.Producto;
import com.example.stockmanager.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    
    private final ProductoRepository productoRepository;
    
    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }
    
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }
    
    public Optional<Producto> findById(Integer id) {
        return productoRepository.findById(id);
    }
    
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }
    
    public void deleteById(Integer id) {
        productoRepository.deleteById(id);
    }
    
    public void actualizarStock(Integer idProducto, Integer cantidad) {
        Optional<Producto> producto = findById(idProducto);
        if (producto.isPresent()) {
            Producto prod = producto.get();
            prod.setStockActual(prod.getStockActual() + cantidad);
            save(prod);
        }
    }
}
