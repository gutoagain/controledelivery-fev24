package dev.wakandaacademy.controledelivery.pedido.application.service;

import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoIdResponse;
import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PedidoApplicationService implements PedidoService {
    @Override
    public PedidoIdResponse criaNovoPedido(String usuario, PedidoRequest pedidoRequest) {
        log.info("[inicia] PedidoApplicationService - criaNovoPedido");
        log.info("[finaliza] PedidoApplicationService - criaNovoPedido");
        return null;
    }
}
