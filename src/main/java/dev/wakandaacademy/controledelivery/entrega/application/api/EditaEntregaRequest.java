package dev.wakandaacademy.controledelivery.entrega.application.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class EditaEntregaRequest {
    @NotBlank
    @Size(message = "O endereço não pode estar vazio", max = 150, min = 3)
    private String endereco;
}
