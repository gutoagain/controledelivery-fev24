package dev.wakandaacademy.controledelivery.entrega.application.service;

import dev.wakandaacademy.controledelivery.cliente.application.repository.ClienteRepository;
import dev.wakandaacademy.controledelivery.entrega.application.api.EditaEntregaRequest;
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

import java.util.UUID;

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
            throw APIException.build(HttpStatus.UNAUTHORIZED, "Pedido já possui uma entrega");
        }
        entregaRepository.alteraPedidoParaConfirmado(entregaRequest.getIdPedido());
        Entrega entregaCriada = entregaRepository.salva(new Entrega(entregaRequest));
        log.info("[finaliza] EntregaApplicationService - criaNovaEntrega");
        return EntregaIdResponse.builder().idEntrega(entregaCriada.getIdEntrega()).build();
    }

    @Override
    public Entrega consultaEntrega(String emailUsuario, UUID idEntrega) {
        log.info("[inicia] EntregaApplicationService - consultaEntrega");
        Entrega entrega = entregaRepository.buscaEntregaPorId(idEntrega)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Entrega não encontrada!"));
        log.info("[finaliza] EntregaApplicationService - consultaEntrega");
        return entrega;
    }

    @Override
    public void alteraDadosEntrega(String usuario, UUID idEntrega, EditaEntregaRequest entregaRequest) {
        log.info("[inicia] EntregaApplicationService - alteraDadosEntrega");
        Entrega entrega = consultaEntrega(usuario, idEntrega);
        entrega.altera(entregaRequest);
        entregaRepository.salva(entrega);
        log.info("[finaliza] EntregaApplicationService - alteraDadosEntrega");
    }
}
