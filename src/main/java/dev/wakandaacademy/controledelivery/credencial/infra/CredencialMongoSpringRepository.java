package dev.wakandaacademy.controledelivery.credencial.infra;

import dev.wakandaacademy.controledelivery.credencial.domain.Credencial;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CredencialMongoSpringRepository extends MongoRepository<Credencial, String> {
    Optional<Credencial> findByUsuario(String usuario);
}
