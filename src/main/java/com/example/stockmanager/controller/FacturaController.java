package com.example.stockmanager.controller;

import com.example.stockmanager.entity.Factura;
import com.example.stockmanager.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturas")
@CrossOrigin(origins = "*")
public class FacturaController {

    private final FacturaService facturaService;

    @Autowired
    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public ResponseEntity<List<Factura>> getAllFacturas() {
        List<Factura> facturas = facturaService.findAll();
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> getFacturaById(@PathVariable Integer id) {
        Optional<Factura> factura = facturaService.findById(id);
        return factura.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<Factura>> getFacturasByFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        List<Factura> facturas = facturaService.findByFechaEmisionBetween(fechaInicio, fechaFin);
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Factura> createFactura(@RequestBody Factura factura) {
        if (factura.getFechaEmision() == null) {
            factura.setFechaEmision(LocalDate.now());
        }
        Factura savedFactura = facturaService.save(factura);
        return new ResponseEntity<>(savedFactura, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> updateFactura(@PathVariable Integer id, @RequestBody Factura factura) {
        Optional<Factura> existingFactura = facturaService.findById(id);
        if (existingFactura.isPresent()) {
            factura.setId(id);
            Factura updatedFactura = facturaService.save(factura);
            return new ResponseEntity<>(updatedFactura, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFactura(@PathVariable Integer id) {
        Optional<Factura> existingFactura = facturaService.findById(id);
        if (existingFactura.isPresent()) {
            facturaService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
