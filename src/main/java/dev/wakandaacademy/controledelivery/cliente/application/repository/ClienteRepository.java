package dev.wakandaacademy.controledelivery.cliente.application.repository;

import dev.wakandaacademy.controledelivery.cliente.domain.Cliente;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {
    Cliente salva(Cliente cliente);
    Optional<Cliente> buscaClientePorId(UUID idCliente);
}
