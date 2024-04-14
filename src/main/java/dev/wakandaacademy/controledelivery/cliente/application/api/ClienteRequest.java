package dev.wakandaacademy.controledelivery.cliente.application.api;

import lombok.NonNull;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Value
public class ClienteRequest {
    @NotBlank
    @Size(message = "Campo nome cliente não pode estar vazio", max = 255, min = 3)
    private String nomeCliente;
    @NonNull
    private UUID idUsuario;
}
