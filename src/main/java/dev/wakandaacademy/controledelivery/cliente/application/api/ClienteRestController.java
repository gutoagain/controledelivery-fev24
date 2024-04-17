package dev.wakandaacademy.controledelivery.cliente.application.api;

import dev.wakandaacademy.controledelivery.cliente.application.service.ClienteService;
import dev.wakandaacademy.controledelivery.cliente.domain.Cliente;
import dev.wakandaacademy.controledelivery.config.security.service.TokenService;
import dev.wakandaacademy.controledelivery.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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

    @Override
    public ClienteDetalhadoResponse consultaCliente(String token, UUID idCliente) {
        log.info("[inicia] ClienteRestController - consultaCliente");
        String emailUsuario = getUsuarioByToken(token);
        Cliente cliente = clienteService.consultaCliente(emailUsuario, idCliente);
        log.info("[finaliza] ClienteRestController - consultaCliente");
        return new ClienteDetalhadoResponse(cliente);
    }

    @Override
    public void alteraCliente(String token, UUID idCliente, EditaClienteRequest clienteRequest) {
        log.info("[inicia] ClienteRestController - alteraCliente");
        String emailUsuario = getUsuarioByToken(token);
        clienteService.alteraCliente(emailUsuario, idCliente, clienteRequest);
        log.info("[finaliza] ClienteRestController - alteraCliente");
    }

    @Override
    public void deletaCliente(String token, UUID idCliente) {
        log.info("[inicia] ClienteRestController - deletaCliente");
        String usuario = getUsuarioByToken(token);
        clienteService.deletaCliente(usuario, idCliente);
        log.info("[finaliza] ClienteRestController - deletaCliente");
    }

    public String getUsuarioByToken(String token) {
        log.debug("[token] {}", token);
        String usuario = tokenService.getUsuarioByBearerToken(token)
                .orElseThrow(() -> APIException.build(HttpStatus.UNAUTHORIZED, token));
        log.info("[usuario] {}", usuario);
        return usuario;
    }
}
