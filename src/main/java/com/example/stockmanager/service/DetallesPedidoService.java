package com.example.stockmanager.service;

import com.example.stockmanager.entity.DetallesPedido;
import com.example.stockmanager.repository.DetallesPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallesPedidoService {
    
    private final DetallesPedidoRepository detallesPedidoRepository;
    
    @Autowired
    public DetallesPedidoService(DetallesPedidoRepository detallesPedidoRepository) {
        this.detallesPedidoRepository = detallesPedidoRepository;
    }
    
    public List<DetallesPedido> findAll() {
        return detallesPedidoRepository.findAll();
    }
    
    public Optional<DetallesPedido> findById(Integer id) {
        return detallesPedidoRepository.findById(id);
    }
    
    public DetallesPedido save(DetallesPedido detallesPedido) {
        return detallesPedidoRepository.save(detallesPedido);
    }
    
    public void deleteById(Integer id) {
        detallesPedidoRepository.deleteById(id);
    }
}
