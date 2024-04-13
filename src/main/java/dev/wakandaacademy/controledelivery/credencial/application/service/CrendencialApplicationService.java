package dev.wakandaacademy.controledelivery.credencial.application.service;

import dev.wakandaacademy.controledelivery.usuario.application.api.UsuarioNovoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrendencialApplicationService implements CredencialService {
    @Override
    public void criaNovaCredencial(UsuarioNovoRequest usuarioNovo) {
        log.info("[inicia] CrendencialService - criaNovaCredencial");
        log.info("[finaliza] CrendencialService - criaNovaCredencial");
    }
}
