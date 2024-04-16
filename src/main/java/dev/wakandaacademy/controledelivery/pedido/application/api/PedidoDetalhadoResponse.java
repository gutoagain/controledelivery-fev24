package dev.wakandaacademy.controledelivery.pedido.application.api;

import dev.wakandaacademy.controledelivery.pedido.domain.Pedido;
import dev.wakandaacademy.controledelivery.pedido.domain.StatusPedido;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class PedidoDetalhadoResponse {
    private UUID idPedido;
    private String nomeProduto;
    private UUID idCliente;
    private StatusPedido status;
    private int posicao;

    public PedidoDetalhadoResponse(Pedido pedido) {
        this.idPedido = pedido.getIdPedido();
        this.nomeProduto = pedido.getNomeProduto();
        this.idCliente = pedido.getIdCliente();
        this.status = pedido.getStatus();
        this.posicao = pedido.getPosicao();
    }

    public static List<PedidoDetalhadoResponse> converte(List<Pedido> listaPedido) {
        return  listaPedido.stream().map(PedidoDetalhadoResponse::new).collect(Collectors.toList());
    }
}
