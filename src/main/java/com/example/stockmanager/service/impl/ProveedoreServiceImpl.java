package com.example.stockmanager.service.impl;

import com.example.stockmanager.entity.Proveedore;
import com.example.stockmanager.repository.ProveedoreRepository;
import com.example.stockmanager.service.ProveedoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedoreServiceImpl implements ProveedoreService {
    private final ProveedoreRepository proveedoreRepository;

    public ProveedoreServiceImpl(ProveedoreRepository proveedoreRepository) {
        this.proveedoreRepository = proveedoreRepository;
    }

    @Override
    public List<Proveedore> findAll() {
        return proveedoreRepository.findAll();
    }

    @Override
    public Optional<Proveedore> findById(Integer id) {
        return proveedoreRepository.findById(id);
    }

    @Override
    public Proveedore save(Proveedore proveedore) {
        return proveedoreRepository.save(proveedore);
    }

    @Override
    public void deleteById(Integer id) {
        proveedoreRepository.deleteById(id);
    }
}
