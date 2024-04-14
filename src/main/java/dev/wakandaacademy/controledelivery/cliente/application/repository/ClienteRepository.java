package dev.wakandaacademy.controledelivery.cliente.application.repository;

import dev.wakandaacademy.controledelivery.cliente.domain.Cliente;

public interface ClienteRepository {
    Cliente salva(Cliente cliente);
}
