package com.pj.apipedidos.repository;


import com.pj.apipedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Optional<Pedido> findById(Long id);

    List<Pedido> findByIdUsuario(Long idUsuario);

}

