package dev.wakandaacademy.controledelivery.pedido.infra;

import dev.wakandaacademy.controledelivery.cliente.domain.Cliente;
import dev.wakandaacademy.controledelivery.handler.APIException;
import dev.wakandaacademy.controledelivery.pedido.application.repository.PedidoRepository;
import dev.wakandaacademy.controledelivery.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PedidoInfraRepository implements PedidoRepository {
    private final PedidoMongoDBRepository pedidoMongoDBRepository;

    @Override
    public Pedido salva(Pedido pedido) {
        log.info("[inicia] PedidoInfraRepository - salva");
        try {
            pedidoMongoDBRepository.save(pedido);
        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Pedido já cadastrado", e);
        }
        log.info("[finaliza] PedidoInfraRepository - salva");
        return pedido;
    }

    @Override
    public int contarPedidosDoCliente(UUID idCliente) {
        log.info("[inicia] PedidoInfraRepository - contarPedidosDoCliente");
        int contarPedidos = pedidoMongoDBRepository.countByIdCliente(idCliente);
        log.info("[finaliza] PedidoInfraRepository - contarPedidosDoCliente");
        return contarPedidos;
    }

    @Override
    public Optional<Pedido> buscaPedidoPorId(UUID idPedido) {
        log.info("[inicia] PedidoInfraRepository - buscaPedidoPorId");
        Optional<Pedido> pedidoPorId = pedidoMongoDBRepository.findById(idPedido);
        log.info("[finaliza] PedidoInfraRepository - buscaPedidoPorId");
        return pedidoPorId;
    }
}
