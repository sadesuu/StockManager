package com.example.stockmanager.controller;

import com.example.stockmanager.entity.Proveedore;
import com.example.stockmanager.service.ProveedoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/proveedores")
@CrossOrigin(origins = "*")
public class ProveedoreController {

    private final ProveedoreService proveedoreService;

    @Autowired
    public ProveedoreController(ProveedoreService proveedoreService) {
        this.proveedoreService = proveedoreService;
    }

    @GetMapping
    public ResponseEntity<List<Proveedore>> getAllProveedores() {
        List<Proveedore> proveedores = proveedoreService.findAll();
        return new ResponseEntity<>(proveedores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedore> getProveedoreById(@PathVariable Integer id) {
        Optional<Proveedore> proveedore = proveedoreService.findById(id);
        return proveedore.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Proveedore> createProveedore(@RequestBody Proveedore proveedore) {
        Proveedore savedProveedore = proveedoreService.save(proveedore);
        return new ResponseEntity<>(savedProveedore, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedore> updateProveedore(@PathVariable Integer id, @RequestBody Proveedore proveedore) {
        Optional<Proveedore> existingProveedore = proveedoreService.findById(id);
        if (existingProveedore.isPresent()) {
            proveedore.setId(id);
            Proveedore updatedProveedore = proveedoreService.save(proveedore);
            return new ResponseEntity<>(updatedProveedore, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedore(@PathVariable Integer id) {
        Optional<Proveedore> existingProveedore = proveedoreService.findById(id);
        if (existingProveedore.isPresent()) {
            proveedoreService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
