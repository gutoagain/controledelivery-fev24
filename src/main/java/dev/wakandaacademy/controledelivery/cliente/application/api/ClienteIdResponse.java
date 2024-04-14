package dev.wakandaacademy.controledelivery.cliente.application.api;

import dev.wakandaacademy.controledelivery.cliente.domain.Cliente;
import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ClienteIdResponse {
    private UUID idCliente;
}
