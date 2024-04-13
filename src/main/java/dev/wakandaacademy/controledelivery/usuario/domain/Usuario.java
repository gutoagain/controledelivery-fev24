package dev.wakandaacademy.controledelivery.usuario.domain;

import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
@Document(collection = "Usuario")
@Log4j2
public class Usuario {
    @Id
    private UUID idUsuario;
    @Email
    @Indexed(unique = true)
    private String email;
}
