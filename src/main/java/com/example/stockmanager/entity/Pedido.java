package com.example.stockmanager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedidos_id_gen")
    @SequenceGenerator(name = "pedidos_id_gen", sequenceName = "pedidos_id_pedido_seq", allocationSize = 1)
    @Column(name = "id_pedido", nullable = false)
    private Integer id;

    @Column(name = "numero_pedido", nullable = false, length = 20)
    private String numeroPedido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente idCliente;

    @Column(name = "fecha_pedido", nullable = false)
    private LocalDate fechaPedido;

    @Column(name = "estado_pedido", length = 20)
    private String estadoPedido;

}