package dev.wakandaacademy.controledelivery.pedido.application.service;

import dev.wakandaacademy.controledelivery.pedido.application.api.EditaPedidoRequest;
import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoDetalhadoResponse;
import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoIdResponse;
import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoRequest;
import dev.wakandaacademy.controledelivery.pedido.domain.Pedido;

import java.util.List;
import java.util.UUID;

public interface PedidoService {
    PedidoIdResponse criaNovoPedido(String usuario, PedidoRequest pedidoRequest);
    Pedido consultaPedido(String emailUsuario, UUID idPedido);
    List<PedidoDetalhadoResponse> listaPedidosCliente(String usuario, UUID idCliente);
    void alteraPedido(String usuario, UUID idPedido, EditaPedidoRequest pedidoRequest);
}
