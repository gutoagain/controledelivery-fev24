package dev.wakandaacademy.controledelivery.pedido.application.repository;

import dev.wakandaacademy.controledelivery.pedido.domain.Pedido;

import java.util.UUID;

public interface PedidoRepository {
    Pedido salva(Pedido pedido);
    int contarPedidosDoCliente(UUID idCliente);
}
