package dev.wakandaacademy.controledelivery.cliente.application.repository;

import dev.wakandaacademy.controledelivery.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {
    @Override
    public Cliente salva(Cliente cliente) {
        log.info("[inicia] ClienteInfraRepository - salva");
        log.info("[finaliza] ClienteInfraRepository - salva");
        return null;
    }
}
