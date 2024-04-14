package dev.wakandaacademy.controledelivery.cliente.application.service;

import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteIdResponse;
import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
    @Override
    public ClienteIdResponse criaNovoCliente(String usuario, ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteApplicationService - criaNovoCliente");
        log.info("[finaliza] ClienteApplicationService - criaNovoCliente");
        return null;
    }
}
