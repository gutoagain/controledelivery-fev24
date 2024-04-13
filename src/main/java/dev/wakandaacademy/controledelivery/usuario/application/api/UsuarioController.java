package dev.wakandaacademy.controledelivery.usuario.application.api;

import dev.wakandaacademy.controledelivery.usuario.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@Log4j2
@RequiredArgsConstructor
public class UsuarioController implements UsuarioAPI {
    private final UsuarioService usuarioAppplicationService;

    @Override
    public UsuarioCriadoResponse postNovoUsuario(UsuarioNovoRequest usuarioNovo) {
        log.info("[inicia] UsuarioController - postNovoUsuario");
        UsuarioCriadoResponse usuarioCriado = usuarioAppplicationService.criaNovoUsuario(usuarioNovo);
        log.info("[finaliza] UsuarioController - postNovoUsuario");
        return usuarioCriado;
    }
}
