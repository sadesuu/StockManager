package com.example.stockmanager.controller;

import com.example.stockmanager.entity.DetallesPedido;
import com.example.stockmanager.service.DetallesPedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalles-pedido")
@CrossOrigin(origins = "*")
public class DetallesPedidoController {

    private final DetallesPedidoService detallesPedidoService;

    @Autowired
    public DetallesPedidoController(DetallesPedidoService detallesPedidoService) {
        this.detallesPedidoService = detallesPedidoService;
    }

    @GetMapping
    public ResponseEntity<List<DetallesPedido>> getAllDetallesPedido() {
        List<DetallesPedido> detallesPedidos = detallesPedidoService.findAll();
        return new ResponseEntity<>(detallesPedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallesPedido> getDetallesPedidoById(@PathVariable Integer id) {
        Optional<DetallesPedido> detallesPedido = detallesPedidoService.findById(id);
        return detallesPedido.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DetallesPedido> createDetallesPedido(@RequestBody DetallesPedido detallesPedido) {
        DetallesPedido savedDetallesPedido = detallesPedidoService.save(detallesPedido);
        return new ResponseEntity<>(savedDetallesPedido, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallesPedido> updateDetallesPedido(@PathVariable Integer id, @RequestBody DetallesPedido detallesPedido) {
        Optional<DetallesPedido> existingDetallesPedido = detallesPedidoService.findById(id);
        if (existingDetallesPedido.isPresent()) {
            detallesPedido.setId(id);
            DetallesPedido updatedDetallesPedido = detallesPedidoService.save(detallesPedido);
            return new ResponseEntity<>(updatedDetallesPedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetallesPedido(@PathVariable Integer id) {
        Optional<DetallesPedido> existingDetallesPedido = detallesPedidoService.findById(id);
        if (existingDetallesPedido.isPresent()) {
            detallesPedidoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
