package com.example.stockmanager.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "proveedores")
public class Proveedore {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proveedores_id_gen")
    @SequenceGenerator(name = "proveedores_id_gen", sequenceName = "proveedores_id_proveedor_seq", allocationSize = 1)
    @Column(name = "id_proveedor", nullable = false)
    private Integer id;

    @Column(name = "nombre_proveedor", nullable = false)
    private String nombreProveedor;

}