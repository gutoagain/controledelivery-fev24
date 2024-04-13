package dev.wakandaacademy.controledelivery.usuario.application.api;

import dev.wakandaacademy.controledelivery.usuario.domain.Usuario;
import lombok.Value;

import java.util.UUID;

@Value
public class UsuarioCriadoResponse {
    private final UUID idUsuario;
    private final String email;

    public UsuarioCriadoResponse(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.email = usuario.getEmail();
    }
}
