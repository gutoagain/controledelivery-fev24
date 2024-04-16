package dev.wakandaacademy.controledelivery.pedido.infra;

import dev.wakandaacademy.controledelivery.pedido.application.repository.PedidoRepository;
import dev.wakandaacademy.controledelivery.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PedidoInfraRepository implements PedidoRepository {
    @Override
    public Pedido salva(Pedido pedido) {
        log.info("[inicia] PedidoInfraRepository - salva");
        log.info("[finaliza] PedidoInfraRepository - salva");
        return null;
    }

    @Override
    public int contarPedidosDoCliente(UUID idCliente) {
        log.info("[inicia] PedidoInfraRepository - contarPedidosDoCliente");
        log.info("[finaliza] PedidoInfraRepository - contarPedidosDoCliente");
        return 0;
    }
}
