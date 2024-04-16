package dev.wakandaacademy.controledelivery.pedido.application.api;

import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteRestController;
import dev.wakandaacademy.controledelivery.config.security.service.TokenService;
import dev.wakandaacademy.controledelivery.pedido.application.service.PedidoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class PedidoRestController implements PedidoAPI {
    private final ClienteRestController clienteRestController;
    private final PedidoService pedidoService;

    @Override
    public PedidoIdResponse postNovoPedido(String token, PedidoRequest pedidoRequest) {
        log.info("[inicia] PedidoRestController - postNovoPedido");
        String usuario = clienteRestController.getUsuarioByToken(token);
        PedidoIdResponse pedidoCriado = pedidoService.criaNovoPedido(usuario, pedidoRequest);
        log.info("[finaliza] PedidoRestController - postNovoPedido");
        return pedidoCriado;
    }
}
