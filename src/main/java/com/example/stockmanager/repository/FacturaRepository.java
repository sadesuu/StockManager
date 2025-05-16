package com.example.stockmanager.repository;

import com.example.stockmanager.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    List<Factura> findByFechaEmisionBetween(LocalDate fechaInicio, LocalDate fechaFin);
}
