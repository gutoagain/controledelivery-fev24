package dev.wakandaacademy.controledelivery.cliente.application.api;

import lombok.NonNull;
import lombok.Value;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Value
public class ClienteRequest {
    @NotBlank
    @Size(message = "Campo nome cliente não pode estar vazio", max = 50, min = 3)
    private String nomeCliente;
    @Email
    private String email;
    @NonNull
    private UUID idUsuario;
}
