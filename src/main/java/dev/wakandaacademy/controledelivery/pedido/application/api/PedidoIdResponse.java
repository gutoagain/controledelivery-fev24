package dev.wakandaacademy.controledelivery.pedido.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class PedidoIdResponse {
    private UUID idPedido;
}
