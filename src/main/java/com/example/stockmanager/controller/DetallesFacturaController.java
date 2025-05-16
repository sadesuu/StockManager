package com.example.stockmanager.controller;

import com.example.stockmanager.entity.DetallesFactura;
import com.example.stockmanager.service.DetallesFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/detalles-factura")
@CrossOrigin(origins = "*")
public class DetallesFacturaController {

    private final DetallesFacturaService detallesFacturaService;

    @Autowired
    public DetallesFacturaController(DetallesFacturaService detallesFacturaService) {
        this.detallesFacturaService = detallesFacturaService;
    }

    @GetMapping
    public ResponseEntity<List<DetallesFactura>> getAllDetallesFactura() {
        List<DetallesFactura> detallesFacturas = detallesFacturaService.findAll();
        return new ResponseEntity<>(detallesFacturas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallesFactura> getDetallesFacturaById(@PathVariable Integer id) {
        Optional<DetallesFactura> detallesFactura = detallesFacturaService.findById(id);
        return detallesFactura.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DetallesFactura> createDetallesFactura(@RequestBody DetallesFactura detallesFactura) {
        DetallesFactura savedDetallesFactura = detallesFacturaService.save(detallesFactura);
        return new ResponseEntity<>(savedDetallesFactura, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallesFactura> updateDetallesFactura(@PathVariable Integer id, @RequestBody DetallesFactura detallesFactura) {
        Optional<DetallesFactura> existingDetallesFactura = detallesFacturaService.findById(id);
        if (existingDetallesFactura.isPresent()) {
            detallesFactura.setId(id);
            DetallesFactura updatedDetallesFactura = detallesFacturaService.save(detallesFactura);
            return new ResponseEntity<>(updatedDetallesFactura, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetallesFactura(@PathVariable Integer id) {
        Optional<DetallesFactura> existingDetallesFactura = detallesFacturaService.findById(id);
        if (existingDetallesFactura.isPresent()) {
            detallesFacturaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
