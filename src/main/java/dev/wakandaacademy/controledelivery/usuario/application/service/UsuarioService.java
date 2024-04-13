package dev.wakandaacademy.controledelivery.usuario.application.service;

import dev.wakandaacademy.controledelivery.usuario.application.api.UsuarioCriadoResponse;
import dev.wakandaacademy.controledelivery.usuario.application.api.UsuarioNovoRequest;

import java.util.UUID;

public interface UsuarioService {
    UsuarioCriadoResponse criaNovoUsuario(UsuarioNovoRequest usuarioNovo);
    UsuarioCriadoResponse buscaUsuarioPorId(UUID idUsuario);
}
