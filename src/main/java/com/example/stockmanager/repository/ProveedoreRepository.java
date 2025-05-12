package com.example.stockmanager.repository;

import com.example.stockmanager.entity.Proveedore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedoreRepository extends JpaRepository<Proveedore, Integer> {
    // Métodos personalizados de consulta se pueden agregar aquí si son necesarios
}
