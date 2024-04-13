package dev.wakandaacademy.controledelivery.usuario.infra;

import dev.wakandaacademy.controledelivery.usuario.domain.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface UsuarioMongoSpringRepository extends MongoRepository<Usuario, UUID> {
}
