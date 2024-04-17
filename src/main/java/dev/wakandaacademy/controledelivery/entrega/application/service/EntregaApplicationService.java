package dev.wakandaacademy.controledelivery.entrega.application.service;

import dev.wakandaacademy.controledelivery.entrega.application.api.EntregaIdResponse;
import dev.wakandaacademy.controledelivery.entrega.application.api.EntregaRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class EntregaApplicationService implements EntregaService {
    @Override
    public EntregaIdResponse criaNovaEntrega(String usuario, EntregaRequest entregaRequest) {
        log.info("[inicia] EntregaApplicationService - criaNovaEntrega");
        log.info("[finaliza] EntregaApplicationService - criaNovaEntrega");
        return null;
    }
}
