package com.example.stockmanager.controller;

import com.example.stockmanager.entity.Proveedore;
import com.example.stockmanager.service.ProveedoreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedoreController {
    private final ProveedoreService proveedoreService;

    public ProveedoreController(ProveedoreService proveedoreService) {
        this.proveedoreService = proveedoreService;
    }

    @GetMapping
    public List<Proveedore> getAll() {
        return proveedoreService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedore> getById(@PathVariable Integer id) {
        return proveedoreService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Proveedore create(@RequestBody Proveedore proveedore) {
        return proveedoreService.save(proveedore);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedore> update(@PathVariable Integer id, @RequestBody Proveedore proveedore) {
        return proveedoreService.findById(id)
                .map(existing -> {
                    proveedore.setId(existing.getId());
                    return ResponseEntity.ok(proveedoreService.save(proveedore));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (proveedoreService.findById(id).isPresent()) {
            proveedoreService.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}