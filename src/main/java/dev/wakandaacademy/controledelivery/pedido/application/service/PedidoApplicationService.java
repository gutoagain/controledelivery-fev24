package dev.wakandaacademy.controledelivery.pedido.application.service;

import dev.wakandaacademy.controledelivery.cliente.application.repository.ClienteRepository;
import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoIdResponse;
import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoRequest;
import dev.wakandaacademy.controledelivery.pedido.application.repository.PedidoRepository;
import dev.wakandaacademy.controledelivery.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class PedidoApplicationService implements PedidoService {
    private final PedidoRepository pedidoRepository;

    @Override
    public PedidoIdResponse criaNovoPedido(String usuario, PedidoRequest pedidoRequest) {
        log.info("[inicia] PedidoApplicationService - criaNovoPedido");
        int posicaoDoNovoPedido = pedidoRepository.contarPedidosDoCliente(pedidoRequest.getIdCliente());
        Pedido pedidoCriado = pedidoRepository.salva(new Pedido(pedidoRequest, posicaoDoNovoPedido));
        log.info("[finaliza] PedidoApplicationService - criaNovoPedido");
        return PedidoIdResponse.builder().idPedido(pedidoCriado.getIdPedido()).build();
    }
}
