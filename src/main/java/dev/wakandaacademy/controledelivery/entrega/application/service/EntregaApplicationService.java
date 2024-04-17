package dev.wakandaacademy.controledelivery.entrega.application.service;

import dev.wakandaacademy.controledelivery.cliente.application.repository.ClienteRepository;
import dev.wakandaacademy.controledelivery.entrega.application.api.EntregaIdResponse;
import dev.wakandaacademy.controledelivery.entrega.application.api.EntregaRequest;
import dev.wakandaacademy.controledelivery.entrega.application.repository.EntregaRepository;
import dev.wakandaacademy.controledelivery.entrega.domain.Entrega;
import dev.wakandaacademy.controledelivery.handler.APIException;
import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoIdResponse;
import dev.wakandaacademy.controledelivery.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class EntregaApplicationService implements EntregaService {

    private final EntregaRepository entregaRepository;

    @Override
    public EntregaIdResponse criaNovaEntrega(String usuario, EntregaRequest entregaRequest) {
        log.info("[inicia] EntregaApplicationService - criaNovaEntrega");
        boolean pedidoPossuiEntrega = entregaRepository
                .verificaSePedidoPossuiEntrega(entregaRequest.getIdPedido());
        if (pedidoPossuiEntrega) {
            throw APIException.build(HttpStatus.UNAUTHORIZED, "Pedido já popssui uma entrega");
        }
        entregaRepository.alteraPedidoParaConfirmado(entregaRequest.getIdPedido());
        Entrega entregaCriada = entregaRepository.salva(new Entrega(entregaRequest));
        log.info("[finaliza] EntregaApplicationService - criaNovaEntrega");
        return EntregaIdResponse.builder().idEntrega(entregaCriada.getIdEntrega()).build();
    }
}
