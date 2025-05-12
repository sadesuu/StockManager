package com.example.stockmanager.service;

import com.example.stockmanager.entity.Proveedore;

import java.util.List;
import java.util.Optional;

public interface ProveedoreService {
    List<Proveedore> findAll();
    Optional<Proveedore> findById(Integer id);
    Proveedore save(Proveedore proveedore);
    void deleteById(Integer id);
}
