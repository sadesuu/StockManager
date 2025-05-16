package com.example.stockmanager.repository;

import com.example.stockmanager.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    // Métodos personalizados si son necesarios
}
