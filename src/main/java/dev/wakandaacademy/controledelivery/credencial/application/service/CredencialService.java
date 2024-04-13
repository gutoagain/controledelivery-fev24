package dev.wakandaacademy.controledelivery.credencial.application.service;

import dev.wakandaacademy.controledelivery.usuario.application.api.UsuarioNovoRequest;
import jakarta.validation.Valid;

public interface CredencialService {
    void criaNovaCredencial(@Valid UsuarioNovoRequest usuarioNovo);
}
