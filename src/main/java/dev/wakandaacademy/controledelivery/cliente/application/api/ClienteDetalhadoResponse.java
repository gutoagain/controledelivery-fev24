package dev.wakandaacademy.controledelivery.cliente.application.api;

import dev.wakandaacademy.controledelivery.cliente.domain.Cliente;
import lombok.Value;

import java.util.UUID;

@Value
public class ClienteDetalhadoResponse {
    private UUID idCliente;
    private String nomeCliente;
    private String email;
    private UUID idUsuario;

    public ClienteDetalhadoResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCliente = cliente.getNomeCliente();
        this.email = cliente.getEmail();
        this.idUsuario = cliente.getIdUsuario();
    }
}
