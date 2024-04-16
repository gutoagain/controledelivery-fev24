package dev.wakandaacademy.controledelivery.pedido.application.api;

import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteDetalhadoResponse;
import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteRestController;
import dev.wakandaacademy.controledelivery.cliente.domain.Cliente;
import dev.wakandaacademy.controledelivery.config.security.service.TokenService;
import dev.wakandaacademy.controledelivery.pedido.application.service.PedidoService;
import dev.wakandaacademy.controledelivery.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    @Override
    public PedidoDetalhadoResponse consultaPedido(String token, UUID idPedido) {
        log.info("[inicia] PedidoRestController - consultaPedido");
        String emailUsuario = clienteRestController.getUsuarioByToken(token);
        Pedido pedido = pedidoService.consultaPedido(emailUsuario, idPedido);
        log.info("[finaliza] PedidoRestController - consultaPedido");
        return new PedidoDetalhadoResponse(pedido);
    }

    @Override
    public List<PedidoDetalhadoResponse> listaPedidosCliente(String token, UUID idCliente) {
        log.info("[inicia] PedidoRestController - listaPedidosCliente");
        log.info("[finaliza] PedidoRestController - listaPedidosCliente");
        return null;
    }
}
