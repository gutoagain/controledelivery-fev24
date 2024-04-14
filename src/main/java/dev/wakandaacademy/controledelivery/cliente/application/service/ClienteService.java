package dev.wakandaacademy.controledelivery.cliente.application.service;

import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteIdResponse;
import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteRequest;

public interface ClienteService {
    ClienteIdResponse criaNovoCliente(String usuario, ClienteRequest clienteRequest);
}
