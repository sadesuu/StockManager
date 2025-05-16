package com.example.stockmanager.repository;

import com.example.stockmanager.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByFechaPedidoBetween(LocalDate fechaInicio, LocalDate fechaFin);
    List<Pedido> findByIdClienteId(Integer clienteId);
}
