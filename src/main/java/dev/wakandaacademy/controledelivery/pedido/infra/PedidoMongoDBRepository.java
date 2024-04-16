package dev.wakandaacademy.controledelivery.pedido.infra;

import dev.wakandaacademy.controledelivery.pedido.domain.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface PedidoMongoDBRepository extends MongoRepository<Pedido, UUID> {
    int countByIdCliente(UUID idCliente);
    List<Pedido> findAllByIdClienteOrderByPosicaoAsc(UUID idCliente);
}
