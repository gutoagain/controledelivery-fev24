package dev.wakandaacademy.controledelivery.credencial.application.service;

import dev.wakandaacademy.controledelivery.credencial.application.repository.CredencialRepository;
import dev.wakandaacademy.controledelivery.credencial.domain.Credencial;
import dev.wakandaacademy.controledelivery.usuario.application.api.UsuarioNovoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrendencialApplicationService implements CredencialService {
    private final CredencialRepository credencialRepository;

    @Override
    public void criaNovaCredencial(UsuarioNovoRequest usuarioNovo) {
        log.info("[inicia] CrendencialService - criaNovaCredencial");
        var novaCredencial = new Credencial(usuarioNovo.getEmail(), usuarioNovo.getSenha());
        credencialRepository.salva(novaCredencial);
        log.info("[finaliza] CrendencialService - criaNovaCredencial");
    }
}
