package com.example.stockmanager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "detalles_pedido")
public class DetallesPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detalles_pedido_id_gen")
    @SequenceGenerator(name = "detalles_pedido_id_gen", sequenceName = "detalles_pedido_id_detalle_pedido_seq", allocationSize = 1)
    @Column(name = "id_detalle_pedido", nullable = false)
    private Integer id;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_unitario", nullable = false, precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "importe", nullable = false, precision = 10, scale = 2)
    private BigDecimal importe;

}