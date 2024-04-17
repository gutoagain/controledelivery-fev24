package dev.wakandaacademy.controledelivery.entrega.infra;

import dev.wakandaacademy.controledelivery.entrega.domain.Entrega;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface EntregaMongoDBRepository  extends MongoRepository<Entrega, UUID> {
    boolean existsByIdPedido(UUID idPedido);
}
