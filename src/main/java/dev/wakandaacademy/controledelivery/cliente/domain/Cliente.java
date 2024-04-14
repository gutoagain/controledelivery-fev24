package dev.wakandaacademy.controledelivery.cliente.domain;

import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteRequest;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Log4j2
@Document(collection = "Cliente")
public class Cliente {
    @Id
    private UUID idCliente;
    @NotBlank
    private String nomeCliente;
    @Email
    @Indexed(unique = true)
    private String email;
    @Indexed
    private UUID idUsuario;

    public Cliente(ClienteRequest clienteRequest) {
        this.idCliente = UUID.randomUUID();
        this.nomeCliente = clienteRequest.getNomeCliente();
        this.email = clienteRequest.getEmail();
        this.idUsuario = clienteRequest.getIdUsuario();
    }
}
