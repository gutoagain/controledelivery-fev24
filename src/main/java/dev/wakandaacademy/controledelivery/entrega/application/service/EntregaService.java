package dev.wakandaacademy.controledelivery.entrega.application.service;

import dev.wakandaacademy.controledelivery.entrega.application.api.EntregaIdResponse;
import dev.wakandaacademy.controledelivery.entrega.application.api.EntregaRequest;

public interface EntregaService {
    EntregaIdResponse criaNovaEntrega(String usuario, EntregaRequest entregaRequest);
}
