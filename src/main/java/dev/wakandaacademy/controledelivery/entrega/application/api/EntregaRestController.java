package dev.wakandaacademy.controledelivery.entrega.application.api;

import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteRestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class EntregaRestController implements EntregaAPI {
    @Override
    public EntregaIdResponse postNovaEntrega(String token, EntregaRequest entregaRequest) {
        log.info("[inicia] EntregaRestController - postNovaEntrega");
        log.info("[finaliza] EntregaRestController - postNovaEntrega");
        return null;
    }
}
