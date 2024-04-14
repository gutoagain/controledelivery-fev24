package dev.wakandaacademy.controledelivery.cliente.application.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class EditaClienteRequest {
    @NotBlank
    @Size(message = "Campo nome cliente não pode estar vazio", max = 50, min = 3)
    private String nomeCliente;
    @Email
    private String email;
}
