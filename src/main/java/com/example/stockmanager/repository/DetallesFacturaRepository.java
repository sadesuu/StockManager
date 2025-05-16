package com.example.stockmanager.repository;

import com.example.stockmanager.entity.DetallesFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallesFacturaRepository extends JpaRepository<DetallesFactura, Integer> {
}
