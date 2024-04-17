package dev.wakandaacademy.controledelivery.entrega.infra;

import dev.wakandaacademy.controledelivery.entrega.application.repository.EntregaRepository;
import dev.wakandaacademy.controledelivery.entrega.domain.Entrega;
import dev.wakandaacademy.controledelivery.handler.APIException;
import dev.wakandaacademy.controledelivery.pedido.domain.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class EntregaInfraRepository implements EntregaRepository {

    private final EntregaMongoDBRepository entregaMongoDBRepository;
    private final MongoTemplate mongoTemplate;

    @Override
    public Entrega salva(Entrega entrega) {
        log.info("[inicia] EntregaInfraRepository - salva");
        try {
            entregaMongoDBRepository.save(entrega);
        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Entrega já cadastrada", e);
        }
        log.info("[finaliza] EntregaInfraRepository - salva");
        return entrega;
    }

    @Override
    public boolean verificaSePedidoPossuiEntrega(UUID idPedido) {
        log.info("[inicia] EntregaInfraRepository - verificaSePedidoPossuiEntrega");
        boolean pedidoPorId = entregaMongoDBRepository.existsByIdPedido(idPedido);
        log.info("[finaliza] EntregaInfraRepository - verificaSePedidoPossuiEntrega");
        return pedidoPorId;
    }

    @Override
    public void alteraPedidoParaConfirmado(UUID idPedido) {
        log.info("[inicia] EntregaInfraRepository - alteraPedidoParaConfirmado");
        Query query = new Query();
        query.addCriteria(Criteria.where("idPedido").is(idPedido));
        Update update = new Update();
        update.set("status", "CONFIRMADO");
        mongoTemplate.updateFirst(query, update, Pedido.class);
        log.info("[finaliza] EntregaInfraRepository - alteraPedidoParaConfirmado");
    }

    @Override
    public Optional<Entrega> buscaEntregaPorId(UUID idEntrega) {
        log.info("[inicia] EntregaInfraRepository - buscaEntregaPorId");
        Optional<Entrega> entregaPorId = entregaMongoDBRepository.findById(idEntrega);
        log.info("[finaliza] EntregaInfraRepository - buscaEntregaPorId");
        return entregaPorId;
    }
}
