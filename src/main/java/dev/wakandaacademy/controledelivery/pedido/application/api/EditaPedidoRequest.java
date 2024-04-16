package dev.wakandaacademy.controledelivery.pedido.application.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class EditaPedidoRequest {
    @NotBlank
    @Size(message = "Campo nome do produto não pode estar vazio", max = 100, min = 3)
    private String nomeProduto;
}
