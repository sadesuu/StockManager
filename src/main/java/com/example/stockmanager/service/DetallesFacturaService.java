package com.example.stockmanager.service;

import com.example.stockmanager.entity.DetallesFactura;
import com.example.stockmanager.repository.DetallesFacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallesFacturaService {
    
    private final DetallesFacturaRepository detallesFacturaRepository;
    
    @Autowired
    public DetallesFacturaService(DetallesFacturaRepository detallesFacturaRepository) {
        this.detallesFacturaRepository = detallesFacturaRepository;
    }
    
    public List<DetallesFactura> findAll() {
        return detallesFacturaRepository.findAll();
    }
    
    public Optional<DetallesFactura> findById(Integer id) {
        return detallesFacturaRepository.findById(id);
    }
    
    public DetallesFactura save(DetallesFactura detallesFactura) {
        return detallesFacturaRepository.save(detallesFactura);
    }
    
    public void deleteById(Integer id) {
        detallesFacturaRepository.deleteById(id);
    }
}
