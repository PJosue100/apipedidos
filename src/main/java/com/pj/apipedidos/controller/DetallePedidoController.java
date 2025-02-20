package com.pj.apipedidos.controller;



import com.pj.apipedidos.model.DetallePedido;
import com.pj.apipedidos.services.DetallePedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle_pedidos")
public class DetallePedidoController {

    private final DetallePedidoService detallePedidoService;

    public DetallePedidoController(DetallePedidoService detallePedidoService) {
        this.detallePedidoService = detallePedidoService;
    }

    @GetMapping("/publico")
    public ResponseEntity<List<DetallePedido>> obtenerDetallesPedidos() {
        return ResponseEntity.ok(detallePedidoService.obtenerTodos());
    }

    @GetMapping("/detallePedido/{id}")
    public ResponseEntity<DetallePedido> obtenerDetallePedidoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(detallePedidoService.obtenerPorId(id));
    }


    @GetMapping("/pedido/{idPedido}")
    public ResponseEntity<List<DetallePedido>> obtenerDetallePedidoPorIdPedido(@PathVariable Long idPedido) {
        return ResponseEntity.ok(detallePedidoService.obtenerPorIdPedido(idPedido));
    }

    @PostMapping("/new")
    public ResponseEntity<DetallePedido> crearDetallePedido(@RequestBody DetallePedido detallePedido) {
        return ResponseEntity.ok(detallePedidoService.crearDetallePedido(detallePedido));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> modificarDetallePedido(@PathVariable Long id, @RequestBody DetallePedido detallePedido) {
        return ResponseEntity.ok(detallePedidoService.modificarDetallePedido(id, detallePedido));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Boolean> eliminarDetallePedido(@PathVariable Long id) {
        return ResponseEntity.ok(detallePedidoService.eliminarDetallePedido(id));
    }


}
