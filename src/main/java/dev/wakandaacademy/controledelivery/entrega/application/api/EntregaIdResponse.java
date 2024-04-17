package dev.wakandaacademy.controledelivery.entrega.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class EntregaIdResponse {
    private UUID idEntrega;
}
