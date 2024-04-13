package dev.wakandaacademy.controledelivery.credencial.application.repository;

import dev.wakandaacademy.controledelivery.credencial.domain.Credencial;
import dev.wakandaacademy.controledelivery.credencial.infra.CredencialMongoSpringRepository;
import dev.wakandaacademy.controledelivery.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CredencialRepositoryMongoDB implements CredencialRepository {
    private final CredencialMongoSpringRepository credencialMongoRepository;
    @Override
    public Credencial salva(Credencial credencial) {
        log.info("[start] CredencialRepositoryMongoDB - salva");
        credencialMongoRepository.save(credencial);
        log.info("[finish] CredencialRepositoryMongoDB - salva");
        return credencial;
    }

    @Override
    public Credencial buscaCredencialPorUsuario(String usuario) {
        log.info("[start] CredencialRepositoryMongoDB - buscaCredencialPorUsuario");
        var credencial = credencialMongoRepository.findByUsuario(usuario)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Não existe credencial para o Usuario informado!"));
        log.info("[start] CredencialRepositoryMongoDB - buscaCredencialPorUsuario");
        return credencial;
    }
}
