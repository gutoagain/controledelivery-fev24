package dev.wakandaacademy.controledelivery.cliente.application.service;

import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteIdResponse;
import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteRequest;
import dev.wakandaacademy.controledelivery.cliente.application.api.EditaClienteRequest;
import dev.wakandaacademy.controledelivery.cliente.domain.Cliente;

import java.util.UUID;

public interface ClienteService {
    ClienteIdResponse criaNovoCliente(String usuario, ClienteRequest clienteRequest);
    Cliente consultaCliente(String emailUsuario, UUID idCliente);
    void alteraCliente(String emailUsuario, UUID idCliente, EditaClienteRequest clienteRequest);
    void deletaCliente(String usuario, UUID idCliente);
}
