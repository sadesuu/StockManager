package com.example.stockmanager.repository;

import com.example.stockmanager.entity.DetallesPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallesPedidoRepository extends JpaRepository<DetallesPedido, Integer> {
}
