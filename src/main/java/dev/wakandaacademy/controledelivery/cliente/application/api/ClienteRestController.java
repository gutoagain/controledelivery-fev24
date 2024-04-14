package dev.wakandaacademy.controledelivery.cliente.application.api;

import dev.wakandaacademy.controledelivery.cliente.application.service.ClienteService;
import dev.wakandaacademy.controledelivery.config.security.service.TokenService;
import dev.wakandaacademy.controledelivery.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteRestController implements ClienteAPI {
    private final TokenService tokenService;
    private final ClienteService clienteService;

    @Override
    public ClienteIdResponse postNovoCliente(String token, ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteRestController - postNovoCliente");
        String usuario = getUsuarioByToken(token);
        ClienteIdResponse clienteCriado = clienteService.criaNovoCliente(usuario, clienteRequest);
        log.info("[finaliza] ClienteRestController - postNovoCliente");
        return clienteCriado;
    }

    private String getUsuarioByToken(String token) {
        log.debug("[token] {}", token);
        String usuario = tokenService.getUsuarioByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, token));
        log.info("[usuario] {}", usuario);
        return usuario;
    }
}
