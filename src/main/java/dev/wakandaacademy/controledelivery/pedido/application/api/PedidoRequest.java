package dev.wakandaacademy.controledelivery.pedido.application.api;

import lombok.NonNull;
import lombok.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Value
public class PedidoRequest {
    @NotBlank
    @Size(message = "Campo nome do produto não pode estar vazio", max = 100, min = 3)
    private String nomeProduto;
    @NonNull
    private UUID idCliente;
}
