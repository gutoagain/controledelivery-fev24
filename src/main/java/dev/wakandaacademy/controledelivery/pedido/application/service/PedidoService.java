package dev.wakandaacademy.controledelivery.pedido.application.service;

import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoIdResponse;
import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoRequest;
import dev.wakandaacademy.controledelivery.pedido.domain.Pedido;

import java.util.UUID;

public interface PedidoService {
    PedidoIdResponse criaNovoPedido(String usuario, PedidoRequest pedidoRequest);
    Pedido consultaPedido(String emailUsuario, UUID idPedido);
}
