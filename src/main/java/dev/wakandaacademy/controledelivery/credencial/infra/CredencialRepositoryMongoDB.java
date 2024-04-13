package dev.wakandaacademy.controledelivery.credencial.infra;

import dev.wakandaacademy.controledelivery.credencial.application.repository.CredencialRepository;
import dev.wakandaacademy.controledelivery.credencial.domain.Credencial;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CredencialRepositoryMongoDB implements CredencialRepository {
    @Override
    public Credencial salva(Credencial credencial) {
        log.info("[start] CredencialRepositoryMongoDB - salva");
        log.info("[finish] CredencialRepositoryMongoDB - salva");
        return credencial;
    }
}
