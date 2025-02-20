package com.pj.apipedidos.services;

import com.pj.apipedidos.model.Pedido;
import com.pj.apipedidos.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository ) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }

    public Pedido obtenerPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    public List<Pedido> obtenerPorIdUsuario(Long idUsuario) {
        return pedidoRepository.findByIdUsuario(idUsuario);
    }




    public Pedido crearPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public Pedido modificarPedido(Long id, Pedido pedido) {
        Pedido existente = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        existente.setEstado(pedido.getEstado());
        existente.setTotal(pedido.getTotal());
        existente.setFechaPedido(pedido.getFechaPedido());


        return pedidoRepository.save(existente);
    }

    public Pedido modificarEstadoPedido(Long id, Pedido pedido) {
        Pedido existente = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
        existente.setEstado(pedido.getEstado());


        return pedidoRepository.save(existente);
    }

}

