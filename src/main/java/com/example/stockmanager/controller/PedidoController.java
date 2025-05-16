package com.example.stockmanager.controller;

import com.example.stockmanager.entity.Pedido;
import com.example.stockmanager.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
public class PedidoController {

    private final PedidoService pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> pedidos = pedidoService.findAll();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Integer id) {
        Optional<Pedido> pedido = pedidoService.findById(id);
        return pedido.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Pedido>> getPedidosByClienteId(@PathVariable Integer clienteId) {
        List<Pedido> pedidos = pedidoService.findByIdClienteId(clienteId);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<Pedido>> getPedidosByFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
        List<Pedido> pedidos = pedidoService.findByFechaPedidoBetween(fechaInicio, fechaFin);
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        if (pedido.getFechaPedido() == null) {
            pedido.setFechaPedido(LocalDate.now());
        }
        Pedido savedPedido = pedidoService.save(pedido);
        return new ResponseEntity<>(savedPedido, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Integer id, @RequestBody Pedido pedido) {
        Optional<Pedido> existingPedido = pedidoService.findById(id);
        if (existingPedido.isPresent()) {
            pedido.setId(id);
            Pedido updatedPedido = pedidoService.save(pedido);
            return new ResponseEntity<>(updatedPedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Pedido> updateEstadoPedido(@PathVariable Integer id, @RequestParam String estado) {
        Optional<Pedido> pedidoOpt = pedidoService.findById(id);
        if (pedidoOpt.isPresent()) {
            Pedido pedido = pedidoOpt.get();
            pedido.setEstadoPedido(estado);
            pedidoService.save(pedido);
            return new ResponseEntity<>(pedido, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Integer id) {
        Optional<Pedido> existingPedido = pedidoService.findById(id);
        if (existingPedido.isPresent()) {
            pedidoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
