package com.pj.apipedidos.controller;



import com.pj.apipedidos.model.Pedido;
import com.pj.apipedidos.services.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/publico")
    public ResponseEntity<List<Pedido>> obtenerPedidos() {
        return ResponseEntity.ok(pedidoService.obtenerTodos());
    }

    @GetMapping("pedido/{id}")
    public ResponseEntity<Pedido> obtenerPedidoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pedidoService.obtenerPorId(id));
    }

    @GetMapping("usuario/{idUsuario}")
    public ResponseEntity<List<Pedido>> obtenerPedidoPorIdUsuario(@PathVariable Long idUsuario) {
        return ResponseEntity.ok(pedidoService.obtenerPorIdUsuario(idUsuario));
    }

    @PostMapping("/new")
    public ResponseEntity<Pedido> crearPedido(@RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.crearPedido(pedido));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Pedido> modificarPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.modificarPedido(id, pedido));
    }


    @PutMapping("estado/{id}")
    public ResponseEntity<Pedido> modificarEstadoPedido(@PathVariable Long id, @RequestBody Pedido pedido) {
        return ResponseEntity.ok(pedidoService.modificarEstadoPedido(id, pedido));
    }
}
