package dev.wakandaacademy.controledelivery.entrega.application.api;

import lombok.NonNull;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Value
public class EntregaRequest {
    @NotBlank
    @Size(message = "O endereço não pode estar vazio", max = 150, min = 3)
    private String endereco;
    @NonNull
    private UUID idPedido;
}
