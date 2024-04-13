package dev.wakandaacademy.controledelivery.credencial.application.service;

import dev.wakandaacademy.controledelivery.credencial.domain.Credencial;
import dev.wakandaacademy.controledelivery.usuario.application.api.UsuarioNovoRequest;

import javax.validation.Valid;

public interface CredencialService {
    void criaNovaCredencial(@Valid UsuarioNovoRequest usuarioNovo);
    Credencial buscaCredencialPorUsuario(String usuario);
}
