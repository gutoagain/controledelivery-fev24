package dev.wakandaacademy.controledelivery.cliente.infra;

import dev.wakandaacademy.controledelivery.cliente.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ClienteMongoDBRepository extends MongoRepository<Cliente, UUID> {
}
