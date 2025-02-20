package com.pj.apipedidos.services;



import com.pj.apipedidos.model.DetallePedido;
import com.pj.apipedidos.repository.DetallePedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DetallePedidoService {

    private final DetallePedidoRepository detallePedidoRepository;

    public DetallePedidoService(DetallePedidoRepository detallePedidoRepository ) {
        this.detallePedidoRepository = detallePedidoRepository;
    }

    public List<DetallePedido> obtenerTodos() {
        return detallePedidoRepository.findAll();
    }

    public DetallePedido obtenerPorId(Long id) {
        return detallePedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetallePedido no encontrado"));
    }

    public List<DetallePedido>  obtenerPorIdPedido(Long idPedido) {
        return detallePedidoRepository.findByIdPedido(idPedido);
    }

    public DetallePedido crearDetallePedido(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    public DetallePedido modificarDetallePedido(Long id, DetallePedido detallePedido) {
        DetallePedido existente = detallePedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("DetallePedido no encontrado"));
        existente.setIdProducto(detallePedido.getIdProducto());
        existente.setCantidad(detallePedido.getCantidad());
        existente.setPrecioUnitario(detallePedido.getPrecioUnitario());
        existente.setSubtotal(detallePedido.getSubtotal());

        return detallePedidoRepository.save(existente);
    }

    public boolean eliminarDetallePedido(Long id) {

        try {
            DetallePedido existente = detallePedidoRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("DetallePedido no encontrado"));

            detallePedidoRepository.delete(existente);
            return true;
        }catch (Exception e) {
            return false;
        }


    }
}

