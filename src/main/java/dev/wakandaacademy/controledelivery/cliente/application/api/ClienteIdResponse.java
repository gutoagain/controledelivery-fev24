package dev.wakandaacademy.controledelivery.cliente.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ClienteIdResponse {
    private UUID idCliente;
}
