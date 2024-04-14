package dev.wakandaacademy.controledelivery.cliente.application.service;

import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteIdResponse;
import dev.wakandaacademy.controledelivery.cliente.application.api.ClienteRequest;
import dev.wakandaacademy.controledelivery.cliente.application.api.EditaClienteRequest;
import dev.wakandaacademy.controledelivery.cliente.application.repository.ClienteRepository;
import dev.wakandaacademy.controledelivery.cliente.domain.Cliente;
import dev.wakandaacademy.controledelivery.handler.APIException;
import dev.wakandaacademy.controledelivery.usuario.application.repository.UsuarioRepository;
import dev.wakandaacademy.controledelivery.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public ClienteIdResponse criaNovoCliente(String usuario, ClienteRequest clienteRequest) {
        log.info("[inicia] ClienteApplicationService - criaNovoCliente");
        var cliente = new Cliente(clienteRequest);
        clienteRepository.salva(cliente);
        log.info("[finaliza] ClienteApplicationService - criaNovoCliente");
        return ClienteIdResponse.builder().idCliente(cliente.getIdCliente()).build();
    }

    @Override
    public Cliente consultaCliente(String emailUsuario, UUID idCliente) {
        log.info("[inicia] ClienteApplicationService - consultaCliente");
        Usuario usuarioPorEmail = usuarioRepository.buscaUsuarioPorEmail(emailUsuario);
        log.info("[usuarioPorEmail] {}", usuarioPorEmail);
        Cliente cliente = clienteRepository.buscaClientePorId(idCliente)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
        log.info("[finaliza] ClienteApplicationService - consultaCliente");
        return cliente;
    }

    @Override
    public void alteraCliente(String emailUsuario, UUID idCliente, EditaClienteRequest clienteRequest) {
        log.info("[inicia] ClienteApplicationService - alteraCliente");
        Cliente cliente = consultaCliente(emailUsuario, idCliente);
        cliente.altera(clienteRequest);
        clienteRepository.salva(cliente);
        log.info("[finaliza] ClienteApplicationService - alteraCliente");
    }

    @Override
    public void deletaCliente(String usuario, UUID idCliente) {
        log.info("[inicia] ClienteApplicationService - deletaCliente");
        Cliente clienteDeletado = consultaCliente(usuario, idCliente);
        clienteRepository.deletaClientePorId(clienteDeletado);
        log.info("[finaliza] ClienteApplicationService - deletaCliente");
    }
}
