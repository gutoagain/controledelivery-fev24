package dev.wakandaacademy.controledelivery.pedido.application.repository;

import dev.wakandaacademy.controledelivery.pedido.domain.Pedido;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoRepository {
    Pedido salva(Pedido pedido);
    int contarPedidosDoCliente(UUID idCliente);
    Optional<Pedido> buscaPedidoPorId(UUID idPedido);
    List<Pedido> listaPedidosCliente(UUID idCliente);
}
