package dev.wakandaacademy.controledelivery.usuario.application.service;

import dev.wakandaacademy.controledelivery.usuario.application.api.UsuarioCriadoResponse;
import dev.wakandaacademy.controledelivery.usuario.application.api.UsuarioNovoRequest;
import dev.wakandaacademy.controledelivery.usuario.application.repository.UsuarioRepository;
import dev.wakandaacademy.controledelivery.usuario.domain.Usuario;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioCriadoResponse criaNovoUsuario(@Valid UsuarioNovoRequest usuarioNovo) {
        log.info("[inicia] UsuarioApplicationService - criaNovoUsuario");
        var usuario = new Usuario(usuarioNovo);
        usuarioRepository.salva(usuario);
        log.info("[finaliza] UsuarioApplicationService - criaNovoUsuario");
        return new UsuarioCriadoResponse(usuario);
    }

    @Override
    public UsuarioCriadoResponse buscaUsuarioPorId(UUID idUsuario) {
        log.info("[inicia] UsuarioApplicationService - buscaUsuarioPorId");
        log.info("[finaliza] UsuarioApplicationService - buscaUsuarioPorId");
        return null;
    }
}
