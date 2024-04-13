package dev.wakandaacademy.controledelivery.usuario.application.service;

import dev.wakandaacademy.controledelivery.usuario.application.api.UsuarioCriadoResponse;
import dev.wakandaacademy.controledelivery.usuario.application.api.UsuarioNovoRequest;

public interface UsuarioService {
    UsuarioCriadoResponse criaNovoUsuario(UsuarioNovoRequest usuarioNovo);
}
