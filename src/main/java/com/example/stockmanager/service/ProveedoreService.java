package com.example.stockmanager.service;

import com.example.stockmanager.entity.Proveedore;
import com.example.stockmanager.repository.ProveedoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedoreService {
    
    private final ProveedoreRepository proveedoreRepository;
    
    @Autowired
    public ProveedoreService(ProveedoreRepository proveedoreRepository) {
        this.proveedoreRepository = proveedoreRepository;
    }
    
    public List<Proveedore> findAll() {
        return proveedoreRepository.findAll();
    }
    
    public Optional<Proveedore> findById(Integer id) {
        return proveedoreRepository.findById(id);
    }
    
    public Proveedore save(Proveedore proveedore) {
        return proveedoreRepository.save(proveedore);
    }
    
    public void deleteById(Integer id) {
        proveedoreRepository.deleteById(id);
    }
}
