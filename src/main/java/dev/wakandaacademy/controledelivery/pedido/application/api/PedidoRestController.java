package dev.wakandaacademy.controledelivery.pedido.application.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PedidoRestController implements PedidoAPI {
    @Override
    public PedidoIdResponse postNovoPedido(String token, PedidoRequest pedidoRequest) {
        log.info("[inicia] PedidoRestController - postNovoPedido");
        log.info("[finaliza] PedidoRestController - postNovoPedido");
        return null;
    }
}
