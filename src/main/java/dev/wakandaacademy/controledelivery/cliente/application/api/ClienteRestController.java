package dev.wakandaacademy.controledelivery.cliente.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ClienteRestController implements ClienteAPI {
    @Override
    public ClienteIdResponse postNovoCliente(String token, ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteRestController - postNovaTarefa");
        log.info("[finaliza] ClienteRestController - postNovaTarefa");
        return null;
    }
}
