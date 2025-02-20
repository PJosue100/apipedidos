package com.pj.apipedidos.repository;


import com.pj.apipedidos.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {

    Optional<DetallePedido> findById(Long id);

    List<DetallePedido> findByIdPedido(Long idPedido);

}

