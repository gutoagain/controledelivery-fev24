package dev.wakandaacademy.controledelivery.entrega.application.repository;

import dev.wakandaacademy.controledelivery.entrega.domain.Entrega;

import java.util.Optional;
import java.util.UUID;

public interface EntregaRepository {
    Entrega salva(Entrega entrega);
    boolean verificaSePedidoPossuiEntrega(UUID idPedido);
    void alteraPedidoParaConfirmado(UUID idPedido);
    Optional<Entrega> buscaEntregaPorId(UUID idEntrega);
    void deletaEntregaPorId(Entrega entregaDeletada);
    void deletaEntregaPorIdPedido(UUID idPedido);
}
