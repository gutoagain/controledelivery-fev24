package dev.wakandaacademy.controledelivery.pedido.application.service;

import dev.wakandaacademy.controledelivery.entrega.application.repository.EntregaRepository;
import dev.wakandaacademy.controledelivery.entrega.application.service.EntregaService;
import dev.wakandaacademy.controledelivery.handler.APIException;
import dev.wakandaacademy.controledelivery.pedido.application.api.EditaPedidoRequest;
import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoDetalhadoResponse;
import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoIdResponse;
import dev.wakandaacademy.controledelivery.pedido.application.api.PedidoRequest;
import dev.wakandaacademy.controledelivery.pedido.application.repository.PedidoRepository;
import dev.wakandaacademy.controledelivery.pedido.domain.Pedido;
import dev.wakandaacademy.controledelivery.usuario.application.repository.UsuarioRepository;
import dev.wakandaacademy.controledelivery.usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class PedidoApplicationService implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;
    private final EntregaRepository entregaRepository;
    private final EntregaService entregaService;

    @Override
    public PedidoIdResponse criaNovoPedido(String usuario, PedidoRequest pedidoRequest) {
        log.info("[inicia] PedidoApplicationService - criaNovoPedido");
        int posicaoDoNovoPedido = pedidoRepository.contarPedidosDoCliente(pedidoRequest.getIdCliente());
        Pedido pedidoCriado = pedidoRepository.salva(new Pedido(pedidoRequest, posicaoDoNovoPedido));
        log.info("[finaliza] PedidoApplicationService - criaNovoPedido");
        return PedidoIdResponse.builder().idPedido(pedidoCriado.getIdPedido()).build();
    }

    @Override
    public Pedido consultaPedido(String emailUsuario, UUID idPedido) {
        log.info("[inicia] PedidoApplicationService - consultaPedido");
        Usuario usuarioPorEmail = usuarioRepository.buscaUsuarioPorEmail(emailUsuario);
        log.info("[usuarioPorEmail] {}", usuarioPorEmail);
        Pedido pedido = pedidoRepository.buscaPedidoPorId(idPedido)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pedido não encontrado!"));
        log.info("[finaliza] PedidoApplicationService - consultaPedido");
        return pedido;
    }

    @Override
    public List<PedidoDetalhadoResponse> listaPedidosCliente(String usuario, UUID idCliente) {
        log.info("[inicia] - PedidoApplicationService - listaPedidosCliente");
        List<Pedido> listaPedido = pedidoRepository.listaPedidosCliente(idCliente);
        log.info("[finaliza] - PedidoApplicationService - listaPedidosCliente");
        return PedidoDetalhadoResponse.converte(listaPedido);
    }

    @Override
    public void alteraPedido(String usuario, UUID idPedido, EditaPedidoRequest pedidoRequest) {
        log.info("[inicia] - PedidoApplicationService - alteraPedido");
        Pedido pedido = consultaPedido(usuario, idPedido);
        pedido.altera(pedidoRequest);
        pedidoRepository.salva(pedido);
        log.info("[finaliza] - PedidoApplicationService - alteraPedido");
    }

    @Override
    public void deletaPedido(String usuario, UUID idPedido) {
        log.info("[inicia] PedidoApplicationService - deletaPedido");
        Pedido pedidoDeletado = consultaPedido(usuario, idPedido);
        entregaRepository.deletaEntregaPorIdPedido(idPedido);
        pedidoRepository.deletaPedidoPorId(pedidoDeletado);
        log.info("[finaliza] PedidoApplicationService - deletaPedido");
    }

    @Override
    public void mudaStatusParaEnviado(String usuario, UUID idPedido) {
        log.info("[inicia] PedidoApplicationService - mudaStatusParaEnviado");
        Pedido pedido = consultaPedido(usuario, idPedido);
        pedido.mudaStatusParaEnviado();
        entregaService.mudaStatusEntregaParaEmAndamentoPorIdPedido(idPedido);
        pedidoRepository.salva(pedido);
        log.info("[finaliza] PedidoApplicationService - mudaStatusParaEnviado");
    }

    @Override
    public void mudaStatusParaEntregue(String usuario, UUID idPedido) {
        log.info("[inicia] PedidoApplicationService - mudaStatusParaEntregue");
        Pedido pedido = consultaPedido(usuario, idPedido);
        pedido.mudaStatusParaEntregue();
        entregaService.mudaStatusEntregaParaConcluidaPorIdPedido(idPedido);
        pedidoRepository.salva(pedido);
        log.info("[finaliza] PedidoApplicationService - mudaStatusParaEntregue");
    }

    @Override
    public void mudaStatusParaCancelado(String usuario, UUID idPedido) {
        log.info("[inicia] PedidoApplicationService - mudaStatusParaCancelado");
        log.info("[finaliza] PedidoApplicationService - mudaStatusParaCancelado");
    }
}
