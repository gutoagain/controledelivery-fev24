package dev.wakandaacademy.controledelivery.cliente.application.service;

import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteIdResponse;
import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteRequest;
import dev.wakandaacademy.controledelivery.cliente.application.repository.ClienteRepository;
import dev.wakandaacademy.controledelivery.cliente.domain.Cliente;
import dev.wakandaacademy.controledelivery.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteIdResponse criaNovoCliente(String usuario, ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteApplicationService - criaNovoCliente");
        var cliente = new Cliente(clienteRequest);
        clienteRepository.salva(cliente);
        log.info("[finaliza] ClienteApplicationService - criaNovoCliente");
        return ClienteIdResponse.builder().idCliente(cliente.getIdCliente()).build();
    }
}
