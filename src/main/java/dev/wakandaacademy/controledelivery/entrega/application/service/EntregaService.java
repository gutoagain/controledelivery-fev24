package dev.wakandaacademy.controledelivery.entrega.application.service;

import dev.wakandaacademy.controledelivery.entrega.application.api.EditaEntregaRequest;
import dev.wakandaacademy.controledelivery.entrega.application.api.EntregaIdResponse;
import dev.wakandaacademy.controledelivery.entrega.application.api.EntregaRequest;
import dev.wakandaacademy.controledelivery.entrega.domain.Entrega;

import java.util.UUID;

public interface EntregaService {
    EntregaIdResponse criaNovaEntrega(String usuario, EntregaRequest entregaRequest);
    Entrega consultaEntrega(String emailUsuario, UUID idEntrega);
    void alteraDadosEntrega(String usuario, UUID idEntrega, EditaEntregaRequest entregaRequest);
    void deletaEntrega(String usuario, UUID idEntrega);
}
