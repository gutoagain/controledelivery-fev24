package dev.wakandaacademy.controledelivery.entrega.application.api;

import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteRestController;
import dev.wakandaacademy.controledelivery.entrega.application.service.EntregaService;
import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoIdResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Log4j2
@RequiredArgsConstructor
public class EntregaRestController implements EntregaAPI {

    private final ClienteRestController clienteRestController;
    private final EntregaService entregaService;

    @Override
    public EntregaIdResponse postNovaEntrega(String token, EntregaRequest entregaRequest) {
        log.info("[inicia] EntregaRestController - postNovaEntrega");
        String usuario = clienteRestController.getUsuarioByToken(token);
        EntregaIdResponse entregaCriada = entregaService.criaNovaEntrega(usuario, entregaRequest);
        log.info("[finaliza] EntregaRestController - postNovaEntrega");
        return entregaCriada;
    }

    @Override
    public EntregaDetalhadoResponse consultaEntrega(String token, UUID idEntrega) {
        log.info("[inicia] EntregaRestController - consultaEntrega");
        log.info("[finaliza] EntregaRestController - consultaEntrega");
        return null;
    }
}
