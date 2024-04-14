package dev.wakandaacademy.controledelivery.cliente.infra;

import dev.wakandaacademy.controledelivery.cliente.application.repository.ClienteRepository;
import dev.wakandaacademy.controledelivery.cliente.domain.Cliente;
import dev.wakandaacademy.controledelivery.cliente.infra.ClienteMongoDBRepository;
import dev.wakandaacademy.controledelivery.handler.APIException;
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
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteMongoDBRepository clienteMongoDBRepository;

    @Override
    public Cliente salva(Cliente cliente) {
        log.info("[inicia] ClienteInfraRepository - salva");
        try {
            clienteMongoDBRepository.save(cliente);
        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Cliente já cadastrado", e);
        }
        log.info("[finaliza] ClienteInfraRepository - salva");
        return cliente;
    }

    @Override
    public Optional<Cliente> buscaClientePorId(UUID idCliente) {
        log.info("[inicia] ClienteInfraRepository - buscaClientePorId");
        Optional<Cliente> clientePorId = clienteMongoDBRepository.findById(idCliente);
        log.info("[finaliza] ClienteInfraRepository - buscaClientePorId");
        return clientePorId;
    }
}
