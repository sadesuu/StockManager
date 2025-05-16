package com.example.stockmanager.service;

import com.example.stockmanager.entity.Categoria;
import com.example.stockmanager.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    
    private final CategoriaRepository categoriaRepository;
    
    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
    
    public Optional<Categoria> findById(Integer id) {
        return categoriaRepository.findById(id);
    }
    
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
    
    public void deleteById(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
