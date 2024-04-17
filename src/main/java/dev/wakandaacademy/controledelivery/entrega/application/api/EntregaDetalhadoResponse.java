package dev.wakandaacademy.controledelivery.entrega.application.api;

import dev.wakandaacademy.controledelivery.entrega.domain.StatusEntrega;
import lombok.Value;
import java.util.UUID;

@Value
public class EntregaDetalhadoResponse {
    private UUID idEntrega;
    private String endereco;
    private UUID idPedido;
    private StatusEntrega status;
}
