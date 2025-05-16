package com.example.stockmanager.service;

import com.example.stockmanager.entity.Pedido;
import com.example.stockmanager.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    
    private final PedidoRepository pedidoRepository;
    
    @Autowired
    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }
    
    public List<Pedido> findAll() {
        return pedidoRepository.findAll();
    }
    
    public Optional<Pedido> findById(Integer id) {
        return pedidoRepository.findById(id);
    }
    
    public Pedido save(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
    
    public void deleteById(Integer id) {
        pedidoRepository.deleteById(id);
    }
    
    public List<Pedido> findByFechaPedidoBetween(LocalDate fechaInicio, LocalDate fechaFin) {
        return pedidoRepository.findByFechaPedidoBetween(fechaInicio, fechaFin);
    }
    
    public List<Pedido> findByIdClienteId(Integer clienteId) {
        return pedidoRepository.findByIdClienteId(clienteId);
    }
}
