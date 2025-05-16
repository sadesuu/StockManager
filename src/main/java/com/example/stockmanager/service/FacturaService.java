package com.example.stockmanager.service;

import com.example.stockmanager.entity.Factura;
import com.example.stockmanager.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaService {
    
    private final FacturaRepository facturaRepository;
    
    @Autowired
    public FacturaService(FacturaRepository facturaRepository) {
        this.facturaRepository = facturaRepository;
    }
    
    public List<Factura> findAll() {
        return facturaRepository.findAll();
    }
    
    public Optional<Factura> findById(Integer id) {
        return facturaRepository.findById(id);
    }
    
    public Factura save(Factura factura) {
        return facturaRepository.save(factura);
    }
    
    public void deleteById(Integer id) {
        facturaRepository.deleteById(id);
    }
    
    public List<Factura> findByFechaEmisionBetween(LocalDate fechaInicio, LocalDate fechaFin) {
        return facturaRepository.findByFechaEmisionBetween(fechaInicio, fechaFin);
    }
}
