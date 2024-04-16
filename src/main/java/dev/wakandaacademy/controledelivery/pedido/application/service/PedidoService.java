package dev.wakandaacademy.controledelivery.pedido.application.service;

import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoIdResponse;
import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoRequest;

public interface PedidoService {
    PedidoIdResponse criaNovoPedido(String usuario, PedidoRequest pedidoRequest);
}
